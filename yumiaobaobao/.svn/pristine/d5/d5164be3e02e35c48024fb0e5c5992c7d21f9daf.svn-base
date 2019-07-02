package com.yumiaobaobao.app.shop.shophone.service.impl;

import com.yumiaobaobao.app.shop.dao.ShopRelateMapper;
import com.yumiaobaobao.app.shop.dao.school_photosMapper;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.shop.entity.school_photos;
import com.yumiaobaobao.app.shop.shophone.service.ShopHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */
@Service
public class ShopHomeServiceImpl implements ShopHomeService {

    @Autowired
    private ShopRelateMapper shopRelateMapper;
    @Autowired
    private school_photosMapper school_photosMapper;

    @Override
    public List<Schoolshop> selectAllShop() {
        return shopRelateMapper.selectAllShop();
    }

    @Override
    public List<Schoolshop> selectAllShopbyId(String shopId) {
        return shopRelateMapper.selectAllShopbyId(shopId);
    }

    @Override
    public List<Schoolshop> selectByShopName(String schoolname) {
        return shopRelateMapper.selectByShopName(schoolname);
    }

    @Override
    public List<school_photos> selectByShopid(String photoshopId) {
        return school_photosMapper.selectByShopid(photoshopId);
    }
}
