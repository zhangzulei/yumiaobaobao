package com.yumiaobaobao.app.shop.shophone.service;

import com.yumiaobaobao.app.shop.entity.Schoolshop;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019.05.28.
 */
public interface SchoolshopService {

    List<Schoolshop> selectAllShop(Schoolshop schoolshop);

    /**
     * 根据课程类型查店铺
     * @param schoolshop
     * @return
     */
    List<Schoolshop> selectClassType(Schoolshop schoolshop);

    int updateAvgScoreByShopid(String shopid, Map map);

}
