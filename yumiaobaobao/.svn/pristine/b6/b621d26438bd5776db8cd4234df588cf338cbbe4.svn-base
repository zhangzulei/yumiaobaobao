package com.yumiaobaobao.app.moremenu.myattention.taiking.service;

import com.yumiaobaobao.app.moremenu.myattention.taiking.entity.TaiKingFollow;
import com.yumiaobaobao.app.taiking.entity.talking;
import com.yumiaobaobao.app.user.entity.UserInfo;

import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */
public interface TaiKingFollowService {

    /**
     * 可能感兴趣的专题
     * @param userid
     * @return
     */
    List<talking> maytalking(int userid);

    /***
     * 根据专题id查询专题信息
     * @return
     */
    List<talking> bytalkingidselectTalking(List list);

    /**
     * 我关注的专题 获取专题id
     * @param userid
     * @return
     */
    List<TaiKingFollow> selectAttention(String userid);
    /**
     * 关注专题
     * @param userid
     * @param talkingid
     * @return
     */
    int addtakingtouch(String userid, String talkingid);


    /**
     * 取关专题
     * @param userid
     * @param talkingid
     * @return
     */
    int lesstakingtouch(String userid, String talkingid);

    /**
     * 查询用户和专题之间是否关注
     * @return
     */
    List<UserInfo> selectTouch(String userid, String talkingid);
}
