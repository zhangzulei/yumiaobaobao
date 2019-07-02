package com.yumiaobaobao.app.user.draft.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.user.draft.service.user_draftService;
import com.yumiaobaobao.app.user.entity.user_draft;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
@Api(tags = "草稿  ---> 存储，删除，查询")
public class user_draftContollor {
    @Autowired
    private user_draftService draftService;

    @ApiOperation(value = "新增草稿 --> Message 0 成功  1 失败 ", notes = "新增草稿 Message 0 成功  1 失败")
    @RequestMapping(value = "/addDraft", method = RequestMethod.GET)
    public String addDraft(@RequestParam(value = "draft", required = true) user_draft draft) {
        Boolean a = draftService.addDraft(draft);
        if (!a) {
            return "{\"Message\": \"1\"}";
        }
        return "{\"Message\": \"0\"}";
    }

    @ApiOperation(value = "删除草稿 --> Message 0 成功  1 失败 ", notes = "删除草稿 Message 0 成功  1 失败")
    @RequestMapping(value = "/deleteDraft", method = RequestMethod.GET)
    public String deleteDraft(@RequestParam(value = "Id", required = true) Integer Id) {
        Boolean a = draftService.deleteDraft(Id);
        if (!a) {
            return "{\"Message\": \"1\"}";
        }
        return "{\"Message\": \"0\"}";
    }

    @ApiOperation(value = "查询草稿 --> Message 0 失败 ", notes = "查询草稿 Message 0  失败")
    @RequestMapping(value = "/allDraft", method = RequestMethod.GET)
    public String allDraft(@RequestParam(value = "Id", required = true) String user_id) {
        List<user_draft> user_drafts = draftService.allDraft(user_id);
        if (user_drafts.size() == 0 || user_drafts == null) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(user_drafts) + "}";
    }

}
