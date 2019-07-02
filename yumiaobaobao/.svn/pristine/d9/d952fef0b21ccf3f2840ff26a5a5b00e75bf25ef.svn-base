package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.user_token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Repository
public interface user_tokenMapper {
    @Insert("insert into user_token (userid,token) values(#{token.userid},#{token.token})")
    int addToken(@Param("token") user_token token);

    @Update("update user_token set token = #{token.token} where userid = #{token.userid}")
    int updataToken(@Param("token") user_token token);

    @Select("select * from user_token where userid = #{userid}")
    List<user_token> findByUserId(@Param("userid") String userid);
}
