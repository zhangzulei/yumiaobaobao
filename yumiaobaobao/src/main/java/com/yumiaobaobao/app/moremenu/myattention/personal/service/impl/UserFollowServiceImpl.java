package com.yumiaobaobao.app.moremenu.myattention.personal.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.myattention.personal.dao.UserFollowMapper;
import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import com.yumiaobaobao.app.moremenu.myattention.personal.service.UserFollowService;
import com.yumiaobaobao.app.user.dao.UserRelatedMapper;
import com.yumiaobaobao.app.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service("ServiceUserFollow")
public class UserFollowServiceImpl implements UserFollowService {

    @Autowired
    private UserFollowMapper usrFollowMapper;

    @Autowired
    private UserRelatedMapper userRelatedMapper;


    @Override
    public List<UserFollow> selecType(String user_id, String followuser_id) {
        return usrFollowMapper.selecType(user_id,followuser_id);
    }

    @Override
    public List<UserFollow> selecmutual(String user_id, String followuser_id) {
        return usrFollowMapper.selecmutual(user_id,followuser_id);
    }

    @Override
    public int toAttention(String user_id,String followuser_id) {
        LocalDateTime dateTime= DateUtils.newDateTime();
        System.out.print(dateTime);
        return usrFollowMapper.toAttention(user_id,followuser_id, dateTime);
    }


    @Override
    public int deleteAttention(String user_id, String followuser_id) {
        return usrFollowMapper.deleteAttention(user_id,followuser_id);
    }

    @Override
    public List<UserFollow> selectAttention(String followuser_id) {
        return usrFollowMapper.selectAttention(followuser_id);
    }

    @Override
    public List<UserFollow> selectFollwAttention(String user_id) {
        return usrFollowMapper.selectFollwAttention(user_id);
    }

    @Override
    public List<UserInfo> mayuser(int userid, int number) {
        return userRelatedMapper.mayuser(userid,number);
    }

    @Override
    public List<UserFollow> mutualattention(String userid) {
        return usrFollowMapper.mutualattention(userid);
    }

    @Override
    public List<UserInfo> selectUserInfo(List list) {
        return userRelatedMapper.selectUserInfo(list);
    }

    @Override
    public int addattentionNumber(String userid) {
        return userRelatedMapper.addattentionNumber(userid);
    }

    @Override
    public int lessattentionNumber(String userid) {
        return userRelatedMapper.lessattentionNumber(userid);
    }

    @Override
    public int addfanNumber(String userid) {
        return userRelatedMapper.addfanNumber(userid);
    }

    @Override
    public int lessfanNumber(String userid) {
        return userRelatedMapper.lessfanNumber(userid);
    }

    @Override
    public List<Map<String, Object>> MonthByFollow(String userid, String year) {
        return usrFollowMapper.MonthByFollow(userid,year);
    }

    @Override
    public List<Map<String, Object>> YearByFollow(String userid) {
        return usrFollowMapper.YearByFollow(userid);
    }
}
