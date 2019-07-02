package com.yumiaobaobao.app.taiking.taikingupdate.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yumiaobaobao.app.moremenu.myattention.taiking.service.TaiKingFollowService;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.taiking.entity.talking;
import com.yumiaobaobao.app.taiking.taikingupdate.service.TaiKingUpdateService;
import com.yumiaobaobao.app.user.comment.service.Serviceindex_discover;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.userupdate.service.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/10.
 */
@RestController
@Component
@Api(tags = "专题操作 2.根据专题id查询专题  3.查看专题下的便签（推荐，最新，最热）4.推荐专题（三个）")
public class TaiKingUpdateController {

    @Autowired
    private TaiKingUpdateService taiKingUpdateService ;
    @Autowired
    private Serviceindex_discover serviceindex_discover;
    @Autowired
    private TaiKingFollowService taiKingFollowService;
    @Autowired
    private UserUpdateService userUpdateService;

    private  Map<String,Object> talkingMap;

    private  List<Map<String,Object>> talkingList;

/*    @RequestMapping(value ="/addTalKing" ,method = RequestMethod.POST)
    @ApiOperation(value="新增专题", notes="新增专题 Message:0 新增失败 1新增成功")
    public String addTalKing(
            @ApiParam("专题标签") @RequestParam("TalKingTitle")String TalKingTitle,
            @ApiParam("专题描述") @RequestParam("TalKingNote")String TalKingNote

    ){
        Map<String,Object> map = new HashMap<>();
        map.put("TalKingTitle",TalKingTitle);
        map.put("TalKingNote",TalKingNote);
        if(taiKingUpdateService.addTalKing(map)<1){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\"}";
    }*/

    @RequestMapping(value ="/allTalKing" ,method = RequestMethod.GET)
    @ApiOperation(value="查询所有专题", notes="查询所有专题 Message:0 没有数据 1查询成功")
    public String allTalKing(){
        List<talking> talkings = taiKingUpdateService.allTalking();
        if(talkings ==null|| talkings.size()<=0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+ JSON.toJSONString(talkings,SerializerFeature.DisableCircularReferenceDetect)+"}";
    }

    @RequestMapping(value ="/recommendNotes" ,method = RequestMethod.GET)
    @ApiOperation(value="查看专题下的便签（推荐，最新，最热）", notes="查看专题下的便签（推荐，最新，最热）" +
            " Message:0 没有数据 1查询成功   type=1 查推荐  type=2 查最热  type=3 查最新")
    public String recommendNotes(@ApiParam("专题id") @RequestParam("talkingid")String talkingid,
                                 @ApiParam("查询类型") @RequestParam("type")String type){
        List<index_discover> index_discovers = new ArrayList<index_discover>();
        if (type=="1"){
            index_discovers = serviceindex_discover.recommendNotes(Integer.valueOf(talkingid));
        }else if(type=="2"){
            index_discovers = taiKingUpdateService.selectHoeTalking(talkingid);
        }else{
            index_discovers = taiKingUpdateService.selectNewTalking(talkingid);
        }
        if (index_discovers ==null|| index_discovers.size()<=0) {
            return "{\"Message\":\"0\"}";
        }
        for (index_discover in : index_discovers) {
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(in.getUserid());
            in.setUsername(userInfo.getUsername());
            in.setAvatarimg(userInfo.getAvatarimg());
        }
        return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(index_discovers,SerializerFeature.DisableCircularReferenceDetect)+"}";
    }

  /*  @RequestMapping(value ="/selectNewTalking" ,method = RequestMethod.GET)
    @ApiOperation(value="查询最新专题", notes="查询最新专题 Message:0 没有数据 1查询成功")
    public String selectNewTalking(){
        List<talking> taiKings = taiKingUpdateService.selectNewTalking();
        if (taiKings==null||taiKings.size()<=0) {
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"0\",\"Data\":"+JSON.toJSONString(taiKings)+"}";
    }*/

    @Transactional
    @RequestMapping(value ="/selectTalkingById" ,method = RequestMethod.GET)
    @ApiOperation(value="根据talkingid查询talking信息（包含关注状态）", notes="根据talkingid查询talking信息 " +
            "Message:0 没有数据 1查询成功   attention =>0 没有关注  =>1 已经关注")
    public String selectTalkingById(@ApiParam("专题id") @RequestParam("talkingid")String talkingid,
                                    @ApiParam("操作人id") @RequestParam("userid")String userid){
        List<talking> talkings = taiKingUpdateService.selectById(talkingid);
        if(talkings ==null|| talkings.size()<=0){
            return "{\"Message\":\"0\"}";
        }
        talkingMap = new HashMap<String,Object>();
        if(userid==null||userid==""){
            talkings.get(0).setAttention("0");
//            talkingMap.put("attention",0);
        }else {
            List<UserInfo> reslit = taiKingFollowService.selectTouch(userid, talkingid);
            if (reslit == null || reslit.size() <= 0) {
                talkings.get(0).setAttention("0");
             //   talkingMap.put("attention", 0);
            } else {
                talkings.get(0).setAttention("1");
   //             talkingMap.put("attention", 1);
            }
        }
//        talkingMap.put("talk",talkings);
//        talkingList = new ArrayList<Map<String,Object>>();
//        talkingList.add(talkingMap);
        return "{\"Message\":\"1\",\"Data\":"+ JSON.toJSONString(talkings.get(0)) +"}";
    }


    @RequestMapping(value ="/recommend" ,method = RequestMethod.GET)
    @ApiOperation(value="推荐专题（三个）", notes="推荐专题（三个）Message:0 没有数据 1查询成功 ")
    public String recommend(){
        List<talking> recommendtalking = taiKingUpdateService.recommendtalking();
        if (recommendtalking==null||recommendtalking.size()<=0) {
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(recommendtalking)+"}";
    }

    @RequestMapping(value ="/recommendShop" ,method = RequestMethod.GET)
    @ApiOperation(value="推荐商户（10个）", notes="推荐商户（10个）Message:0 没有数据 1查询成功 ")
    public String recommendShop(){
        List<Schoolshop> schoolshops = taiKingUpdateService.recommendShop();
        if (schoolshops==null||schoolshops.size()<=0) {
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(schoolshops,SerializerFeature.DisableCircularReferenceDetect)+"}";
    }
}
