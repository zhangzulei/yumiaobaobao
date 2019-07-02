package com.yumiaobaobao.app.area.dao;

import com.yumiaobaobao.app.area.entity.trading_area;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradingareaMapper {

    /**
     * 根据父级id查询所有子类
     * */
    @Select("select * from trading_area where fatherId = #{fatherid}")
    List<trading_area> findAllByFatherid(Integer fatherid);

}
