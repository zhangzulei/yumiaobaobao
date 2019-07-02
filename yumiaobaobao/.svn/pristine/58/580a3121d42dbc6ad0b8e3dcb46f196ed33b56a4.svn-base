package com.yumiaobaobao.app.shop.dao;

import com.yumiaobaobao.app.shop.entity.Schoolshop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */

@Repository
public interface ShopRelateMapper {

    /***
     * 可能感兴趣的店铺
     * @param number
     * @return
     */
    @Select("SELECT * FROM school_shop WHERE id NOT IN " +
            "(SELECT shop_follow.shopid FROM shop_follow WHERE userId=#{userid}) ORDER BY RAND() LIMIT ${number}")
    List<Schoolshop> mayShop(@Param("userid") int userid, @Param("number") int number);

    /**
     * 查询所有商户
     * @return
     */
    @Select("SELECT * FROM school_shop")
    List<Schoolshop> selectAllShop();

    /**
     * 根据商户id查询所有商户
     * @param shopId 单个商户id
     * @return
     */
    @Select("SELECT * FROM school_shop where id=#{shopId}")
    List<Schoolshop> selectAllShopbyId(@Param("shopId") String shopId);

    /**
     * 根据商户id查询所有商户
     * @param list 商户id集合
     * @return
     */
    List<Schoolshop> selectAllShopbyListId(@Param("list") List list);

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
    @Insert("INSERT INTO school_shop(schoolname,tradingArea,schooladdress,schoolphone,schoolcoll,schoolOpentime,sendtime,schoolshopImg)\n" +
            "VALUES(#{shopName},#{tradingArea},#{schoolAddress},#{schoolPhone},#{schoolColl},#{schoolOpenTime},#{sendTime},#{schoolshopImg})")
    int addShop(
            @Param("shopName")String shopName,
            @Param("tradingArea")int tradingArea,
            @Param("schoolAddress")String schoolAddress,
            @Param("schoolPhone")String schoolPhone,
            @Param("schoolColl")String schoolColl,
            @Param("schoolOpenTime")LocalTime schoolOpenTime,
            @Param("sendTime")LocalTime sendTime,
            @Param("schoolshopImg")String schoolshopImg

    );

    /**
     *  给商户增加粉丝
     * @param shopid
     */
    @Update("UPDATE  school_shop  SET fenNumber = fenNumber +1 WHERE id = #{shopid}")
    int addfanNumber(@Param("shopid")String shopid);

    /**
     *  给商户减少粉丝
     * @param shopid
     */
    @Update("UPDATE  school_shop  SET fenNumber = fenNumber -1 WHERE id = #{shopid}")
    int lessfanNumber(@Param("shopid")String shopid);

    /**
     *  商户封面图片上传
     * @param imgFile
     */
    @Update("UPDATE  school_shop  SET schoolshopImg = #{imgFile} WHERE id = #{shopId}")
    int shopHeadImg(@Param("imgFile")String imgFile,
                    @Param("shopId")String shopId);

    //根据店铺名称查询店铺
    @Select("select * from school_shop where schoolname = #{schoolname}")
    List<Schoolshop> selectByShopName(@Param("schoolname")String schoolname);


    //判断店铺名称是否重复
    @Select("select * from school_shop where schoolname = #{schoolname}")
    List<Schoolshop> selectByShopname(@Param("schoolname")String schoolname);
}
