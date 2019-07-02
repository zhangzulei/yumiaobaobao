package com.yumiaobaobao.app.moremenu.myattention.personal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import com.yumiaobaobao.app.moremenu.myattention.personal.service.UserFollowService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Component
@Api(tags = "我的关注-个人: 1.可能感兴趣的人 2.我的关注  3.我的互相关注 4.关注 5.取关 \n" +
        " 6.判断'我'是否关注某个用户 7.判断'我'是否和某个用户互关")
public class ControllerAssociation {

    @Autowired
    private UserFollowService userFollow;
    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private Serviceindex_discover serviceindex_discover;
    @Autowired
    private TaiKingUpdateService taiKingUpdateService;

    private static Map<String, Object> userMap;

    private static List<Map<String,Object>> myList;

    @ApiOperation(value = "可能感兴趣的人(显示10条)", notes = "可能感兴趣的人  Message 0=>没有数据 ")
    @RequestMapping(value = "/mayUser", method = RequestMethod.GET)
    public String mayUser(@ApiParam("我的id") @RequestParam("userId") int userId
    //                      ,@ApiParam("显示条数") @RequestParam("number") int number
    ) {
        List<UserInfo> resLit = userFollow.mayuser(userId, 10);
        if (resLit == null || resLit.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(resLit) + "}";

    }

    @ApiOperation(value = "查询我关注的用户信息(含关注的数量)", notes = "查询我关注的用户信息 Message 0 =>没有关注任何人 " +
            "attentionStauts  0=>没有关注 1=>我关注了他 2=>相互关注 ")
    @RequestMapping(value = "/selectFollowAttention", method = RequestMethod.GET)
    public String selectFollowAttention(@ApiParam(value = "我的id") @RequestParam(value = "user_id") String user_id) {
        List<UserFollow> list = userFollow.selectFollwAttention(user_id);
        if (null == list || list.size() == 0) {
            return "{\"Message\":\"0\"}";
        }
        myList = new ArrayList<Map<String, Object>>();
        List<UserInfo> li = new ArrayList<UserInfo>();
        userMap = new HashMap<String, Object>();
        for (UserFollow a : list) {
//            userId.add(a.getUserId());
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(String.valueOf(a.getUserId()));
            String s = mutualAttention(String.valueOf(a.getUserId()), String.valueOf(a.getFollowuserId()));
//            userMap.put("useInfo", userInfo);
            JSONObject json = JSONObject.parseObject(s);
//            userMap.put("attentionStauts",json.get("Message").toString());
            if(json.get("Message").toString().equals(1)){
                userInfo.setAttentionStatus("1");
            }else{
                userInfo.setAttentionStatus("2");
            }
            li.add(userInfo);
        }

        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(li) + "}";

    }

   /* @ApiOperation(value = "查询我的粉丝信息内含粉丝的数量", notes = "查询我的粉丝信息 Message 0没有关注任何人 userInfo=>粉丝信息 userSize=>关粉丝数量 ")
    @RequestMapping(value = "/selectAttention", method = RequestMethod.GET)
    public String selectAttention(@ApiParam(value = "我的id") @RequestParam("followUserId") String followUserId) {
        List<UserFollow> list = userFollow.selectAttention(followUserId);
        if (null == list || list.size() == 0) {
            return "{\"Message\":\"0\"}";
        }
        List<Integer> userId = new ArrayList();
        for (UserFollow a : list) {
            userId.add(a.getUserId());
        }
        List<UserInfo> infoList = userFollow.selectUserInfo(userId);
        userMap = new ConcurrentHashMap<>();
        userMap.put("useInfo", infoList);
        userMap.put("useSize", list.size());
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(userMap) + "}";

    }*/

    @ApiOperation(value = "查询关注的状态)", notes = "查询关注的状态  Message 0=>没有关注 1=>我关注了他 2=>相互关注 ")
    @RequestMapping(value = "/mutualAttention", method = RequestMethod.GET)
    public String mutualAttention(@ApiParam(value = "我的id") @RequestParam(value = "userId") String userId,
                                  @ApiParam("其他用户id") @RequestParam(value = "otherId") String otherId) {
        //判断'我'是否关注该用户
        List<UserFollow> reslit = userFollow.selecType(userId, otherId);
        if (reslit == null || reslit.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        Integer status = reslit.get(0).getStatus();
        if (status == 1) {
            List<UserFollow> re = userFollow.selecmutual(userId, otherId);
            if (re == null || re.size() == 0) {
                return "{\"Message\": \"1\"}";
            }
            return "{\"Message\": \"2\"}";
        }
        return "{\"Message\": \"0\"}";
    }

    @ApiOperation(value = "关注", notes = "关注  Message 0=>失败  1=>成功 -1=>已经关注无法再次关注  -2=>自己不能关注自己")
    @RequestMapping(value = "/toAttention", method = RequestMethod.POST)
    public String toAttention(@ApiParam(value = "执行关注的用户id") @RequestParam(value = "userId") String userId,
                              @ApiParam(value = "被关注的用户id") @RequestParam(value = "followUserId") String followUserId) {
        if(userId.equals(followUserId)){
            return "{\"Message\": \"-2\"}";
        }

        List<UserFollow> list = userFollow.selecType(userId, followUserId);//判断是否存在关注关系
        if (null == list || list.size() == 0) {
            if (userFollow.toAttention(userId, followUserId) == 0) {  //执行关注接口
                return "{\"Message\": \"0\"}";
            }
        } else {
            return "{\"Message\": \"-1\"}";
        }
        userFollow.addattentionNumber(userId); //给userId增加关注
        userFollow.addfanNumber(followUserId); //给followUserId 增加粉丝
        return "{\"Message\": \"1\"}";
    }

    @ApiOperation(value = "取消关注", notes = "取消关注 Message 0=>失败 1=>成功 -1=>未关注无法取消 ")
    @RequestMapping(value = "/updateAttention", method = RequestMethod.POST)
    public String updateAttention(@ApiParam(value = "执行取关的用户id") @RequestParam(value = "userId") String userId,
                                  @ApiParam(value = "被取关的用户id") @RequestParam(value = "followUserid") String followUserId) {
        List<UserFollow> list = userFollow.selecType(userId, followUserId);//判断是否存在关注关系
        if (null == list || list.size() == 0) {
            return "{\"Message\": \"-1\"}";
        }
        if (userFollow.deleteAttention(userId, followUserId) <= 0) {
            return "{\"Message\": \"0\"}";
        }
        userFollow.lessattentionNumber(userId);       //给userId减少关注
        userFollow.lessfanNumber(followUserId);       //给followUserId 减少粉丝
        return "{\"Message\": \"1\"}";
    }

    @ApiOperation(value = "判断'我'是否关注该用户", notes = "判断'我'是否关注该用户（返回值供前端判断并显示相应的按钮)  Message 0=>不是 1=>是")
    @RequestMapping(value = "/selecType", method = RequestMethod.GET)
    public String selecType(@ApiParam("我的id") @RequestParam(value = "userId") String userId, @ApiParam("其他用户id") @RequestParam(value = "otherId") String otherId) {
        List<UserFollow> reslit = userFollow.selecType(userId, otherId);
        if (reslit == null || reslit.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\"}";
    }

    @ApiOperation(value = "判断'我'是否和某个用户互关", notes = "判断'我'是否和某个用户互关（返回值供前端判断并显示相应的按钮)  Message 0=>不是 1=>是")
    @RequestMapping(value = "/selecmutual", method = RequestMethod.GET)
    public String selecmutual(@ApiParam("我的id") @RequestParam(value = "userId") String userId, @ApiParam("其他用户id") @RequestParam(value = "otherId") String otherId) {
        List<UserFollow> reslit = userFollow.selecmutual(userId, otherId);
        if (reslit == null || reslit.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\"}";
    }


    @ApiOperation(value = "查询我关注的用户的便签", notes = "查询我关注的用户的便签 Message 0 =>没有关注任何人 " +
            "attentionStauts  0=>没有关注 1=>我关注了他 2=>相互关注 ")
    @RequestMapping(value = "/selectMyFollowIndex", method = RequestMethod.GET)
    public String selectMyFollowIndex(@ApiParam(value = "我的id") @RequestParam(value = "userid") String userid,
                                      @ApiParam("显示条数") @RequestParam("pagesize") int pagesize){
        List<UserFollow> list = userFollow.selectFollwAttention(userid);
        List<index_discover> li = new ArrayList<index_discover>();
        if (null == list || list.size() == 0) {
            return "{\"Message\":\"0\"}";
        }
        for (UserFollow follow : list) {
            List<index_discover> index_discovers = serviceindex_discover.selectByUserid(String.valueOf(follow.getUserId()));
            if(index_discovers!=null&&index_discovers.size()>0){
                for (index_discover index_discover : index_discovers) {
                    index_discover index_discover1 = serviceindex_discover.oneTemplate(String.valueOf(index_discover.getNoteid()));
                    if(index_discover1.getTalkingid()!=null && index_discover1.getTalkingid() != 0){
                        List<talking> talkings = taiKingUpdateService.selectById(String.valueOf(index_discover1.getTalkingid()));
                        if(talkings!=null && talkings.size()>0){
                            index_discover1.setTalkingName(talkings.get(0).getTalkingtitle());
                        }
                    }
                    li.add(index_discover1);
                }
            }
        }
        int i = pagesize;
        if(li.size()<pagesize){
            return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(li)+"}";
        }else{

        }

    return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(li)+"}";
    }

    @RequestMapping(value = "fansList", method = RequestMethod.GET)
    @ApiOperation(value = "粉丝列表", notes = "粉丝列表 message 0=>失败  1=>成功")
    public String fansList(@ApiParam("用户id") @RequestParam("userid")String userid){
        List<UserFollow> list = new ArrayList<UserFollow>();
        List<UserFollow> userFollows = userFollow.selectFollwAttention(userid);
        if(userFollows==null||userFollows.size()<=0){
            return "{\"Message\":\"0\"}";
        }
        for (UserFollow follow : userFollows) {
            //拿到关注我的人的信息
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(String.valueOf(follow.getUserId()));
            follow.setUsername(userInfo.getUsername());
            follow.setAvatarimg(userInfo.getAvatarimg());
            List<UserFollow> selecmutual = userFollow.selecmutual(String.valueOf(follow.getUserId()),String.valueOf(follow.getFollowuserId()));
            if(selecmutual==null||selecmutual.size()<=0){
                follow.setAttention("0");
            }else{
                follow.setAttention("1");
            }
            list.add(follow);
        }
        
        return "{\"Message\": \"1\",\"Data\":"+ JSON.toJSONString(list)+"}";
    }

}
