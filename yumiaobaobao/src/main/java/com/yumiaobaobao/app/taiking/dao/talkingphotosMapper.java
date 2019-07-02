package com.yumiaobaobao.app.taiking.dao;

import com.yumiaobaobao.app.taiking.entity.talkingphotos;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface talkingphotosMapper {

    //查询专题下图集
    @Select("select * from talkingphotos where talkingshopId = #{talkingid}")
    List<talkingphotos> selectByTalkingid(@Param("talkingid")String talkingid);
}
