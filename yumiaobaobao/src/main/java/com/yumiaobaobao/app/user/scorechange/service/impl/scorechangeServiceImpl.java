package com.yumiaobaobao.app.user.scorechange.service.impl;

import com.yumiaobaobao.app.user.scorechange.entity.scorechange;
import com.yumiaobaobao.app.user.scorechange.service.scorechangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yumiaobaobao.app.user.scorechange.dao.ScorechangeMapper;

import java.util.List;
import java.util.Map;

@Service
public class scorechangeServiceImpl implements scorechangeService {

    @Autowired
    private ScorechangeMapper scorechangeMapper;

    @Override
    public int addScorechange(Map map) {
        return scorechangeMapper.addScorechange(map);
    }

    @Override
    public List<scorechange> selectByUserid(String userid) {
        return scorechangeMapper.selectByUserid(userid);
    }

    @Override
    public int updateScoreZero(String userid) {
        return scorechangeMapper.updateScoreZero(userid);
    }

    @Override
    public List<scorechange> selectLastByUserid(String userid) {
        return scorechangeMapper.selectLastByUserid(userid);


    }
}
