package com.yumiaobaobao.app.moremenu.myattention.personal.dao;

import com.yumiaobaobao.app.moremenu.myattention.personal.entity.UserFollow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository("userFollowMapper")
public interface UserFollowMapper {

     /**
     * 判断是否存在关注关系
     * @param user_id 被关注的用户的id
     * @param followuser_id 去关注的别的用户的用户的id
     * @return
     */
      @Select("SELECT * FROM user_follow WHERE user_id=#{userid}  AND followuser_id=#{followuserid}")
      List<UserFollow> selecType(@Param("userid") String user_id, @Param("followuserid") String followuser_id);
    /**
     * 判断是否存在互关关系
     * @param user_id 被关注的用户的id
     * @param followuser_id 去关注的别的用户的用户的id
     * @return
     */
    @Select("select a.* from user_follow a, user_follow b where a.user_id = b.followuser_id and a.followuser_id = " +
            "b.user_id  AND a.user_id =#{user_id}  AND a.followuser_id =#{followuser_id}")
    List<UserFollow> selecmutual(@Param("user_id") String user_id, @Param("followuser_id") String followuser_id);
    /**
     * 去关注
     *
     * @return
     */
     @Insert("INSERT INTO user_follow(user_id,followuser_id,createtime) VALUES(#{userid},#{followuserid},#{datetime})")
     int toAttention(@Param("userid") String user_id, @Param("followuserid") String followuser_id, @Param("datetime") LocalDateTime datetime);
    /**
     * 更新关注 用于取消关注
     * @return
     */
    @Delete("DELETE FROM user_follow WHERE  user_id=#{userid}  AND followuser_id=#{followuserid}")
    int deleteAttention(@Param("userid") String user_id, @Param("followuserid") String followuser_id);
    /**
     * 更新关注 用于取消关注
     * @return
     */
     @Select("SELECT user_id FROM user_follow WHERE  followuser_id=#{followuserid} and status = 1")
     List<UserFollow> selectAttention(@Param("followuserid") String followuser_id);
    /**
     * 根据用户id查询该用户粉丝的信息表id
     * @return
     */
     @Select("SELECT * FROM user_follow WHERE  followuser_id = #{userid} and status = 1")
     List<UserFollow> selectFollwAttention(@Param("userid") String user_id);
    /**
     * 与我互相关注的用户
     * @param userid
     * @return
     */
    @Select("select a.* from user_follow a, user_follow b where a.user_id = b.followuser_id and a.followuser_id = b.user_id   AND a.user_id =#{userid}")
    List<UserFollow> mutualattention(@Param("userid") String userid);

    //判断小园丁月关注信息
    @Select("SELECT MONTH (uf.createtime) AS MONTH, count(uf.id) AS number FROM user_follow uf left join user_info ui on uf.user_id = ui.userId " +
            "WHERE uf.user_id = #{userid} and ui.isGarder = 1 and year(uf.createtime)= #{year} group by Month(uf.createtime) ")
    List<Map<String,Object>> MonthByFollow(@Param("userid") String userid,@Param("year") String year);

    //判断小园丁年关注信息
    @Select("select Year(uf.createtime) as year,count(*) as number from user_follow uf left join user_info ui on uf.user_id = ui.userId" +
            " where uf.user_id = #{userid} and ui.isGarder = 1 group by Year(uf.createtime) ")
    List<Map<String,Object>> YearByFollow(@Param("userid") String userid);
}
