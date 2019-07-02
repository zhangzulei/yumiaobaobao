package com.yumiaobaobao.app.proof.userproof.service;

import com.yumiaobaobao.app.proof.userproof.entity.PaperWork;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by WH on 2019/04/11.
 */
public interface UserProofService {




    /**
     * 根据用户id 身份证号删除用户认证信息（注销使用）
     * @param AuthenNumber
     * @return
     */
    int deleteUserIdAuthen(String userId, String AuthenNumber);
    /**
     * 根据用户id 身份证号查询用户（注销使用）
     * @param AuthenNumber
     * @return
     */
    PaperWork selectbyUserIdAuthen(String userId, String AuthenNumber);

    /**
     * 根据id 删除审核失败的记录
     * @param userId
     * @return
     */
    int deldeteFailure(String userId);

    /**
     * 根据用户选择的证件类型 判断是否已经具有受理成功的
     * @param userId
     * @return
     */
    PaperWork selectDocument(String userId);

    /**
     * 根据用户id查询用户认证状态
     * @param userId
     * @return
     */
    PaperWork selectPaperWork(String userId);
    /**
     * 根据身份证号查询用户
     * @param AuthenNumber
     * @return
     */
    PaperWork selectAuthen(String AuthenNumber);
    /**
     * 用户身份认证
     * @param map
     * @return
     */
    Integer addUserProof(Map<String,Object> map);
}
