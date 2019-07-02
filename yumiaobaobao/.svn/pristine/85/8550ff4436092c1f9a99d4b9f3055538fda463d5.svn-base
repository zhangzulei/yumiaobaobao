package com.yumiaobaobao.app.moremenu.myattention.taiking.dao;

import com.yumiaobaobao.app.moremenu.myattention.taiking.entity.TaiKingFollow;
import com.yumiaobaobao.app.user.entity.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */
@Repository
public interface TaiKingFollowMapper {

    /**
     * 关注专题
     * @param userid
     * @param talkingid
     * @return
     */
    @Insert("INSERT INTO talking_user(userid,talkingid,createtime) VALUES(#{userid}, #{talkingid},#{datetime})")
    int addtakingtouch(@Param("userid") String userid, @Param("talkingid") String talkingid, @Param("datetime") LocalDateTime dateTime);


    /**
     * 取关专题
     * @param userid
     * @param talkingid
     * @return
     */
    @Delete("DELETE FROM  talking_user WHERE userid=#{userid} AND talkingid=#{talkingid}")
    int lesstakingtouch(@Param("userid") String userid, @Param("talkingid") String talkingid);

    /**
     * 我关注的专题 获取专题id
     * @param userid
     * @return
     */
    @Select("SELECT talkingid FROM talking_user WHERE userid=#{userid}")
    List<TaiKingFollow> selectAttention(@Param("userid") String userid);

    /**
     * 查询用户和专题之间是否关注
     * @return
     */
    @Select("SELECT * FROM talking_user  WHERE talkingid=#{talkingid}  and userid=#{userid}")
    List<UserInfo> selectTouch(@Param("userid") String userid, @Param("talkingid") String talkingid);

}
