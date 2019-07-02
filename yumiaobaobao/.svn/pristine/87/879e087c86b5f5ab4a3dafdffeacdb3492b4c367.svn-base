package com.yumiaobaobao.app.message_board.controllor;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */

@RestController
@Api(tags = "意见反馈")
public class message_boardControllor {
    @Autowired
    private com.yumiaobaobao.app.message_board.service.message_boardService message_boardService;

    @RequestMapping(value = "/addMessageBoard",method = RequestMethod.GET)
    @ApiOperation(value = "新增意见反馈",notes = "新增意见反馈  Message =>0新增失败  =>1 成功")
    @Transactional
    public String addMessageBoard(@ApiParam("留言的人id") @RequestParam("userid") String userid,
                                  @ApiParam("被留言的商铺id") @RequestParam("shopid") String shopid,
                                  @ApiParam("留言的内容") @RequestParam("content") String content){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",userid);
        map.put("shopid",shopid);
        map.put("content",content);
        map.put("createtime", DateUtils.newDateTime());
        int i = message_boardService.addMessageBoard(map);
        if(i<=0){
            return "{\"Message\":\"0\"}";
        }
        return "{\"Message\":\"1\"}";
    }

}
