package com.yumiaobaobao.app.proof.mechanismproof.service;


import com.yumiaobaobao.app.proof.mechanismproof.entity.OrganizaTion;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/04/16.
 */
public interface OrganizaTionService {

    /**
     * 根据用户机构认证状态
     * @param userId
     * @return
     */
    OrganizaTion selectAgencyDocument(String userId);

    /**
     * 添加新的机构认证
     * @return
     */
    int addOrganizaTion(Map<String,Object> map);


    List<OrganizaTion> selectByUsridAndName(Integer userid,String organizationName);
}
