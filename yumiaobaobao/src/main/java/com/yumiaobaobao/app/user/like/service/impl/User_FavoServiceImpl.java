package com.yumiaobaobao.app.user.like.service.impl;

import com.yumiaobaobao.app.user.dao.nice_commentMapper;
import com.yumiaobaobao.app.user.dao.user_favoMapper;
import com.yumiaobaobao.app.user.entity.nice_comment;
import com.yumiaobaobao.app.user.entity.user_favo;
import com.yumiaobaobao.app.user.like.service.User_FavoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019.05.20.
 */
@Service
public class User_FavoServiceImpl implements User_FavoService {

    @Autowired
    private user_favoMapper favoMapper;
    @Autowired
    private nice_commentMapper niceCommentMapper;



    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<user_favo> findFavo(Map<String,Object> map) {
        return favoMapper.userfavo(map);
    }

    @Override
    public Integer addFavo(Map<String, Object> map) {
        return favoMapper.addFavo(map);
    }

    /**
     * 查看粉丝列表
     * @return
     */
    @Override
    public List<user_favo> selectfansList() {
        return favoMapper.selectfansList();
    }

    /**
     * 评论列表
     * @return
     */
    @Override
    public List<nice_comment> selectCommentList() {
        return niceCommentMapper.selectCommentList();
    }
}
