package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.index_discover;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface index_discoverMapper {
    //用户关注的人的动态展示
    List<index_discover> followerIndex(@Param("nainiuaccoent") String nainiuaccoent);

    //根据用户喜欢的Talking来显示所有说说
    List<index_discover> alltemplate(@Param("nainiuaccoent") String nainiuaccoent);
    //
    index_discover searchContent(@Param("content") String content);
    //改变说说的喜欢数量
    Boolean changeFavo(index_discover index_discover);
    //展示所有用户没有选择Talking的状况夏来展示所有用户信息
    List<index_discover> notagsAll();
    //根据用户的经纬度来展示说说详情
    List<index_discover> AllLocation(@Param("Latitude") Double Latitude, @Param("Longitude") Double Longitude,@Param("pagenum")int pagenum,@Param("pagesize")int pagesize);

    index_discover oneTemplate(@Param("templateid") String templateid);

    List<index_discover> fuzzyQuery(@Param("content") String content);

    @Update("update index_discover set commentCount=#{commentcount} where ID=#{noteid} ")
    Boolean changecommentCount(index_discover index_discover);

    @Update("update index_discover set collectCount=#{collectcount} where ID = #{noteid}")
    Boolean changeCollectCount(index_discover index_discover);

    //根据用户的芋苗宝宝账号进行查询个人的发布的信息详情
    List<index_discover> queryOneByNainiuAccoent();

    @Insert("insert into index_discover (Image,Images,Imaget,Imagef,favoCount,Content,userID,CreateTime," +
            "CommentID,currentLocation,favoStatus,schooltypename,Latitude,Longitude,commentCount,collectCount," +
            "talkingid,remindPerson) values (#{map.image},#{map.images},#{map.imaget},#{map.imagef},#{map.favoCount}," +
            "#{map.content},#{map.userid},#{map.createTime},#{map.CommentID},#{map.currentLocation},#{map.favoStatus},#{map.schooltypename}," +
            "#{map.Latitude},#{map.Longitude},#{map.commentCount},#{map.collectCount},#{map.talkingID},#{map.remindpreson} )")
    int addIndexDiscover(@Param("map") Map<String, Object> map);

   /* @Select("select ID noteid,Image,Images,Imagef,Imaget,favoCount,Content,userID,CreateTime,CommentID," +
            "currentLocation,remindPerson,favoStatus,schooltypename,Latitude,Longitude,commentCount," +
            "collectCount,talkingid from index_discover order by CreateTime desc")*/
    List<index_discover> selectAll(@Param("pagenum") int pagenum,@Param("pagesize")int pagesize);

    //根据userid查询最近一条便签的发布时间
    @Select("select ID,Image,Images,Imagef,Imaget,favoCount,Content,userID,CreateTime,CommentID," +
            "currentLocation,remindPerson,favoStatus,schooltypename,Latitude,Longitude,commentCount," +
            "collectCount,talkingid from index_discover where userID = #{userid} order by CreateTime limit 1 ")
    List<index_discover> selectByUseridLast(@Param("userid") Integer userid);
    //根据Noteid查询最近一条便签的发布时间
    @Select("select ID,Image,Images,Imagef,Imaget,favoCount,Content,userID,CreateTime,CommentID," +
            "currentLocation,remindPerson,favoStatus,schooltypename,Latitude,Longitude,commentCount," +
            "collectCount,talkingid from index_discover where ID = #{Noteid}")
    index_discover selectCollection(@Param("Noteid") Integer Noteid);

    //推荐专题下的随机便签
    @Select("select i.* from  index_discover i where i.talkingid = #{talkingid} order by rand() limit 30")
    List<index_discover> recommendNotes(@Param("talkingid") Integer talkingid);

    //根据userid 查询便签的信息
//    @Select("select i.*,u.* from index_discover i left join user_info u on i.userId = u.userId " +
//            "where i.userID = #{userid}")
    List<index_discover> selectByUserid(@Param("userid") String userid);

    //是否在附近显示自己的便签
    @Update("update index_discover set isshow = #{isshow}  where userID = #{userid}")
    int hideIsShow(@Param("userid")String userid,@Param("isshow")String isshow);

    //随机推荐三个便签
    List<index_discover> randomIndexDiscover();
}