package com.yumiaobaobao.app.user.userlogin.phonelogin.service;


import com.yumiaobaobao.app.user.entity.UserInfo;

public interface PhoneLoginService {

    /**
     * 根据手机号注册新用户
     * @return
     */
    int addNewUser(String userGender, String userPhone, String userbirthday,String yumiaoAccount);

    /**
     * 根据手机号查询用户  一个手机号对应一个用户
     * @param userphone
     * @return
     */
    UserInfo byUserPhoneToUserInfo(String userphone);
    /**
     * 修改手机号
     * @param userphone
     * @return
     */
    int updatePhone(String userphone,String userid);

}
