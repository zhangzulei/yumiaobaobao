package com.yumiaobaobao.app.common.utils.aliyunossutil;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


/**
 * Created by WH on 2019/04/04.
 * 用于aliyunOSS文件下载
 */
public class AliyunDownloadUtil {

    private static final Logger logger = LoggerFactory.getLogger(AliyunDownloadUtil.class);

    public static String downloadFile(String objectName, String localFileName) {
        try {
            OSSClient ossClient =new OSSClient(AliyunOssParameter.endpoint, AliyunOssParameter.accessKeyId, AliyunOssParameter.accessKeySecret);

            ossClient.getObject(new GetObjectRequest(AliyunOssParameter.bucketName, objectName), new File(localFileName));
            if(!ossClient.doesBucketExist(AliyunOssParameter.bucketName)){
                logger.info("==============>您的Bucket不存在");
                return "BucketIsNull";
            }else {
                logger.info("==============>开始下载Object");
                ossClient.deleteObject(AliyunOssParameter.bucketName,objectName);
                logger.info("==============>Object下载成功："+objectName);
                return objectName;
            }
        }catch (Exception ex){
            logger.info("下载Object失败",ex);
            return "erro";
        }
    }
}
