package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/10.
 */

@Repository
public interface UserRelatedMapper {


    /**
     * 根据用户id查询用户信息  单个参数
     * @param userid 用户id
     * @return
     */
    @Select("select * from user_info WHERE userId = #{userid}")
    UserInfo selectUserInfoByUserId(@Param("userid") String userid);
    /**
     * 根据用户id查询用户信息 集合参数
     * @param list 用户集合
     * @return
     */
    List<UserInfo> selectUserInfo(@Param("list") List list);

    //改变用户粉丝数量
    Boolean changeFavo(UserInfo userInfo);

    /**
     * 可能感兴趣的人
     * @param number 显示人数
     * @return
     */
    @Select("SELECT * FROM user_info WHERE userId NOT IN " +
            "(SELECT followuser_id FROM user_follow WHERE user_follow.user_id=#{userid}) AND userId!=#{userid} ORDER BY RAND() LIMIT 10")
    List<UserInfo> mayuser(
            @Param("userid") int userid,
            @Param("number") int number);
    /**
     *  给某用户增加关注数
     * @param userid
     */
    @Update("UPDATE  user_info  SET attentionNumber = attentionNumber +1 WHERE userId = #{userid}")
    int addattentionNumber(@Param("userid")String userid);
    /**
     *  给某用户减少关注数
     * @param userid
     */
    @Update("UPDATE  user_info  SET attentionNumber = attentionNumber -1 WHERE userId = #{userid}")
    int lessattentionNumber(@Param("userid")String userid);
    /**
     *  给某用户增加粉丝
     * @param userid
     */
    @Update("UPDATE  user_info  SET fanNumber = fanNumber +1 WHERE userId = #{userid}")
    int addfanNumber(@Param("userid")String userid);
    /**
     *  给某用户减少粉丝
     * @param userid
     */
    @Update("UPDATE  user_info  SET fanNumber = fanNumber -1 WHERE userId = #{userid}")
    int lessfanNumber(@Param("userid")String userid);
    /**
     * 根据手机号查询用户  一个手机号对应一个用户
     * @param userPhone
     * @return
     */
    @Select("SELECT * from user_info WHERE userPhone=#{userPhone}")
    UserInfo byUserPhoneToUserInfo(@Param("userPhone") String userPhone);
    /**
     * 修改手机号
     * @param userphone
     * @return
     */
    @Update("UPDATE user_info SET user_info.userPhone=#{userphone} WHERE user_info.userId=#{userid}")
    int updatePhone(@Param("userphone") String userphone, @Param("userid") String userid);
    /**
     * 修改用户头像
     * @param avatarImg
     * @return
     */
    @Update("UPDATE user_info SET user_info.avatarImg=#{avatarImg} WHERE user_info.userId=#{userid}")
    int updateHeadImg(@Param("avatarImg") String avatarImg, @Param("userid") String userid);

    /**
     * 修改个人资料
     * @param map
     * @return
     */
    int updateUserInfo(@Param("map") Map<String, Object> map);

    /**
     * 根据育苗宝宝号查询用户
     * @param YmMiaoAccount
     * @return
     */
    @Select("SELECT * from user_info WHERE yumiaoAccount=#{YmMiaoAccount}")
    UserInfo selecByYmMiaoAccoent(@Param("YmMiaoAccount") String YmMiaoAccount);
    /**
     * 修改芋苗宝宝号
     * @param userId
     * @param number
     * @return
     */
    @Update("UPDATE user_info SET user_info.yumiaoAccount=#{number} WHERE user_info.userId=#{userId}")
    int updateYmMiaoAccoent(@Param("userId") String userId,@Param("number") String number);

    /**
     * 注册
     * @param username 用户名
     * @param userGender 性别
     * @param userPhone 手机号
     * @param registrationTime 注册日期
     * @param avatarImg 头像
     * @param userbirthday 生日
     * @return
     */
    @Insert("INSERT INTO user_info(userName,userGender,userPhone,registrationTime,avatarImg,userbirthday,lastLoginTime,yumiaoAccount)\n" +
            "VALUES (#{username},#{userGender},#{userPhone},#{registrationTime},#{avatarImg},#{userbirthday},#{last_login_time},#{yumiaoAccount})")
    int addNewUser(@Param("username") String username,
                   @Param("userGender") String userGender,
                   @Param("userPhone") String userPhone,
                   @Param("registrationTime") LocalDateTime registrationTime,
                   @Param("avatarImg") String avatarImg,
                   @Param("userbirthday") LocalDateTime userbirthday,
                   @Param("last_login_time") LocalDateTime last_login_time,
                   @Param("yumiaoAccount")String yumiaoAccount);

    @Update("update user_info set lastLoginTime = #{date} where userId = #{userid}")
    int updateLoginTime(@Param("date") LocalDateTime date,@Param("userid")String userid);

    /**
     * 更新成为会员
     * */
    @Update("update user_info set isVIP = 1 where userId = #{userid}")
    int updateVip(@Param("userid") Integer userid);

    /**
     * 更新取消成为会员
     * */
    @Update("update user_info set isVIP = 0 where userId = #{userid}")
    int loseVip(@Param("userid") Integer userid);

    //改变用户中绑定的店铺id
    @Update("update user_info set (shopid = #{shopid}) where userId = #{userid}")
    int updateIsshop(@Param("userid")Integer userid,@Param("shopid")Integer shopid);

    //更新成为小园丁
    @Update("update user_info set (isGarder=1) where userId = #{userid}")
    int updateGarder(@Param("userid")Integer userid);

    //更新userInfo信息表
    @Update("update user_info set NoteNumber = #{userInfo.NoteNumber} where userId = #{userInfo.userid}")
    int updateNoteNumber(@Param("userInfo")UserInfo userInfo);

    @Update("update user_info set allowcomment = #{type} where userId = #{userid}")
    int updateComment(@Param("userid")String userid,@Param("type")String type);

    /**
     * 查询用户名称是否重复
     * @param name
     * @return
     */
    @Select("select * from user_info where userName = #{name}")
    List<UserInfo> selectUserName(@Param("name") String name);

    //根据shopid查询user用户
    @Select("select * from user_info where shopid = #{shopid}")
    List<UserInfo> selectByshopid(@Param("shopid")String shopid);
}
