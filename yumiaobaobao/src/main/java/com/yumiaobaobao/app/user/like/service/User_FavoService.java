package com.yumiaobaobao.app.user.like.service;

import com.yumiaobaobao.app.user.entity.nice_comment;
import com.yumiaobaobao.app.user.entity.user_favo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019.05.20.
 */
public interface User_FavoService {

    //查找粉丝信息
    List<user_favo> findFavo(Map<String,Object> map);

    //增加粉丝信息
    Integer addFavo(Map<String,Object> map);

    /**
     * 粉丝列表
     * @return
     */
    List<user_favo> selectfansList();

    /**
     * 评论列表
     * @return
     */
    List<nice_comment> selectCommentList();

}
