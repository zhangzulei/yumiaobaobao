package com.yumiaobaobao.app.moremenu.Feedback.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.moremenu.Feedback.dao.OpinionMapper;
import com.yumiaobaobao.app.moremenu.Feedback.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by WH on 2019/03/27.
 */
@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    private OpinionMapper OpinionMapper;

    @Override
    public int addopinion(Map<String, Object> map) {
        map.put("probledatetime", DateUtils.newDateTime());
        return OpinionMapper.addopinion(map);
    }

    @Override
    public int addNote(Map<String, Object> map) {
        map.put("appealdatetime", DateUtils.newDateTime());
        return OpinionMapper.addNote(map);
    }
}
