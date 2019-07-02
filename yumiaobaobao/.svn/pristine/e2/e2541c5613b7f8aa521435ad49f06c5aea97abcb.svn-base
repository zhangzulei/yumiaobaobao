package com.yumiaobaobao.app.proof.mechanismproof.dao;


import com.yumiaobaobao.app.proof.mechanismproof.entity.OrganizaTion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrganizaTionMapper {


    /**
     * 根据用户机构认证状态
     * @param userId
     * @return
     */
    @Select("SELECT status FROM organization WHERE status = #{userId}")
    OrganizaTion selectAgencyDocument(@Param("userId") String userId);


    /**
     * 添加新的机构认证
     * @param map
     * @return
     */
    @Insert("INSERT INTO organization(applicantId,organizationAvatarimg,organizationName,organizationSynopsis,organizationType,organizationAddress,businesslicense,certificationletter,\n" +
            "tradeMark,Runningschool,Privateunit,OthercertiFicate,\n" +
            "CompanyName,UnifiedSocialNewCode,OperatingPeriod,BusinessName,BusinessOperatorMobileNumber,applicationTime)\n" +
            "VALUES ( #{map.applicantId}, #{map.organizationAvatarimg}, #{map.organizationName}, #{map.organizationSynopsis}," +
            " #{map.organizationType}, #{map.organizationAddress}, #{map.businesslicense},#{map.certificationletter}," +
            "#{map.tradeMark}, #{map.Runningschool}, #{map.Privateunit},#{map.OthercertiFicate}," +
            "#{map.CompanyName},#{map.UnifiedSocialNewCode}, #{map.OperatingPeriod}, #{map.BusinessName}, #{map.BusinessOperatorMobileNumber},#{map.applicationTime});")
    int addOrganizaTion(@Param("map")Map<String,Object> map);

    //通过用户id和机构名称查询机构是否存在
    @Select("select * from organization where applicantId = #{userid} and organizationName = #{organizationName}")
    List<OrganizaTion> selectByUsridAndName(@Param("userid")Integer userid,
                                            @Param("organizationName")String organizationName);
}