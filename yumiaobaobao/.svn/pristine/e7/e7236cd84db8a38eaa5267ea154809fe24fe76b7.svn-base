package com.yumiaobaobao.app.proof.userproof.controller;

import com.yumiaobaobao.app.common.utils.aliyunauthentication.AliyunAuthenticationUtil;
import com.yumiaobaobao.app.proof.userproof.entity.PaperWork;
import com.yumiaobaobao.app.proof.userproof.service.UserProofService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WH on 2019/04/16.
 */

@RestController
@Component
@Api(tags = "后台人员使用 1.对用户身份证进行审核  2.根据认证号查询审核结果  " )
public class AdminController {

    @Autowired
    private UserProofService userProofService;




    @ApiOperation(value = "审核居民身份证证件" ,notes = "审核居民身份证证件 Message 0=用户未审核")
    @RequestMapping(value = "Review",method = RequestMethod.GET)
    public String Review(@ApiParam("用户ID") @RequestParam("userId")String userId){
        PaperWork paper = userProofService.selectPaperWork(userId);
        if(paper==null){
            return "{\"Message\":\"0\"}";
        }
         return AliyunAuthenticationUtil.AliyunAuthentication(
                paper.getPaperworkNumber(),
                paper.getPaperworkName(),
                paper.getPaperworkPhotoSelfie(),
                paper.getPaperworkPhotofacade(),
                paper.getPaperworkPhotoobverse(),
                paper.getTicketId()
                );
        /**
         * {
         "code":"1",
         "data":{
         "verifyStatus":{
         "auditConclusions":"",/ "auditConclusions":"不通过原因（包括但不限于以下几种情况）：1、身份证照片模糊，光线问题造成字体无法识别；2、身份证照片信息与认证提交信息不一致；3、提交的照片非身份证照片。建议：请按引导提交本人有效身份证照片。",
         "authorityComparisonScore":97,//认证过程中所提交的人脸照片和权威数据的比对分，取值范围为[0,100]。
         "similarityScore":97,//认证过程中所提交的人脸照片和身份证上的头像的相似程度分值。取值范围为[0,100]，分数越大相似度越高。
         "statusCode":1  //认证状态
         }
         },
         "requestId":"***-***-******-****",
         "success":true
         }
         */

        /***
         *  -1： 未认证。表示没有提交记录。
             0： 认证中。表示已提交认证，系统正在审核认证资料。
             1： 认证通过。表示最近一次提交的认证资料已通过审核，当前认证任务完结。
             2： 认证不通过。表示最近一次提交的认证资料未通过审核，当前认证任务还可以继续发起提交。
         */

    }

    @ApiOperation(value = "根据认证号查询居民身份证证件审核结果  适用于当前审核没有马上出结果的情况" ,notes = "根据认证号查询审核结果 适用于当前审核没有马上出结果的情况")
    @RequestMapping(value = "/GetStatus",method = RequestMethod.GET)
    public String GetStatus(
            @ApiParam("审核号") @RequestParam("TicketId") String TicketId,
            @ApiParam("验证场景  开发人员设置 默认为amdin") @RequestParam(value = "Biz",defaultValue = "admin")String Biz){
        return AliyunAuthenticationUtil.GetStatus(TicketId, Biz);
    }

}
