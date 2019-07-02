package com.yumiaobaobao.app.proof.userproof.dao;

import com.yumiaobaobao.app.proof.userproof.entity.PaperWork;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by WH on 2019/04/11.
 */
@Repository
public interface UserProofMapper {


    /**
     * 根据用户id查询用户认证状态
     * @param userId
     * @return
     */
    @Select("SELECT * FROM paperwork WHERE userid = #{userId}")
    PaperWork selectPaperWork(@Param("userId")String userId);

    /**
     * 根据id 删除审核失败的记录
     * @param userId
     * @return
     */
    @Delete("DELETE FROM paperwork WHERE userid=#{userId} AND isSuccess=-1")
    int deldeteFailure(@Param("userId") String userId);


    /**
     * 根据身份证号查询用户
     * @param AuthenNumber
     * @return
     */
    @Select("SELECT * FROM paperwork WHERE paperworkNumber=#{AuthenNumber}")
    PaperWork selectAuthen(@Param("AuthenNumber") String AuthenNumber);

    /**
     * 根据用户id 身份证号查询用户（注销使用）
     * @param AuthenNumber
     * @return
     */
    @Select("SELECT * FROM paperwork WHERE paperworkNumber=#{AuthenNumber} AND userid=#{userId}")
    PaperWork selectbyUserIdAuthen(@Param("userId")String userId,@Param("AuthenNumber") String AuthenNumber);

    /**
     * 根据用户id 身份证号删除用户认证信息（注销使用）
     * @param AuthenNumber
     * @return
     */
    @Select("DELETE FROM paperwork WHERE paperworkNumber=#{AuthenNumber} AND userid=#{userId}")
     int deleteUserIdAuthen(@Param("userId")String userId,@Param("AuthenNumber") String AuthenNumber);

    /**
     * 根据用户选择的证件类型 判断是否已经受理成功的
     * @param userId
     * @return
     */
    @Select("SELECT isSuccess FROM paperwork WHERE userid = #{userId}")
    PaperWork selectDocument(@Param("userId") String userId);




    /**
     * 添加用户身份认证
     * @param map
     * @return
     */
    @Insert("INSERT INTO paperwork(userid,TicketId,paperworktype,paperworkName,paperworkNumber,paperworkPhotoSelfie,paperworkPhotofacade,paperworkPhotoobverse,startdatetime)\n" +
            "VALUES(#{map.userid},#{map.TicketId},#{map.paperworktype},#{map.paperworkName},#{map.paperworkNumber},#{map.paperworkPhotoSelfie},#{map.paperworkPhotofacade},#{map.paperworkPhotoobverse},#{map.startdatetime})")
    Integer addUserProof(@Param("map") Map<String,Object> map);



}
