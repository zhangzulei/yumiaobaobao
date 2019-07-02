package com.yumiaobaobao.app.moremenu.myattention.Shop.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.myattention.Shop.dao.ShopFollowMapper;
import com.yumiaobaobao.app.moremenu.myattention.Shop.entity.shopFollow;
import com.yumiaobaobao.app.moremenu.myattention.Shop.service.ShopFollowService;
import com.yumiaobaobao.app.shop.dao.ShopRelateMapper;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by WH on 2019/03/27.
 */
@Service
public class ShopFollowServiceImpl implements ShopFollowService {

    @Autowired
    private ShopFollowMapper shopFollowMapper;
    @Autowired
    private ShopRelateMapper shopRelateMapper;


    @Override
    public List<Schoolshop> mayShop(int userid, int number) {
        return shopRelateMapper.mayShop(userid,number);
    }

    @Override
    public int addShopFollow(String userid, String shopid) {
        return shopFollowMapper.addShopFollow(userid,shopid, DateUtils.newDateTime());
    }

    @Override
    public int deleteShopFollow(String userid, String shopid) {
        return shopFollowMapper.deleteShopFollow(userid,shopid);
    }

    @Override
    public List<shopFollow> byUsreidSelectShopInfo(String userid) {
        return shopFollowMapper.byUsreidSelectShopInfo(userid);
    }

    @Override
    public List<Schoolshop> Judge(String userid, String shopid) {
        return shopFollowMapper.Judge(userid,shopid);
    }

    @Override
    public List<Schoolshop> selectAllShopbyListId(List list) {
        return shopRelateMapper.selectAllShopbyListId(list);
    }

    @Override
    public int addfanNumber(String shopid) {
        return shopRelateMapper.addfanNumber(shopid);
    }

    @Override
    public int lessfanNumber(String shopid) {
        return shopRelateMapper.lessfanNumber(shopid);
    }

}
