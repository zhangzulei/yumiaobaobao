package com.yumiaobaobao.app.shop.shopupdate.controller;

import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import com.yumiaobaobao.app.common.utils.aliyunossutil.AliyunOSSUpLoadUtil;
import com.yumiaobaobao.app.common.utils.aliyunossutil.LocalDelete;
import com.yumiaobaobao.app.shop.shopupdate.service.ShopUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by WH on 2019/04/10.
 */

@RestController
@Component
@Api(tags = "商户操作 1.新增商户 2.上传商铺封面 ")
public class ShopUpdateController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShopUpdateService shopUpdateService;


    @ApiOperation(value = "新增商户", notes = "新增商户  Message  0=>增加失败 1=>成功")
    @RequestMapping(value = "/addShop", method = RequestMethod.GET)
    public String addShop(
        @ApiParam("商户名") @RequestParam("shopName") String shopName,
        @ApiParam("所属商圈") @RequestParam("tradingArea")    Integer tradingArea,
        @ApiParam("地址") @RequestParam("schoolAddress")    String schoolAddress,
        @ApiParam("手机号") @RequestParam("schoolPhone")    String schoolPhone,
        @ApiParam("座机") @RequestParam("schoolColl")    String schoolColl,
        @ApiParam("上班时间") @RequestParam("schoolOpenTime") String schoolOpenTime,
        @ApiParam("下班时间") @RequestParam("sendTime")    String sendTime
    ){
        System.out.println("时间String"+schoolOpenTime);
        int shopList = shopUpdateService.addShop(shopName,tradingArea,schoolAddress, schoolPhone, schoolColl, schoolOpenTime, sendTime);
        if(shopList<=0){
            return "{\"Message\": \"0\"}";
        }
         return "{\"Message\": \"1\"}";
    }


    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiOperation(value = "文件上传 商户选择/更改封面使用 选择文件然后提交",
            notes = "文件上传 商户选择/更改封面使用 选择文件然后提交  Message 0=>没有选择文件/OSS仓库有误  1=>成功  -1=>未知异常")
    public String uploadPicture(
            @ApiParam("选择文件") @RequestParam("file") MultipartFile file, Model model,
            @ApiParam("商户id") @RequestParam("shopId") String shopId) {
        logger.info("文件上传");
        String filename = file.getOriginalFilename();
        logger.info(filename);
        try {
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                    String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_shopimg,shopId);
                    if(uploadUrl==null){
                        return "{\"Message\":\"0\"}";
                    }
                    //将用户选择的图片存入数据库
                    shopUpdateService.shopHeadImg(uploadUrl,shopId);
                    logger.info(uploadUrl);
                    model.addAttribute("url",uploadUrl);
                    // 删除上传的文件  上传成功后会在项目根目录存在一张图片
                    logger.info("=======开始删除根目录的副本========");
                    File file1=new File("");
                    String s = file1.getAbsolutePath();
                    LocalDelete.delete(s + "\\" + filename);
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\":\"1\"}";
    }
}
