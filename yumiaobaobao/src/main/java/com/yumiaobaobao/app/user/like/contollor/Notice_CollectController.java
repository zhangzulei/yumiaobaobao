package com.yumiaobaobao.app.user.like.contollor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import com.yumiaobaobao.app.moremenu.myattention.personal.service.UserFollowService;
import com.yumiaobaobao.app.user.comment.service.Serviceindex_discover;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.entity.nice_comment;
import com.yumiaobaobao.app.user.like.jpush.JPush;
import com.yumiaobaobao.app.user.like.service.Nice_CommentService;
import com.yumiaobaobao.app.user.like.service.Nice_DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "评论：1.增加评论  2.展示评论（时间排序） 3.查询便签的评论数量")
@RestController
public class Notice_CollectController {
    @Autowired
    private Nice_DetailService detailService;
    @Autowired
    private Nice_CommentService nice_CommentService;
    @Autowired
    private Serviceindex_discover serviceindexDiscover;
    @Autowired
    private com.yumiaobaobao.app.user.userupdate.service.UserUpdateService userUpdateService;
    @Autowired
    private UserFollowService userFollow;


    @ApiOperation(value = "增加评论记录",notes = "增加评论记录 Message=>0 增加失败 =>1 增加成功  " +
            "-1=>没有关注不允许评论  -2=>没有查询到该便签")
    @GetMapping("/addComment")
    @Transactional
    public String addComment(@ApiParam("评论用户id") @RequestParam("userid")String userid,
                         @ApiParam("评论的便签id") @RequestParam("templateID")String templateID,
                         @ApiParam("评论内容") @RequestParam("commentContent")String commentContent,
                         @ApiParam("评论人名称") @RequestParam("username")String username ){
        //通过便签得到创建用户
        index_discover index_discover = serviceindexDiscover.oneTemplate(templateID);
        if(index_discover==null){
            return "{\"Message\": \"-2\"}";
        }
        String alias = index_discover.getUserid();
        UserInfo userInfo = userUpdateService.selectUserInfoByUserId(index_discover.getUserid());
        //判断用户是否开启关注评论
        if(userInfo.getAllowcomment()==1){
        //判断是否关注该用户
            List<UserFollow> reslit = userFollow.selecType(userid, String.valueOf(userInfo.getUserid()));
            if(reslit==null||reslit.size()<=0){
                return "{\"Message\": \"-1\"}";
            }
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",userid);
        map.put("noteId",templateID);
        map.put("commentContent",commentContent);
        map.put("createTime", DateUtils.newDateTime());
        Integer i = nice_CommentService.addNiceComment(map);
        if(i<=0){
            return "{\"Message\": \"0\"}";
        }
        //成功之后增加便签的评论数量
        index_discover.setCommentcount(index_discover.getCommentcount());
        Boolean a = serviceindexDiscover.changecommentCount(index_discover);
        if(!a){
            return "{\"Message\": \"0\"}";
        }
       //根据便签内容获得创建人的userid
//        String alias = index_discover.getUserid();
        Map<String,String> parm = new HashMap<>();
        //这里的id是,移动端集成极光并登陆后,极光用户的rid
        //*parm.put("id", "190e35f7e00692e3c9e");*//*
        //设置提示信息,内容是文章标题
        parm.put("msg", username+"给您评论了");
        JPush.jpushIOS(parm, alias);
        return "{\"Message\": \"1\"}";
    }


    @ApiOperation(value = "查询便签评论",notes = "查询便签评论 Message=>0 查询失败 =>1 查询成功 ")
    @GetMapping("/selectByNoteid")
    public String selectByNoteid(@ApiParam("评论的便签id") @RequestParam("noteId")String noteId){
        List<nice_comment> nice_comments = nice_CommentService.selectByNoteid(Integer.valueOf(noteId));
        if(nice_comments==null||nice_comments.size()<=0){
            return "{\"Message\": \"0\"}";
        }
        for (nice_comment nice_comment : nice_comments) {
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(nice_comment.getUserid());
            nice_comment.setUsername(userInfo.getUsername());
        }
        return "{\"Message\": \"1\",\"Data\":"+ JSON.toJSONString(nice_comments)+"}";
    }


    @ApiOperation(value = "查询便签评论数量",notes = "查询便签评论数量 Message=>0 查询失败 =>1 查询成功 ")
    @GetMapping("/selectAllComment")
    public String selectAllComment(@ApiParam("评论的便签id") @RequestParam("noteId")String noteId){
        int i = 0;
        try {
            i = nice_CommentService.selectAllComment(Integer.valueOf(noteId));
        }catch (Exception e){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\",\"Date\":"+ String.valueOf(i) +"}";
    }
}
