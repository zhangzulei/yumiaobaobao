package com.yumiaobaobao.app.shop.shophone.service.impl;

import com.yumiaobaobao.app.shop.dao.school_shop_scoreMapper;
import com.yumiaobaobao.app.shop.entity.school_shop_score;
import com.yumiaobaobao.app.shop.shophone.service.school_shop_scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */

@Service
public class school_shop_scoreServiceImpl implements school_shop_scoreService {

    @Autowired
    private school_shop_scoreMapper school_shop_scoreMapper;

    @Override
    public int addShopScore(Map map) {
        return school_shop_scoreMapper.addShopScore(map);
    }

    @Override
    public List<String> selectAvgScore(String shopid) {
        return school_shop_scoreMapper.selectAvgScore(shopid);
    }

    @Override
    public List<school_shop_score> selectByShopid(String shopid) {
        return school_shop_scoreMapper.selectByShopid(shopid);
    }

}
