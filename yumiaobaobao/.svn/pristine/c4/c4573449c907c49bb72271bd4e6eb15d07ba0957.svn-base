package com.yumiaobaobao.app.user.scorechange.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.user.scorechange.entity.scorechange;
import com.yumiaobaobao.app.user.scorechange.service.scorechangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@RestController
@Api(tags = "消息通知:查询积分变更信息")
public class scorechangeControllor {
    @Autowired
    private scorechangeService scorechangeService;

    @RequestMapping(value ="/selectAllScorechange" ,method = RequestMethod.GET)
    @ApiOperation(value ="查询所有积分变更记录" ,notes ="查询所有积分变更记录 Message=>0 没有查询到信息")
    public String selectAllScorechange(@ApiParam("用户id") @RequestParam("userid")String userid){
        List<scorechange> scorechanges = scorechangeService.selectByUserid(userid);
        if(scorechanges==null||scorechanges.size()<=0){
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\",\"Data\":"+ JSON.toJSONString(scorechanges)+"}";
    }
}
