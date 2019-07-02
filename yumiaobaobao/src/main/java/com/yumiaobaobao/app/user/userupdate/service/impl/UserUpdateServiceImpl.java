package com.yumiaobaobao.app.user.userupdate.service.impl;

import com.yumiaobaobao.app.user.dao.UserRelatedMapper;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.userupdate.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/10.
 */
@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    private UserRelatedMapper userRelatedMapper;
    @Override
    public int updateHeadImg(String avatarImg, String userid) {
        return userRelatedMapper.updateHeadImg(avatarImg,userid);
    }
    @Override
    public int updateUserInfo(Map<String, Object> map) {
        return userRelatedMapper.updateUserInfo(map);
    }

    @Override
    public UserInfo byUserPhoneToUserInfo(String userphone) {
        return userRelatedMapper.byUserPhoneToUserInfo(userphone);
    }

    @Override
    public int updatePhone(String userphone, String userid) {
        return userRelatedMapper.updatePhone(userphone,userid);
    }

    @Override
    public UserInfo selecByYmMiaoAccoent(String YmMiaoAccoent) {
        return userRelatedMapper.selecByYmMiaoAccoent(YmMiaoAccoent);
    }

    @Override
    public int updateYmMiaoAccoent(String userId, String number) {
        return userRelatedMapper.updateYmMiaoAccoent(userId,number);
    }

    @Override
    public UserInfo selectUserInfoByUserId(String userid) {
        return userRelatedMapper.selectUserInfoByUserId(userid);
    }

    @Override
    public int updateLoginTime(LocalDateTime date, String userid) {
        return userRelatedMapper.updateLoginTime(date,userid);
    }

    @Override
    public int updateVip(Integer userid) {
        return userRelatedMapper.updateVip(userid);
    }

    @Override
    public int loseVip(Integer userid) {
        return userRelatedMapper.loseVip(userid);
    }

    @Override
    public int updateIsshop(Integer userid, Integer shopid) {
        return userRelatedMapper.updateIsshop(userid,shopid);
    }

    @Override
    public int updateGarder(Integer userid) {
        return userRelatedMapper.updateGarder(userid);
    }

    @Override
    public int updateNoteNumber(UserInfo userInfo) {
        return userRelatedMapper.updateNoteNumber(userInfo);
    }

    @Override
    public int updateComment(String userid, String type) {
        return userRelatedMapper.updateComment(userid,type);
    }

    /**
     * 查询用户名称是否重复
     * @param name
     * @return
     */
    @Override
    public List<UserInfo> selectUserName(String name) {
        return userRelatedMapper.selectUserName(name);
    }

    @Override
    public List<UserInfo> selectByshopid(String shopid) {
        return userRelatedMapper.selectByshopid(shopid);
    }
}
