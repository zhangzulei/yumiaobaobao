package com.yumiaobaobao.app.common.utils.aliyunossutil;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2019/04/04.
 * 查看aliyunOSS目录下所有文件
 */
public class AliyunLookListUtil {

    private static  final Logger logger = LoggerFactory.getLogger(AliyunLookListUtil.class);

    public static List<String> getObjectList(String bucketName,String OSSfolder){
        List<String> listRe = new ArrayList<>();
        try {
            logger.info("===========>查询文件名列表");

            OSSClient ossClient = new OSSClient(AliyunOssParameter.endpoint, AliyunOssParameter.accessKeyId, AliyunOssParameter.accessKeySecret);

            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

            listObjectsRequest.setPrefix(OSSfolder+"/");

            ObjectListing list = ossClient.listObjects(listObjectsRequest);
            for(OSSObjectSummary objectSummary : list.getObjectSummaries()){
                listRe.add(objectSummary.getKey());
                logger.info(objectSummary.getKey());
            }

            logger.info("CommonPrefixes:");
            for (String commonPrefix : list.getCommonPrefixes()) {
                logger.info(commonPrefix);
            }
            return listRe;
        }catch (Exception ex){
            logger.info("==========>查询列表失败",ex);
            return new ArrayList<>();
        }
    }
}
