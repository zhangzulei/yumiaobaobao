package com.yumiaobaobao.app.user.search.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.user.entity.search_history;
import com.yumiaobaobao.app.user.search.service.Search_HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "个人历史纪录")
@Slf4j
@RestController
public class HistoryController {
    @Autowired
    private Search_HistoryService historyService;

    @GetMapping("/history")
    @ApiOperation(value = "查询历史记录",notes = "根据用户ID获取个人历史记录 Message =>0 没有数据  Message=> 1 成功")
    public String oneHistory(String userId){
        List<search_history> search_histories = historyService.allHistory(userId);
        if(search_histories==null||search_histories.size()<=0){
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\",\"Data\":"+ JSON.toJSONString(search_histories)+"}";
    }
}
