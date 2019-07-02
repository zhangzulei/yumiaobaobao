package com.yumiaobaobao.app.proof.mechanismproof.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.proof.mechanismproof.dao.OrganizaTionMapper;
import com.yumiaobaobao.app.proof.mechanismproof.entity.OrganizaTion;
import com.yumiaobaobao.app.proof.mechanismproof.service.OrganizaTionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/16.
 */
@Service
public class OrganizaTionServiceImpl implements OrganizaTionService {

    @Autowired
    private OrganizaTionMapper organizaTionMapper;

    @Override
    public OrganizaTion selectAgencyDocument(String userId) {
        return organizaTionMapper.selectAgencyDocument(userId);
    }

    @Override
    public int addOrganizaTion(Map<String, Object> map) {
        map.put("applicationTime", DateUtils.newDateTime());
        return organizaTionMapper.addOrganizaTion(map);
    }

    @Override
    public List<OrganizaTion> selectByUsridAndName(Integer userid, String organizationName) {
        return organizaTionMapper.selectByUsridAndName(userid,organizationName);
    }
}
