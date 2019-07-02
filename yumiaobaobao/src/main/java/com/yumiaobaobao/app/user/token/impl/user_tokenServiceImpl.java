package com.yumiaobaobao.app.user.token.impl;

import com.yumiaobaobao.app.user.dao.user_tokenMapper;
import com.yumiaobaobao.app.user.entity.user_token;
import com.yumiaobaobao.app.user.token.service.user_tokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Service
public class user_tokenServiceImpl implements user_tokenService {
    @Autowired
    private user_tokenMapper user_tokenMapper;

    @Override
    public int addToken(user_token token) {
        return user_tokenMapper.addToken(token);
    }

    @Override
    public int updataToken(user_token token) {
        return user_tokenMapper.updataToken(token);
    }

    @Override
    public List<user_token> findByUserId(String userid) {
        return user_tokenMapper.findByUserId(userid);
    }
}
