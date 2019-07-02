package com.yumiaobaobao.app.area.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.area.entity.trading_area;
import com.yumiaobaobao.app.area.service.trandingAreaService;
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
@Api(tags = "查询所有商圈")
public class tradingareaControllor {

    @Autowired
    private trandingAreaService tradingareaService;

    @RequestMapping(value = "findAllByFatherid",method = RequestMethod.GET)
    @ApiOperation(value = "根据父级id查询所有商圈",notes = "根据父级id查询所有商圈")
    public String findAllByFatherid(Integer fatherid){
        List<trading_area> allByFatherid = tradingareaService.findAllByFatherid(fatherid);
        if(allByFatherid==null||allByFatherid.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+ JSON.toJSONString(allByFatherid)+"}";
        }

}
