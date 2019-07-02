package com.yumiaobaobao.app.schoolteacher.dao;

import com.yumiaobaobao.app.schoolteacher.entity.school_teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Repository
public interface schoolteacherMapper {

    //根据商户id查询教师信息
    @Select("select * from school_teacher where school_shopid = #{schoolShopid}")
    List<school_teacher> selectByShopid(@Param("schoolShopid") Integer schoolShopid);

}
