package com.yumiaobaobao.app.user.search.service.impl;


import com.yumiaobaobao.app.user.dao.user_commentMapper;
import com.yumiaobaobao.app.user.entity.user_comment;
import com.yumiaobaobao.app.user.search.service.ServiceComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Service
public class CommentServiceImpl implements ServiceComment {
    @Autowired
    private user_commentMapper commentMapper;

    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<user_comment> allcomment() {
        return commentMapper.allcomment();
    }

    @Transactional(propagation = REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean updateFavoCount(user_comment user_comment) {
        return commentMapper.updateFavoCount(user_comment);
    }

    @Transactional(propagation = REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Boolean addComment(user_comment user_comment) {
        return commentMapper.addComment(user_comment);
    }

    @Transactional(propagation =SUPPORTS,readOnly = true)
    public user_comment oneComment(String commentId) {
        return commentMapper.oneComment(commentId);
    }
}
