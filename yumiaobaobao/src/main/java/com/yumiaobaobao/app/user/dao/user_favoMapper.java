package com.yumiaobaobao.app.user.dao;


import com.yumiaobaobao.app.user.entity.user_favo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface user_favoMapper {
    Boolean addTags(user_favo user_favo);

    List<user_favo> confirmShow(@Param("userId") String userId);

    Boolean deleteByPrimaryKey(Integer id);

    Boolean insert(user_favo user_favo);

    Boolean insertSelective(user_favo user_favo);

    Boolean updateByPrimaryKeySelective(user_favo user_favo);

    Boolean updateByPrimaryKey(user_favo user_favo);


    /**
     * 查看新增粉丝
     * @param map
     * @return
     */
    @Select("select * from user_favo where userId=#{map.userid} and " +
            "fatherId=#{map.fatherid}")
    List<user_favo> userfavo(@Param("map")Map<String,Object> map);

    //增加粉丝信息
    @Insert("insert into user_favo (userId,fatherId,typeId,chooseTime) values (#{map.userId}," +
            "#{map.fatherId},#{map.typeId},#{map.chooseTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer addFavo(@Param("map")Map<String,Object> map);

    /**
     * 粉丝列表
     * @return
     */
    List<user_favo> selectfansList();




}