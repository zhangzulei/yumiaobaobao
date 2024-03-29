package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.nice_detail;
import com.yumiaobaobao.app.user.entity.v_nice_detail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface nice_detailMapper {
    //查找点赞信息
    @Select("select * from nice_detail where userId=#{map.userid} and " +
            "templateId=#{map.templateid}")
    List<nice_detail> findNiceDetail(@Param("map")Map<String,Object> map);
    //查找被点赞人的信息获赞列表
    @Select("select news,createTime,avatarImg,Content,userId,Image from v_nice_detail where userinfoId=#{userinfoId}")
    List<v_nice_detail> selectNiceDetailCount(@Param("userinfoId") String userinfoId);

    //删除点赞信息
    @Delete("delete from nice_detail where ID=#{id}")
    Integer deleteNiceDetail(@Param("id") Integer id);

    //增加点赞信息
    @Insert("insert into nice_detail (userId,templateId,createtime,news,userinfoId) values (#{map.userid}," +
            "#{map.templateid},#{map.createtime},#{map.news},#{map.userinfoId})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer addNiceDetail(@Param("map")Map<String,Object> map);

    //点赞提醒信息
    List<nice_detail> noticeCollect();

    //查询小园丁被点赞的信息(月)
    @Select("select MONTH(nd.createTime) as month,count(nd.ID) as number from nice_detail nd left join user_info ui on nd.userinfoId = ui.userId " +
            "where nd.userinfoId = #{userinfoId} and ui.isGarder = 1 and YEAR(nd.createTime) = #{year} group by Month(nd.createTime)")
    Map<String,Object> countFavoAtMonth(@Param("userinfoId") String userinfoId,@Param("year") String year);

    //查询小园丁被点赞的信息(年)
    @Select("select YEAR(nd.createTime) as year,count(*) as number from nice_detail nd left join user_info ui on nd.userinfoId = ui.userId " +
            "where nd.userinfoId = #{userinfoId} and ui.isGarder = 1 group by Year(nd.createTime)")
    Map<String,Object> countFavoAtYear(@Param("userinfoId") String userinfoId);

    //查询某个用户获得的点赞信息
    @Select("select n.* from nice_detail n left join index_discover i on n.templateId = i.ID left join user_info u on " +
            "u.userId = i.userID where u.userId = #{userId}")
    List<nice_detail> getTextByUserid(@Param("userId") String userId);
}