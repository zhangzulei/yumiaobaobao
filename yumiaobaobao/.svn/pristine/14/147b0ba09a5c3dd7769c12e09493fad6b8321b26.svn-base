package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.user_level_info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface user_level_infoMapper {

    /**
     * 根据userid查询user_level_info信息
     * */
    @Select("select * from user_level_info where CreaterUser = #{userid}")
    List<user_level_info> findByUserid(@Param("userid")Integer userid);

    /**
     * 登录增加积分
     * */
    @Update("update user_level_info set Score = Score + 5,Remark = '登录增加5积分' where CreaterUser = #{userid} ")
    int updateScoreByLogin(@Param("userid")Integer userid);

    /**
     * 发表文章增加积分
     * */
    @Update("update user_level_info set Score = Score + 300,Remark = '发表文章增加300积分' where CreaterUser = #{userid} ")
    int updateScoreByArticle(@Param("userid")Integer userid);

    /**
     * 没有发表文章扣除35积分
     **/
    @Update("update user_level_info set Score = Score - 35,Remark = '没有发表文章扣除35积分' where CreaterUser = #{userid} ")
    int reduceScore(@Param("userid")Integer userid);

    /**
     * 增加用户积分记录
     * */
    @Insert("insert into user_level_info (LevelName,LevelDesc,Avatar,Score,ExtendAttr,Remark,Deleted," +
            "CreaterUser,UpdateUser,CreateTime,UpdateTime) values (#{maps.LevelName},#{maps.LevelDesc}," +
            "#{maps.Avatar},#{maps.Score},#{maps.ExtendAttr},#{maps.Remark},#{maps.Deleted}," +
            "#{maps.CreaterUser},#{maps.UpdateUser},#{maps.CreateTime},#{maps.UpdateTime})")
    int addUserLevelInfo(@Param("maps") Map<String,Object> maps);

    //更新积分为0的方法
    @Update("update user_level_info set Score = 0 where CreaterUser = #{userid}")
    int updateScoreZero(@Param("userid")Integer userid);
}
