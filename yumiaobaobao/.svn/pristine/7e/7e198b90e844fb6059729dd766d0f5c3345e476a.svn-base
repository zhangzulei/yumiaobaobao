package com.yumiaobaobao.app.common.utils.aliyunossutil;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by WH on 2019/04/03.
 * 用于aliyunOSS上传工具类
 */
@org.springframework.stereotype.Component
public class AliyunOSSUpLoadUtil {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUpLoadUtil.class);

    private static String FILE_URL;


    /**
     * 上传文件。
     */
    public static String upLoad(File file,String fileHost,String userId) {
        boolean isImage = true;
        // 判断所要上传的图片是否是图片，图片可以预览，其他文件不提供通过URL预览
        try {
            Image image = ImageIO.read(file);
            isImage = image == null ? false : true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("------OSS文件上传开始--------文件名:" + file.getName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        // 判断文件
        if (file == null) {
            return null;
        }
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(AliyunOssParameter.endpoint, AliyunOssParameter.accessKeyId, AliyunOssParameter.accessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(AliyunOssParameter.bucketName)) {
                ossClient.createBucket(AliyunOssParameter.bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(AliyunOssParameter.bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            String fileUrl = fileHost + "/" + (userId+"/"+dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            if (isImage) {
                FILE_URL = "https://" + AliyunOssParameter.bucketName + "." + AliyunOssParameter.endpoint + "/" + fileUrl;
            } else {
                FILE_URL = "非图片，不可预览。文件路径为：" + fileUrl;
            }
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(AliyunOssParameter.bucketName, fileUrl, file));
            ossClient.setBucketAcl(AliyunOssParameter.bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                logger.info("------OSS文件上传成功------路径为:" + fileUrl);
            }
        } catch (OSSException oe) {
            logger.error(oe.getMessage());
        } catch (ClientException ce) {
            logger.error(ce.getErrorMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return FILE_URL;
    }
}
