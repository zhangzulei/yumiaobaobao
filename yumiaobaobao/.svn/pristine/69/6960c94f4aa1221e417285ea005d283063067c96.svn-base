package com.yumiaobaobao.app.taiking.dao;

import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.taiking.entity.talking;
import com.yumiaobaobao.app.user.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.yumiaobaobao.app.user.entity.index_discover;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/10.
 */
@Repository
public interface TaiKingMapper {

    /**
     * 可能感兴趣的专题
     * @param userid
     * @return
     */
    @Select("SELECT * FROM talking WHERE talkingid NOT IN (SELECT talkingid FROM talking_user WHERE userid=#{userid}) ORDER BY RAND() limit 10")
    List<talking> maytalking(@Param("userid") int userid);

    /**
     * 发布新专题
     * @param map
     * @return
     */
    @Insert("INSERT INTO talking(talkingtitle,talkingnote,talkingDatetime) VALUES(#{map.TalKingTitle},#{map.TalKingNote},#{map.talkingDatetime})")
    int addtalking(@Param("map") Map<String, Object> map);

    /***
     * 按热度查询专题下便签
     * @return
     */
    @Select("SELECT i.* FROM index_discover i left join talking t on i.talkingid = t.talkingid where i.talkingid = #{talkingid} order by i.CreateTime desc")
    List<index_discover> selectHoeTalking(@Param("talkingid")String talkingid);

    /***
     * 按最新查询专题下便签
     * @return
     */
    @Select("SELECT i.* FROM index_discover i left join talking t on i.talkingid = t.talkingid where i.talkingid = #{talkingid} order by i.commentCount ")
    List<index_discover> selectNewTalking(@Param("talkingid")String talkingid);

    /***
     * 根据专题id查询专题信息
     * @return
     */
    List<talking> bytalkingidselectTalking(@Param("list") List List);

    /**
     * 根据用户id查询该用户关注的专题id
     * @return
     */
    @Select("SELECT * FROM talking_user  WHERE talking_user.userid=#{userid}")
    List<talking> byUseridSelecttalkingid(@Param("userid") String userid);

    /**
     * 根据专题id查询关注该专题的用户id
     * @return
     */
    @Select("SELECT * FROM talking_user  WHERE talking_user.talkingid=#{talkingid}")
    List<UserInfo> bytalkingidSelectUserid(@Param("talkingid") String talkingid);

    //根据id查询talking信息
    @Select("select * from talking where talkingid = #{talkingId}")
    List<talking> selectById(@Param("talkingId")String talkingId);

    //推荐专题显示（三个）
    @Select("SELECT * FROM talking ORDER BY RAND() limit 3")
    List<talking> recommendtalking();

    //根据相关专题推荐商户
    @Select("SELECT * FROM school_shop ORDER BY RAND() limit 10")
    List<Schoolshop> recommendShop();

    //查询所有专题内容
    @Select("select * from talking")
    List<talking> allTalking();

    //更新专题信息
    @Update("update talking set talkingurl = #{map.talkingurl},talkingtitle = #{map.talkingtitle},talkingnote = #{map.talkingnote}," +
            "talkingnumber = #{map.talkingnumber},talkingLook = #{map.talkingLook},talkingtouch = #{map.talkingtouch}," +
            "taikingImg = #{map.taikingImg} where talkingid = #{map.talkingid} ")
    int updateTalking(@Param("map") Map map);
}
