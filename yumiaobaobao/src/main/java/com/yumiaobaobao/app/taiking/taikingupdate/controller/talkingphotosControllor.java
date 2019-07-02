package com.yumiaobaobao.app.taiking.taikingupdate.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.taiking.entity.talkingphotos;
import com.yumiaobaobao.app.taiking.taikingupdate.service.talkingphotosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags = "专题下图集查询")
@Slf4j
public class talkingphotosControllor {
    @Autowired
    private talkingphotosService talkingphotosService;

    @ApiOperation(value = "专题下图集查询",notes = "专题下图集查询 Message  0=>没有数据  1=>查询成功")
    @RequestMapping(value = "/selectByTalkingid",method = RequestMethod.GET)
    public String selectByTalkingid(@ApiParam("专题id") @RequestParam("talkingid")String talkingid){
        List<talkingphotos> talkingphotos = talkingphotosService.selectByTalkingid(talkingid);
        if(talkingphotos==null||talkingphotos.size()<=0){
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\",\"Data\":"+ JSON.toJSONString(talkingphotos)+"}";
    }

}
