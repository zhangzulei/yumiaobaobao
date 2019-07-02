package com.yumiaobaobao.app.user.usermember.service;

import com.yumiaobaobao.app.user.entity.user_level_info;

import java.util.List;
import java.util.Map;

public interface user_level_infoService {

    List<user_level_info> findByUserid(Integer userid);

    int updateScoreByLogin(Integer userid);

    int updateScoreByArticle(Integer userid);

    int reduceScore(Integer userid);

    int addUserLevelInfo(Map<String,Object> maps);

    int updateScoreZero(Integer userid);
}
