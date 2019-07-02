package com.yumiaobaobao.app.user.like.service.impl;

import com.yumiaobaobao.app.user.dao.UserRelatedMapper;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.like.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019.05.20.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserRelatedMapper userRelatedMapper;

    @Override
    public Boolean changeFavo(UserInfo userInfo) {
        return userRelatedMapper.changeFavo(userInfo);
    }
}
