package com.yumiaobaobao.app.moremenu.Feedback.controller;

import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import com.yumiaobaobao.app.common.utils.aliyunossutil.AliyunOSSUpLoadUtil;
import com.yumiaobaobao.app.common.utils.aliyunossutil.LocalDelete;
import com.yumiaobaobao.app.common.utils.util.RandomNumberUtil;
import com.yumiaobaobao.app.moremenu.Feedback.service.OpinionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WH on 2019/03/27.
 */
@RestController
@Component
@Api(tags = "意见反馈   1.发布意见反馈 2.便签申述")
public class OpinionController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OpinionService opinionService;

    @ApiOperation(value = "新增意见反馈", notes = "新增意见反馈  Message 0提交失败  1 提交成功 -1未知错误 -2选择文件为空")
    @RequestMapping(value = "/addopinion", method = RequestMethod.POST)
    public String addopinion(
            @ApiParam(value = "用户id") @RequestParam("userid") String userid,
            @ApiParam(value = "1闪退卡顿 2拍摄发布 3个人中心 4其他 5功能建议") @RequestParam("questiontype") String questiontype,
            @ApiParam(value = "问题描述") @RequestParam("problemdescription") String problemdescription,
            @ApiParam(value = "问题相关图片") @RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    String substr=filename.substring(filename.lastIndexOf(".") + 1);
                    //重新定义文件名
                    String newName = RandomNumberUtil.randomnumberEnglish(8);
//                        String newName = Math.random()*1000000 +"."+ substr;

                    File newFile = new File(newName);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_FEEDBACK,userid);
                    if (uploadUrl == null) {return "{\"Message\":\"-2\"}";}
                    File file1 = new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + filename);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                    Map<String, Object> map = new HashMap<>();
                    map.put("userid", userid);
                    map.put("questiontype", questiontype);
                    map.put("problemdescription", problemdescription);
                    map.put("probleimg", uploadUrl);
                    if (opinionService.addopinion(map) <= 0) {
                        return "{\"Message\": \"0\"}";
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\":\"1\"}";
    }


    @RequestMapping(value = "/addAppeal", method = RequestMethod.POST)
    @ApiOperation(value = "便签申诉",notes = "便签申诉  Message 0提交失败  1 提交成功 -1未知错误")
    public String addAppeal(
            @ApiParam(value = "申诉类型 1 其它笔记违规申述 0商业违规推广申诉 ") @RequestParam("appealtype") String appealtype,
            @ApiParam(value = "申诉描述") @RequestParam("Details") String Details,
            @ApiParam(value = "申诉相关图片") @RequestParam(value = "Detailsimg") MultipartFile file,
            @ApiParam(value = "对应的申诉便签id") @RequestParam("notesid") String notesid,
            @ApiParam(value = "申诉人") @RequestParam("notespeople") String notespeople
    ) {
        String filename = file.getOriginalFilename();
        try {
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    String substr=filename.substring(filename.lastIndexOf(".") + 1);
                    //重新定义文件名
                    String newName = RandomNumberUtil.randomnumberEnglish(8);
//                        String newName = Math.random()*1000000 +"."+ substr;

                    File newFile = new File(newName);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_FEEDBACK,notespeople);
                    if (uploadUrl == null) {return "{\"Message\":\"-2\"}";}
                    File file1 = new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + filename);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                    Map<String,Object> map =  new HashMap<>();
                    map.put("appealtype",appealtype);
                    map.put("Details",Details);
                    map.put("Detailsimg",uploadUrl);
                    map.put("notesid",notesid);
                    map.put("notespeople",notespeople);
                    if(opinionService.addNote(map)<=0){
                        return "{\"Message\": \"0\"}";
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\": \"1\"}";
    }
}
