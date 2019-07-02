package com.yumiaobaobao.app.moremenu.myattention.personal.service;


import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import com.yumiaobaobao.app.user.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserFollowService {
    /**
     * 查询关注信息
     * @return
     */
     List<UserFollow> selecType(String user_id, String followuser_id);
    /**
     * 判断是否存在互关关系
     * @param user_id 被关注的用户的id
     * @param followuser_id 去关注的别的用户的用户的id
     * @return
     */
    List<UserFollow> selecmutual(String user_id, String followuser_id);
    /**
     * 去关注
     * @return
     */
     int toAttention(String user_id, String followuser_id);

    /**
     * 更新关注 用于取消关注
     * @return
     */
     int deleteAttention(String user_id, String followuser_id);
    /**
     * 查询用户关注的用户数量
     * @return
     */
     List<UserFollow> selectAttention(String followuser_id);
    /**
     * 查询用户被多少人关注(粉丝)
     * @return
     */
     List<UserFollow> selectFollwAttention(String user_id);

    /**
     * 可能感兴趣的人
     * @param number 一次显示人数
     * @return
     */
    List<UserInfo> mayuser(int userid, int number);
    /**
     * 与我互相关注的用户
     * @param userid
     * @return
     */
    List<UserFollow> mutualattention(String userid);
    /**
     * 根据用户id查询用户信息 集合参数
     * @return
     */
    List<UserInfo> selectUserInfo(List list);
    /**
     *  给某用户增加关注数
     * @param userid
     */
    int addattentionNumber(String userid);
    /**
     *  给某用户减少关注数
     * @param userid
     */
    int lessattentionNumber(String userid);
    /**
     *  给某用户增加粉丝
     * @param userid
     */
    int addfanNumber(String userid);
    /**
     *  给某用户减少粉丝
     * @param userid
     */
    int lessfanNumber(String userid);

    //判断月关注情况
    List<Map<String,Object>> MonthByFollow(String userid, String year);

    //判断年关注情况
    List<Map<String,Object>> YearByFollow(String userid);
}
