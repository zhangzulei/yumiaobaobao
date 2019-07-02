package com.yumiaobaobao.app.user.usermember.service.impl;

import com.yumiaobaobao.app.user.dao.user_level_infoMapper;
import com.yumiaobaobao.app.user.usermember.service.user_level_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */

@Service
public class user_level_infoServiceImpl implements user_level_infoService {
    @Autowired
    private user_level_infoMapper user_level_info;

    @Override
    public List<com.yumiaobaobao.app.user.entity.user_level_info> findByUserid(Integer userid) {
        return user_level_info.findByUserid(userid);
    }

    @Override
    public int updateScoreByLogin(Integer userid) {
        return user_level_info.updateScoreByLogin(userid);
    }

    @Override
    public int updateScoreByArticle(Integer userid) {
        return user_level_info.updateScoreByArticle(userid);
    }

    @Override
    public int reduceScore(Integer userid) {
        return user_level_info.reduceScore(userid);
    }

    @Override
    public int addUserLevelInfo(Map<String, Object> maps) {
        return user_level_info.addUserLevelInfo(maps);
    }

    @Override
    public int updateScoreZero(Integer userid) {
        return user_level_info.updateScoreZero(userid);
    }
}
