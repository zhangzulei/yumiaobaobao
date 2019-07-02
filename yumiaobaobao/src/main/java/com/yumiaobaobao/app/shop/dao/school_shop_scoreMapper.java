package com.yumiaobaobao.app.shop.dao;

import com.yumiaobaobao.app.shop.entity.school_shop_score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface school_shop_scoreMapper {

    //  新增店铺评分
    @Insert("insert into school_shop_score(shopid,score_quality,score_surroundings,score_Popularity,comment,commentimg," +
            "userid,createtime) values(#{map.shopid},#{map.scorequality},#{map.scoresurroundings},#{map.scorePopularity}," +
            "#{map.comment},#{map.commentimg},#{map.userid},#{map.createtime})")
    int addShopScore(@Param("map") Map map);

    //查询特定店铺的平均评分
    @Select("select (score/3) scores from (select sum(score_quality + score_surroundings + score_Popularity) score  " +
            "from school_shop_score where shopid = #{shopid}) a ")
    List<String> selectAvgScore(@Param("shopid")String shopid);

    //根据店铺id查询评论
    @Select("select * from school_shop_score where shopid = #{shopid}")
    List<school_shop_score> selectByShopid(@Param("shopid")String shopid);
}
