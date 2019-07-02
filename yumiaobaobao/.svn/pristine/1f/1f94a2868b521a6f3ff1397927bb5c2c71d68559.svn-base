package com.yumiaobaobao.app.proof.otherproof.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.proof.otherproof.dao.AgencyMapper;
import com.yumiaobaobao.app.proof.otherproof.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by WH on 2019/04/23.
 */

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;
    @Override
    public int addAgency(Map<String, Object> map) {
        map.put("createdate", DateUtils.newDateTime());
        return agencyMapper.addAgency(map);
    }
}
