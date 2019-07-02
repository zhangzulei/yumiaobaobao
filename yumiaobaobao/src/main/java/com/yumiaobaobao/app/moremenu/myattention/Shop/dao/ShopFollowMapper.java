package com.yumiaobaobao.app.moremenu.myattention.Shop.dao;

import com.yumiaobaobao.app.moremenu.myattention.Shop.entity.shopFollow;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WH on 2019/03/27.
 * 店铺关注
 */
@Repository
public interface ShopFollowMapper {



    /**
     * 判断用户和商家是否存在关系
     * @param userid 用户id
     * @param shopid 店铺id
     * @return
     */
    @Select("SELECT * FROM shop_follow WHERE userid=#{userid} AND shopid=#{shopid}")
    List<Schoolshop> Judge(
            @Param("userid") String userid,
            @Param("shopid") String shopid
    );
    /**
     * 新增关注关系
     * @param userid 用户id
     * @param shopid 店铺id
     * @return
     */
    @Insert("INSERT INTO shop_follow(userid,shopid,createtime) VALUES(#{userid},#{shopid},#{datetime})")
    int addShopFollow(
            @Param("userid") String userid,
            @Param("shopid") String shopid,
            @Param("datetime") LocalDateTime dateTime
    );

    /**
     * 取消关注关系
     * @param userid 用户id
     * @param shopid 店铺id
     * @return
     */
    @Delete("DELETE FROM  shop_follow WHERE userid=#{userid} AND shopid=#{shopid}")
    int deleteShopFollow(
            @Param("userid") String userid,
            @Param("shopid") String shopid
    );

    /**
     *  根据用户id 查询此用户关注的店铺
     * @return
     */
    @Select("SELECT shop_follow.shopid FROM shop_follow WHERE shop_follow.userid =#{userid}")
    List<shopFollow> byUsreidSelectShopInfo(
            @Param("userid") String userid
    );
}
