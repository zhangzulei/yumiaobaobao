package com.yumiaobaobao.app.user.search.service;

import com.yumiaobaobao.app.user.entity.user_comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceComment {
    List<user_comment> allcomment();

    Boolean updateFavoCount(user_comment user_comment);

    Boolean addComment(user_comment user_comment);

    user_comment oneComment(@Param("commentid") String commentId);
}
