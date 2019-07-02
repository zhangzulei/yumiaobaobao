package com.yumiaobaobao.app.shop.shophone.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.moremenu.myattention.Shop.service.ShopFollowService;
import com.yumiaobaobao.app.proof.mechanismproof.entity.OrganizaTion;
import com.yumiaobaobao.app.proof.mechanismproof.service.OrganizaTionService;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.shop.entity.school_photos;
import com.yumiaobaobao.app.shop.shophone.service.ShopHomeService;
import com.yumiaobaobao.app.user.comment.service.Serviceindex_discover;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.userupdate.service.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2019/04/10.
 */

@RestController
@Component
@Api(tags = "商户-首页 1.展示所有商户信息 2.根据id查询商铺信息")
public class ShopHoneController {

    @Autowired
    private ShopHomeService shopHomeService;
    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private OrganizaTionService organizaTionService;
    @Autowired
    private ShopFollowService shopFollowService;
    @Autowired
    private Serviceindex_discover serviceindex_discover;


    @ApiOperation(value = "展示所有商户信息", notes = "展示所有商户信息  Message  0=>数据库无信息 1=>成功")
    @RequestMapping(value = "/selectAllShop", method = RequestMethod.GET)
    public String selectAllShop() {
        List<Schoolshop> shopList = shopHomeService.selectAllShop();
        if (null == shopList || shopList.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(shopList) + "}";

    }

    @ApiOperation(value = "根据id查询商铺信息", notes = "根据id查询商铺信息  Message  0=>数据库无信息 1=>成功")
    @RequestMapping(value = "/selectAllShopbyId", method = RequestMethod.GET)
    public String selectAllShopbyId(@ApiParam("商铺id") @RequestParam("shopid") String shopid,
                                    @ApiParam("操作人id") @RequestParam("userid") String userid) {
        List<Schoolshop> schoolshops = shopHomeService.selectAllShopbyId(shopid);
        if (schoolshops == null || schoolshops.size() <= 0) {
            return "{\"Message\":\"0\"}";
        }
        List<Schoolshop> reslit = shopFollowService.Judge(userid, shopid);
        if (reslit == null || reslit.size() == 0) {
            schoolshops.get(0).setAttention("0");
        } else {
            schoolshops.get(0).setAttention("1");
        }
        return "{\"Message\":\"1\",\"Data\":" + JSON.toJSONString(schoolshops.get(0)) + "}";
    }

    //绑定店铺
    @ApiOperation(value = "绑定店铺", notes = "绑定店铺  Message  0=>该机构没有申请 1=>成功  -1=>该机构正在认证，暂不能绑定 " +
            "-2=>没有查询到店铺信息  -3=>没有查询到用户信息 -4=>更新用户信息失败")
    @RequestMapping(value = "/updateShopByUseridAndShopid", method = RequestMethod.GET)
    public String updateShopByUseridAndShopid(@ApiParam("userid") @RequestParam("userid") String userid,
                                              @ApiParam("商铺名称") @RequestParam("schoolname") String schoolname) {
        List<OrganizaTion> organizaTions = organizaTionService.selectByUsridAndName(Integer.valueOf(userid), schoolname);
        if (organizaTions == null || organizaTions.size() <= 0) {
            return "{\"Message\":\"0\"}";
        }
        Integer status = organizaTions.get(0).getStatus();
        if (status != 1) {
            return "{\"Message\":\"-1\"}";
        }
        List<Schoolshop> schoolshops = shopHomeService.selectByShopName(schoolname);
        if (schoolshops == null || schoolshops.size() <= 0) {
            return "{\"Message\":\"-2\"}";
        }
        UserInfo userInfo = userUpdateService.selectUserInfoByUserId(userid);
        if (userInfo == null) {
            return "{\"Message\":\"-3\"}";
        }
        int i = userUpdateService.updateIsshop(Integer.valueOf(userid), schoolshops.get(0).getId());
        if (i != 1) {
            return "{\"Message\":\"-4\"}";
        }
        return "{\"Message\":\"1\"}";
    }


    @ApiOperation(value = "根据店铺id查询店铺图集", notes = "根据店铺id查询店铺图集  Message  0=>数据库无信息 1=>成功")
    @RequestMapping(value = "/selectPhotoByShopid", method = RequestMethod.GET)
    public String selectPhotoByShopid(@ApiParam("商铺id") @RequestParam("photoshopId") String photoshopId) {
        List<school_photos> school_photos = shopHomeService.selectByShopid(photoshopId);
        if (school_photos == null || school_photos.size() <= 0) {
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"Data\",\"Data\":" + JSON.toJSONString(school_photos) + "}";
    }

    @ApiOperation(value = "根据店铺id查询店铺便签", notes = "根据店铺id查询店铺便签  Message  0=>数据库无信息 1=>成功")
    @RequestMapping(value = "/selectNoteByGarder", method = RequestMethod.GET)
    public String selectNoteByGarder(@ApiParam("商铺id") @RequestParam("shopId") String shopId) {
        List<UserInfo> userInfos = userUpdateService.selectByshopid(shopId);
        if (userInfos == null || userInfos.size() <= 0) {
            return "{\"Message\":\"0\"}";
        }
        List list = new ArrayList();
        //判断是否是小园丁
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getIsGarder() == 1) {
                List<index_discover> index_discovers = serviceindex_discover.selectByUserid(String.valueOf(userInfo.getUserid()));
                if (index_discovers != null || index_discovers.size() <= 0) {
                    for (index_discover index_discover : index_discovers) {
                        index_discover index_discover1 = serviceindex_discover.oneTemplate(String.valueOf(index_discover.getNoteid()));
                        list.add(index_discover1);
                    }
                }
            }
        }
        return "{\"Message\":\"1\",\"Data\":"+JSON.toJSONString(list)+"}";
    }
}
