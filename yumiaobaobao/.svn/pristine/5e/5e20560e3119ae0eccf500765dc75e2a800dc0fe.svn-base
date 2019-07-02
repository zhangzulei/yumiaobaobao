package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.nice_comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface nice_commentMapper {
    //查找点赞信息
    @Select("select ID,userId,commentId,createTime from nice_comment where userId=#{map.userid} and commentId=#{map.commentid}")
    nice_comment findNiceComment(@Param("map") Map<String,Object> map);

    //删除点赞信息
    @Delete("delete from nice_comment where ID=#{id}")
    int deleteNiceComment(@Param("id") Integer id);

    //增加评论信息
    @Insert("insert into nice_comment (userId,commentContent,noteId,createTime) " +
            "values (#{map.userId},#{map.commentContent},#{map.noteId},#{map.createTime})")
    int addNiceComment(@Param("map") Map<String,Object> map);

    //展示便签评论
    @Select("select * from nice_comment where noteId = #{noteId} order by createTime desc")
    List<nice_comment> selectByNoteid(@Param("noteId") Integer noteId);

    //统计便签的评论数
    @Select("select count(*) from nice_comment where noteId = #{noteId}")
    int selectAllComment(@Param("noteId") Integer noteId);


    /**
     * 新增评论
     * @param map
     * @return
     */
    @Insert("insert into nice_comment (userId,commentContent,noteId,createTime) values " +
            "(#{map.userid},#{map.commentContent},#{map.noteId},#{map.createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertSelective(@Param("map") Map<String,Object> map);


    /**
     * 评论列表
     * @return
     */
    List<nice_comment> selectCommentList();
}


