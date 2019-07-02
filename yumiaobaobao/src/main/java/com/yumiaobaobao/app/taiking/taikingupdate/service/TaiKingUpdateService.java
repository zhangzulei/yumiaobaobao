package com.yumiaobaobao.app.taiking.taikingupdate.service;

import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.taiking.entity.talking;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.entity.user_favo;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/10.
 */
public interface TaiKingUpdateService {

    /**
     * 发布新专题
     */
    int addTalKing(Map<String, Object> map);

    List<user_favo> confirmShow(String userId);

    List<talking> maytalking(int userid);

    List<index_discover> selectHoeTalking(String talkingid);

    List<index_discover> selectNewTalking(String talkingid);

    List<talking> selectById(String talkingId);

    List<talking> recommendtalking();

    List<Schoolshop> recommendShop();

    List<talking> allTalking();

    int updateTalking(Map map);
}
