package com.yumiaobaobao.app.moremenu.myattention.Shop.service;


import com.yumiaobaobao.app.moremenu.myattention.Shop.entity.shopFollow;
import com.yumiaobaobao.app.shop.entity.Schoolshop;

import java.util.List;

/**
 * Created by WH on 2019/03/27.
 */
public interface ShopFollowService {

    /***
     * 可能感兴趣的店铺
     */
    List<Schoolshop> mayShop(int userid, int number);

    /**
     * 新增关注关系
     */
    int addShopFollow(
            String userid,
            String shopid
    );
    /**
     * 取消关注关系
     */
    int deleteShopFollow(
            String userid,
            String shopid
    );

    /**
     *  根据用户id 查询此用户关注的店铺
     */
    List<shopFollow> byUsreidSelectShopInfo(
            String userid
    );
    /**
     * 判断用户和商家是否存在关系
     */
    List<Schoolshop> Judge(
            String userid,
            String shopid
    );

    /**
     * 根据商户id查询所有商户
     * @param list 商户id集合
     * @return
     */
    List<Schoolshop> selectAllShopbyListId(List list);
    /**
     *  给商户增加粉丝
     * @param shopid
     */
    int addfanNumber(String shopid);
    /**
     *  给商户减少粉丝
     * @param shopid
     */
    int lessfanNumber(String shopid);
}
