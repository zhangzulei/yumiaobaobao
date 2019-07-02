package com.yumiaobaobao.app.user.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import com.yumiaobaobao.app.moremenu.myattention.personal.service.UserFollowService;
import com.yumiaobaobao.app.moremenu.mycollection.entity.Collection;
import com.yumiaobaobao.app.moremenu.mycollection.service.CollectionService;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.nice_detail;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/11.
 */
@RestController
@Component
@Api(tags = "用户操作 1.根据手机号查询用户 2.根据用户ID查询用户 3.根据芋苗宝宝号查询 4.获取关注，粉丝，获赞收藏数量")
public class UserRelatedController {

    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private UserFollowService userFollow;
    @Autowired
    private com.yumiaobaobao.app.user.like.service.Nice_DetailService niceDetailService;
    @Autowired
    private CollectionService collectionService;

    @ApiOperation(value = "根据手机号查询用户",notes = "根据手机号查询用户 严格依据一号一用户 Message 0=>该手机未注册 -1=>已知错误  ")
    @RequestMapping(value="/byUserPhoneToUserInfo",method = RequestMethod.GET)
    public String byUserPhoneToUserInfo(@ApiParam("手机号") @RequestParam("userPhone")String userPhone){
        UserInfo userinfo = null;
        try {
            userinfo = userUpdateService.byUserPhoneToUserInfo(userPhone);
            if(userinfo==null){
                return "{\"Message\":\"0\"}";
            }

        } catch (Exception e) {
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(userinfo)+"}";

    }


    @ApiOperation(value = "根据用户ID查询用户",notes = "根据用户ID查询用户 严格依据一号一用户 Message 0=>该用户不存在 -1=>出现错误  ")
    @RequestMapping(value="/selectUserInfoByUserId",method = RequestMethod.GET)
    public String selectUserInfoByUserId(@ApiParam("用户ID") @RequestParam("userId")String userId){
        UserInfo userinfo = null;
        try {
            userinfo = userUpdateService.selectUserInfoByUserId(userId);
            if(userinfo==null){
                return "{\"Message\":\"0\"}";
            }

        } catch (Exception e) {
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(userinfo)+"}";

    }

    @ApiOperation(value = "根据芋苗宝宝号查询",notes = "根据芋苗宝宝号查询 严格依据一号一用户 Message 0=>该用户不存在 -1=>已知错误  ")
    @RequestMapping(value="/selecByYmMiaoAccoent",method = RequestMethod.GET)
    public String selecByYmMiaoAccoent(@ApiParam("芋苗宝宝号") @RequestParam("mMiaoAccoent")String ymMiaoAccoent){
        UserInfo userinfo = null;
        try {
            userinfo = userUpdateService.selecByYmMiaoAccoent(ymMiaoAccoent);
            if(userinfo==null){
                return "{\"Message\":\"0\"}";
            }
        } catch (Exception e) {
            return "{\"Message\":\"-1\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(userinfo)+"}";

    }

    @ApiOperation(value = "查询用户的关注，粉丝，获赞与收藏",notes = "查询用户的关注，粉丝，获赞与收藏 " +
            "Message 0=>查询出现错误  1=>成功    attention(关注) fans(粉丝) cn(收藏点赞数)")
    @RequestMapping(value="/selectAllByUserid",method = RequestMethod.GET)
    public String selectAllByUserid(@ApiParam("用户ID") @RequestParam("userId")String userId){
        Map<String,Object> map = new HashMap<String,Object>();
        //关注
       try {
           List<UserFollow> list = userFollow.selectFollwAttention(userId);
           if (null == list || list.size() == 0) {
               map.put("attention", 0);
           } else {
               map.put("attention", list.size());
           }
           //粉丝
           List<UserFollow> userFollowlist = userFollow.selectAttention(userId);
           if (null == userFollowlist || userFollowlist.size() == 0) {
               map.put("fans", 0);
           } else {
               map.put("fans", userFollowlist.size());
           }
           //获赞收藏
           List<nice_detail> textByUserid = niceDetailService.getTextByUserid(userId);
           List<Collection> collections = collectionService.selectCollectionByUserid(userId);
           int size = textByUserid.size();
           int sizes = collections.size();
           map.put("cn", size + sizes);
       }catch (Exception e){
           return "{\"Message\":\"0\"}";
       }
        return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(map)+"}";
    }
}
