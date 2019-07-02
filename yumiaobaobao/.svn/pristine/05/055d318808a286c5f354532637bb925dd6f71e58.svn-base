package com.yumiaobaobao.app.shop.shophone.service.impl;

import com.yumiaobaobao.app.shop.dao.SchoolshopMapper;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.shop.shophone.service.SchoolshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019.05.28.
 */
@Service
public class SchoolshopServiceImpl implements SchoolshopService {
    @Autowired
    private SchoolshopMapper schoolshopMapper;

    /**
     * 课程店铺高级筛选
     * @param schoolshop
     * @return
     */
    @Override
    public List<Schoolshop> selectAllShop(Schoolshop schoolshop) {
        return schoolshopMapper.selectAllShop(schoolshop);
    }

    /**
     * 根据课程类型查询店铺
     * @param schoolshop
     * @return
     */
    @Override
    public List<Schoolshop> selectClassType(Schoolshop schoolshop) {
        return schoolshopMapper.selectClassType(schoolshop);
    }

    @Override
    public int updateAvgScoreByShopid(String shopid, Map map) {
        return schoolshopMapper.updateAvgScoreByShopid(shopid,map);
    }


}
