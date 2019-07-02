package com.yumiaobaobao.app.shop.shophone.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.shop.shophone.service.SchoolshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019.05.28.
 */
@RestController
@Component
@Api(tags = "高级筛选排序")
public class SchoolShopController {

    @Autowired
    private SchoolshopService schoolshopService;

    @ApiOperation(value = "根据条件筛选", notes = " Message  0=>数据库无信息 1=>成功")
    @RequestMapping(value = "/selectAllShop", method = RequestMethod.POST)
    public String selectAllShop(Schoolshop schoolshop) {
        List<Schoolshop> shopList = schoolshopService.selectAllShop(schoolshop);
        if (null == shopList || shopList.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(shopList) + "}";
    }


    @RequestMapping(value = "selectClassType", method = RequestMethod.POST)
    @ApiOperation(value = "根据课程类型查询店铺", notes = " Message 0 没有数据")
    public String selectClassType( Schoolshop schoolshop) {
        List<Schoolshop> coursesList = schoolshopService.selectClassType(schoolshop);
        if (coursesList != null && coursesList.size() > 0) {
            return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(coursesList) + "}";
        }
        return "{\"Message\": \"0\"}";
    }


}
