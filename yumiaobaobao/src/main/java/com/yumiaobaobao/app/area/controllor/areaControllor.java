package com.yumiaobaobao.app.area.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.area.entity.area;
import com.yumiaobaobao.app.area.service.areaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@RestController
@Api(tags = "查询所有地区")
public class areaControllor {

    @Autowired
    private areaService areaServices;

    @RequestMapping(value = "allArea",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有地区",notes = "查询所有地区 Message ——> 0 没有数据")
    public String allArea(){
        List<area> areasList = areaServices.allArea();
        if(areasList==null||areasList.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+ JSON.toJSONString(areasList)+"}";
    }
}
