package com.yumiaobaobao.app.user.scorechange.dao;

import com.yumiaobaobao.app.user.scorechange.entity.scorechange;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */
@Repository
public interface ScorechangeMapper {

    //新增积分变动记录
    @Insert("insert into scorechage(userid,score,post,createtime,notecreatetime,noteContent,getintegral,logintime) " +
            "values(#{map.userid},#{map.score},#{map.post},#{map.createtime},#{map.notecreatetime},#{map.noteContent}," +
            "#{map.getintegral},#{map.logintime})")
    int addScorechange(@Param("map") Map map);

    //根据用户id查询积分变动详情
    @Select("select * from scorechage where userid = #{userid} order by createtime ")
    List<scorechange> selectByUserid(@Param("userid")String userid);

    //查询用户最新的积分记录
    @Select("select * from scorechage where userid = #{userid} order by createtime desc limit 1 ")
    List<scorechange> selectLastByUserid(@Param("userid")String userid);

    //变更积分为0
    @Update("update scorechage set score = 0 where userid = #{userid} ")
    int updateScoreZero(@Param("userid")String userid);
}
