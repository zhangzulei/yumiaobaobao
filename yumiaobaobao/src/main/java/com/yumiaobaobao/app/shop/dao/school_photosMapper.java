package com.yumiaobaobao.app.shop.dao;

import com.yumiaobaobao.app.shop.entity.school_photos;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface school_photosMapper {
    //通过店铺id查询店铺图集
    @Select("select * from school_photos where photoshopId = #{photoshopId}")
    List<school_photos> selectByShopid(@Param("photoshopId")String photoshopId);

}
