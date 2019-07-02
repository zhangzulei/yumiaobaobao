package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.search_history;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface search_historyMapper {
    @Insert("insert into search_history (historySearch,userId,searchTime) " +
            "values (#{map.historysearch},#{map.userid},#{map.searchTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int addHistory(@Param("map")Map map);

    @Select("select ID,historySearch,searchTime,userId from search_history where userId=#{userid}")
    List<search_history> allHistory(@Param("userid") String userId);
}