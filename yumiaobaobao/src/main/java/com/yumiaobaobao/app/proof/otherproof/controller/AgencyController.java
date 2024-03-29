package com.yumiaobaobao.app.proof.otherproof.controller;

import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import com.yumiaobaobao.app.common.utils.aliyunossutil.AliyunOSSUpLoadUtil;
import com.yumiaobaobao.app.common.utils.aliyunossutil.LocalDelete;
import com.yumiaobaobao.app.common.utils.util.RandomNumberUtil;
import com.yumiaobaobao.app.proof.otherproof.service.AgencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WH on 2019/04/23.
 */

@RestController
@Component
@Api(tags = "其他机构认证  1.新增其他机构认证")
public class AgencyController {


    @Autowired
    private AgencyService agencyService;

    private Map<String,Object> map;

    @ApiOperation(value = "新增其他机构认证",notes = "新增其他机构认证  Message 0=>图片上传失败 -1提交失败 -2系统异常 1提交成功")
    @RequestMapping(value = "/addAgency",method = RequestMethod.POST)
    public String addAgency(
            @ApiParam("用户Id") @RequestParam("userId")String userId,
            @ApiParam("机构类型") @RequestParam("agencyType")String agencyType,
            @ApiParam("机构名")     @RequestParam("agencyName")String agencyName,
            @ApiParam("机构地址") @RequestParam("agencyAddress")String agencyAddress,
            @ApiParam("机构联系人") @RequestParam("agencyContact")String agencyContact,
            @ApiParam("联系手机号或者邮箱") @RequestParam("agencyPhoneEmail")String agencyPhoneEmail,
            @ApiParam("入住说明函")   @RequestParam("CheCkInLetter")MultipartFile CheckinLetter,
            @ApiParam("营业执照") @RequestParam(value = "businessLicense",required = false)MultipartFile  businessLicense,
            @ApiParam("其他证书") @RequestParam(value = "OtherCerTiFiCate",required = false)MultipartFile OtherCerTiFiCate
    ){
        map = new ConcurrentHashMap<>();
        try {
            if(null !=CheckinLetter){
                String filename = CheckinLetter.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    String substr = filename.substring(filename.lastIndexOf(".") + 1);
                    //重新定义文件名
                    String newName = RandomNumberUtil.randomnumberEnglish(8);
//                        String newName = Math.random()*1000000 +"."+ substr;

                    File newFile = new File(newName);
//                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(CheckinLetter.getBytes());
                    os.close();
                    CheckinLetter.transferTo(newFile);
                    //上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_SHOPPROOF,userId);
                    if (uploadUrl == null || uploadUrl=="") {return "{\"Message\":\"0\"}";}
                    map.put("Checkinletter",uploadUrl);//存入对应数据库的map
                    File file1 = new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + newName);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                }
            }


            if(null !=businessLicense){
                String filename = businessLicense.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(businessLicense.getBytes());
                    os.close();
                    businessLicense.transferTo(newFile);
                    //上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_SHOPPROOF,userId);
                    if (uploadUrl == null || uploadUrl=="") {return "{\"Message\":\"0\"}";}
                    map.put("businesslicense",uploadUrl);//存入对应数据库的map
                    File file1 = new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + filename);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                }
            }
            if(null !=OtherCerTiFiCate){
                String filename = OtherCerTiFiCate.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(OtherCerTiFiCate.getBytes());
                    os.close();
                    OtherCerTiFiCate.transferTo(newFile);
                    //上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_SHOPPROOF,userId);
                    if (uploadUrl == null || uploadUrl=="") {return "{\"Message\":\"0\"}";}
                    map.put("OtherCertificate",uploadUrl);//存入对应数据库的map
                    File file1 = new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + filename);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                }
            }
            map.put("userId",userId);
            map.put("agencyType",agencyType);
            map.put("agencyName",agencyName);
            map.put("agencyAddress",agencyAddress);
            map.put("agencyContact",agencyContact);
            map.put("agencyPhoneEmail",agencyPhoneEmail);

            if(agencyService.addAgency(map)<=0){
                return "{\"Message\":\"-1\"}";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"Message\":\"-2\"}";
        }
        return "{\"Message\":\"1\"}";
    }


}
