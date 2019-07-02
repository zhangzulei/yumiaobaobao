package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.user_comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_commentMapper {
    //所有评论
    List<user_comment> allcomment();
    //更新喜欢数量
    Boolean updateFavoCount(user_comment user_comment);
    //添加评论
    @Insert("insert into user_comment (CommentID,CommentContent,UserID,templateId) values (#{commentid},#{commentcontent}," +
            "#{userid},#{index_discover.templateid})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Boolean addComment(user_comment user_comment);
    //根据评论ID来查询评论详情信息
    @Select("select ID,userId,commentId,favoCount,createTime from user_comment where commentId=#{commentid}")
    user_comment oneComment(@Param("commentid") String commentId);

}