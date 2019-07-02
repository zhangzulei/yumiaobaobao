package com.yumiaobaobao.app.common.utils.aliyunossutil;

import com.aliyun.oss.OSSClient;
import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WH on 2019/04/04.
 * 用于aliyunOSS删除工具类
 */
public class AliyunOSSDeleteUtil {

    private static final Logger logger = LoggerFactory.getLogger(AliyunOSSDeleteUtil.class);


    /**
     * 删除Object
     * @param fileKey
     * @return
     */
    public static String deleteBlog(String fileKey){
        logger.info("=========>OSS文件删除开始");
        String endpoint= AliyunOssParameter.endpoint;
        String accessKeyId= AliyunOssParameter.accessKeyId;
        String accessKeySecret= AliyunOssParameter.accessKeySecret;
        String bucketName= AliyunOssParameter.bucketName;


        try {
            //创建oss实例
            OSSClient ossClient=new OSSClient(endpoint,accessKeyId,accessKeySecret);
            if(!ossClient.doesBucketExist(bucketName)){
                logger.info("==============>您的Bucket不存在");
                return "BucketIsNull";
            }else {
                logger.info("==============>开始删除Object");
                ossClient.deleteObject(bucketName,fileKey);
                logger.info("==============>Object删除成功："+fileKey);
                return fileKey;
            }
        }catch (Exception ex){
            logger.info("删除Object失败",ex);
            return "erro";
        }
    }
}
