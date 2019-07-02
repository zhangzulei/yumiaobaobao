package com.yumiaobaobao.app.user.like.service;

import com.yumiaobaobao.app.user.entity.UserInfo;

/**
 * Created by Administrator on 2019.05.20.
 */
public interface UserInfoService {
    //更新粉丝数量
    Boolean changeFavo(UserInfo userInfo);

}
