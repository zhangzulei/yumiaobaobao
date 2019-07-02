package com.yumiaobaobao.app.user.usermember.controller;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.user_level_info;
import com.yumiaobaobao.app.user.usermember.service.user_level_infoService;
import com.yumiaobaobao.app.user.userupdate.service.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */

@RestController
@Component
@Api(tags = "会员功能：1.登录增加积分  2.没有发布文章减少积分")
public class UserMemberController {
    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private user_level_infoService user_level_infoService;

    @RequestMapping(value = "loginAddScore",method = RequestMethod.GET)
    @ApiOperation(value = "登录之后增加5积分",notes = "登录之后增加5积分 Message => 0 没有数据  " +
            "-1 更新积分失败 -2 更新会员失败 1 成功")
    public String loginAddScore(@ApiParam("用户id") @RequestParam("userid") String userid){
        UserInfo userInfo = userUpdateService.selectUserInfoByUserId(userid);
        if(userInfo==null){
            return  "{\"Message\":\"0\"}";
        }
        LocalDateTime last_login_time = userInfo.getLastLoginTime();
        SimpleDateFormat sdfLogin = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        String lastTime = sdfLogin.format(last_login_time);
        String nowTime = sdfLogin.format(currentTime);
        if(!nowTime.equals(lastTime)){
            int i = user_level_infoService.updateScoreByLogin(Integer.valueOf(userid));
            if(i==0){
                return "{\"Message\":\"-1\"}";
            }
        }
        List<user_level_info> byUserid = user_level_infoService.findByUserid(Integer.valueOf(userid));
        Integer s = byUserid.get(0).getScore();
        if(s>=1000){
            int o = userUpdateService.updateVip(Integer.valueOf(userid));
            if(o==0){
                return "{\"Message\":\"-2\"}";
            }
        }
        return "{\"Message\":\"1\"}";
    }

    @RequestMapping(value = "reduceByScore",method = RequestMethod.GET)
    @ApiOperation(value = "没有发布文章减少35积分",notes = "没有发布文章减少35积分 Message => 0 没有数据  " +
            "-1 更新积分失败 -2 更新会员失败 1 成功")
    public String  reduceByScore(@ApiParam("用户id") @RequestParam("userid") String userid){
        UserInfo userInfo = userUpdateService.selectUserInfoByUserId(userid);
        if(userInfo==null){
            return  "{\"Message\":\"0\"}";
        }
        LocalDateTime last_login_time = userInfo.getLastLoginTime();
        Date time = new Date();
        Date dates = DateUtils.convertLDTToDate(last_login_time);
        int days = (int) ((time.getTime() - dates.getTime()) / (1000*3600*24));
        if(days>=1){
            int i = user_level_infoService.reduceScore(Integer.valueOf(userid));
            if(i==0){
                return  "{\"Message\":\"-1\"}";
            }
            List<user_level_info> byUserid = user_level_infoService.findByUserid(Integer.valueOf(userid));
            Integer score = byUserid.get(0).getScore();
            if(score<1000){
                int i1 = userUpdateService.loseVip(Integer.valueOf(userid));
                if(i1==0){
                    return "{\"Message\":\"-2\"}";
                }
            }
        }
        return "{\"Message\":\"1\"}";
    }
}
