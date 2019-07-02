package com.yumiaobaobao.app.user.userlogin.phonelogin.service.impl;


import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.common.utils.util.ImgUtils;
import com.yumiaobaobao.app.common.utils.util.NameUtils;
import com.yumiaobaobao.app.user.dao.UserRelatedMapper;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.userlogin.phonelogin.service.PhoneLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PhoneLoginServiceImpl implements PhoneLoginService {

    @Autowired
    private UserRelatedMapper userRelatedMapper;

    private LocalDateTime dateTime;

    @Override
    public int addNewUser(String userGender, String userPhone,String userbirthday,String yumiaoAccount) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if("null".equals(userbirthday)){
            dateTime=DateUtils.newDateTime();
        }else {
            dateTime = LocalDateTime.parse(userbirthday.trim(), df);
        }
        return userRelatedMapper.addNewUser(
                NameUtils.nameUtils(),
                userGender,
                userPhone,
                DateUtils.newDateTime(),
                ImgUtils.UserInfo(),
                dateTime,
                DateUtils.newDateTime(),
                yumiaoAccount
        );
    }

    @Override
    public UserInfo byUserPhoneToUserInfo(String userphone) {
        return userRelatedMapper.byUserPhoneToUserInfo(userphone);
    }

    @Override
    public int updatePhone(String userphone, String userid) {
        return userRelatedMapper.updatePhone(userphone,userid);
    }
}
