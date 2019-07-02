package com.yumiaobaobao.app.moremenu.mycollection.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.mycollection.entity.Collection;
import com.yumiaobaobao.app.moremenu.mycollection.service.CollectionService;
import com.yumiaobaobao.app.user.comment.service.Serviceindex_discover;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.entity.v_note;
import com.yumiaobaobao.app.user.like.jpush.JPush;
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
@Api(tags = "我的收藏  1.展示我的便签被收藏列表  2.添加收藏  3.查询我的收藏")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private Serviceindex_discover serviceindexDiscover;



    @ApiOperation(value = "展示我的便签被收藏列表 ",notes = "展示我的便签被收藏列表 Message 0=>没有收藏任何便签   1=>成功")
    @RequestMapping(value = "/selectMyCollection",method = RequestMethod.GET)
    public String selectMyCollection(@ApiParam("被收藏人id") @RequestParam("noteuserId") String noteuserId){
        List<v_note> reslut = collectionService.selectMyCollection1(noteuserId);
        if(null==reslut || reslut.size()==0){
            return  "{\"Message\":\"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(reslut)+"}";
    }

    @Transactional
    @ApiOperation(value = "添加收藏",notes = "添加收藏 Message 0=>增加失败 1=>增加成功  =>-1查询不到便签  " +
            "=>-2更新收藏数量  =>-3已经收藏过，不能再收藏  =>-4不能收藏自己的便签")
    @RequestMapping(value = "/addCollection",method = RequestMethod.GET)
    public String addCollection(@ApiParam("用户id") @RequestParam("userId") String userId,
                                @ApiParam("便签id") @RequestParam("Noteid") String Noteid,
                                @ApiParam("收藏人") @RequestParam("username") String username){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Collection> collections = collectionService.selectCollectionByUseridAndNoteid(userId, Noteid);
        if(collections==null||collections.size()>0){
            return "{\"Message\":\"-3\"}";
        }
        index_discover discover = serviceindexDiscover.selectCollection(Integer.valueOf(Noteid));
        String userids = discover.getUserid();
        if(userids.equals(userId)){
            return "{\"Message\":\"-4\"}";
        }
        String alias = discover.getUserid();
        System.out.println("被收藏人"+alias);
        map.put("userid",userId);
        map.put("Noteid",Noteid);
        map.put("Collectiontime", DateUtils.newDateTime());
        map.put("noteuserId", alias);
        map.put("noteuserinfo", username);
        int i = collectionService.addCollection(map);
        Map<String,String> parm = new HashMap<>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        //*parm.put("id", "190e35f7e00692e3c9e");*//*
        //设置提示信息,内容是文章标题
        parm.put("msg", username+"收藏了您的便签");
        JPush.jpushIOS(parm, alias);
        if(i==0){
            return  "{\"Message\":\"0\"}";
        }
        //增加玩记录之后改变便签的收藏数
        index_discover index_discover = serviceindexDiscover.oneTemplate(Noteid);
        if (index_discover==null) {
            return  "{\"Message\":\"-1\"}";
        }
        index_discover.setCollectcount(index_discover.getCollectcount()+1);
        Boolean aBoolean = serviceindexDiscover.changeCollectCount(index_discover);
        if (!aBoolean) {
            return  "{\"Message\":\"-2\"}";
        }
        return  "{\"Message\":\"1\"}";
    }


    @ApiOperation(value = "展示我的便签收藏 ",notes = "展示我的便签收藏 Message 0=>没有收藏任何便签   1=>成功  -1=>没有查询到有效便签")
    @RequestMapping(value = "/selectMyCollectionList",method = RequestMethod.GET)
    public String selectMyCollectionList(@ApiParam("收藏人id") @RequestParam("userid") String userid){
        List<Collection> collections = collectionService.selectMyCollection(userid);
        List<index_discover> list = new ArrayList<index_discover>();
        if(null==collections || collections.size()==0){
            return  "{\"Message\":\"0\"}";
        }
        for(Collection c : collections){
            index_discover index_discover = serviceindexDiscover.oneTemplate(String.valueOf(c.getNoteid()));
            if(index_discover==null){
                return  "{\"Message\":\"-1\"}";
            }
            list.add(index_discover);
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(list)+"}";
    }
}
