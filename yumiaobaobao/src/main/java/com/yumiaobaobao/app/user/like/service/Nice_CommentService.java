package com.yumiaobaobao.app.user.like.service;

import com.yumiaobaobao.app.user.entity.nice_comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Nice_CommentService {
    //查找点赞信息
    nice_comment findNiceComment( Map<String,Object> map);
    //删除点赞信息
    Integer deleteNiceComment(@Param("id") Integer id);
    //增加点赞信息
    int addNiceComment( Map<String,Object> map);

    List<nice_comment> selectByNoteid(@Param("noteId") Integer noteId);

    int selectAllComment(@Param("noteId") Integer noteId);

    /**
     * 新增评论
     * @param map
     * @return
     */
    int insertSelective(Map<String,Object> map);
}
