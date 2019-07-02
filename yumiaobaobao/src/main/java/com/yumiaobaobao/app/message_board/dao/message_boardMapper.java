package com.yumiaobaobao.app.message_board.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface message_boardMapper {
    //增加意见反馈
    @Insert("insert into message_board(userid,shopid,content,createtime) values (#{map.userid}," +
            "#{map.shopid},#{map.content},#{map.createtime})")
    int addMessageBoard(@Param("map")Map map);
}
