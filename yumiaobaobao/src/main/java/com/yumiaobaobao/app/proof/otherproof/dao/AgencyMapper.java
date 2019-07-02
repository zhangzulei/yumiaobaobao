package com.yumiaobaobao.app.proof.otherproof.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by WH on 2019/04/23.
 */

@Repository
public interface AgencyMapper {

    /**
     * 新增其他机构认证
     * @param map
     * @return
     */
    @Insert("INSERT INTO agency (userId,agencyType,agencyName,agencyAddress,agencyContact,agencyPhoneEmail,Checkinletter,businesslicense,OtherCertificate,createdate)\n" +
            "VALUES(#{map.userId},#{map.agencyType},#{map.agencyName},#{map.agencyAddress},#{map.agencyContact},#{map.agencyPhoneEmail},#{map.Checkinletter}," +
            "#{map.businesslicense},#{map.OtherCertificate},#{map.createdate})")
    int addAgency(@Param("map") Map<String,Object> map);
}
