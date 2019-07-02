package com.yumiaobaobao.app.moremenu.myattention.taiking.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.myattention.taiking.dao.TaiKingFollowMapper;
import com.yumiaobaobao.app.moremenu.myattention.taiking.entity.TaiKingFollow;
import com.yumiaobaobao.app.moremenu.myattention.taiking.service.TaiKingFollowService;
import com.yumiaobaobao.app.taiking.dao.TaiKingMapper;
import com.yumiaobaobao.app.taiking.entity.talking;
import com.yumiaobaobao.app.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */
@Service
public class TaiKingFollowServiceImpl implements TaiKingFollowService {

    @Autowired
    private TaiKingFollowMapper taiKingFollowMapper;

    @Autowired
    private TaiKingMapper taiKingMapper;

    @Override
    public List<talking> maytalking(int userid) {
        return taiKingMapper.maytalking(userid);
    }

    @Override
    public List<talking> bytalkingidselectTalking(List list) {
        return taiKingMapper.bytalkingidselectTalking(list);
    }

    @Override
    public List<TaiKingFollow> selectAttention(String userid) {
        return taiKingFollowMapper.selectAttention(userid);
    }

    @Override
    public int addtakingtouch(String userid, String talkingid) {
        return taiKingFollowMapper.addtakingtouch(userid,talkingid, DateUtils.newDateTime());
    }

    @Override
    public int lesstakingtouch(String userid, String talkingid) {
        return taiKingFollowMapper.lesstakingtouch(userid,talkingid);
    }

    @Override
    public List<UserInfo> selectTouch(String userid, String talkingid) {
        return taiKingFollowMapper.selectTouch(userid,talkingid);
    }
}
