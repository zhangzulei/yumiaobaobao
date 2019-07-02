package com.yumiaobaobao.app.school_order.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.schoolscore.entity.schoolscore;
import com.yumiaobaobao.app.schoolscore.service.schoolScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@Api(tags = "学校排序 1.綜合排序 2.课堂质量排序 3.人气评分排序 4.距离排序 5.价格排序 （最低或者最高）")
public class SchoolOrderController {
    @Autowired
    private schoolScoreService schoolscoreService;

    @RequestMapping(value = "average", method = RequestMethod.GET)
    @ApiOperation(value = "综合排序", notes = "综合排序 Message 0 失败")
    public String average(@ApiParam("排序类型") @RequestParam("sortType") int sortType) {
        if (sortType == 1) {
            //綜合排序
            List<schoolscore> list = schoolscoreService.queryOrder();
            if (list != null && list.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(list) + "}";
            }
        } else if (sortType == 2) {
            //课堂质量排序
            List<schoolscore> list = schoolscoreService.queryScoreQualityOrder();
            if (list != null && list.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(list) + "}";
            }
        } else if (sortType == 3) {
            //人气评分排序
            List<schoolscore> list = schoolscoreService.queryPopularity();
            if (list != null && list.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(list) + "}";
            }
        } else if (sortType == 4) {
            //距离排序
            List<schoolscore> list = schoolscoreService.queryDistance();
            if (list != null && list.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(list) + "}";
            }
        } else if (sortType == 5) {
            //价格排序
            List<schoolscore> list = schoolscoreService.queryPrice();
            if (list != null && list.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(list) + "}";
            }
        }
        return "{\"Message\": \"0\"}";
    }







}
