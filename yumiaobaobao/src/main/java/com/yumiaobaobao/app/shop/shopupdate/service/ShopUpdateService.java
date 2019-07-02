package com.yumiaobaobao.app.shop.shopupdate.service;

import com.yumiaobaobao.app.shop.entity.Schoolshop;

import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */
public interface ShopUpdateService {

    /**
     * 新增商户
     * @param shopName 商户名
     * @param schoolAddress 地址
     * @param schoolPhone 手机号
     * @param schoolColl 座机
     * @param schoolOpenTime 上班时间
     * @param sendTime 下班时间
     * @return
     */
     int addShop(
          String shopName,
          int tradingArea,
          String schoolAddress,
          String schoolPhone,
          String schoolColl,
          String schoolOpenTime,
          String sendTime
    );

    /**
     *  商户封面图片上传
     */
    int shopHeadImg(String imgFile,String ShopId);

    List<Schoolshop> selectByShopname(String schoolname);
}
