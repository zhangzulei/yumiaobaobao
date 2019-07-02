package com.yumiaobaobao.app.proof.userproof.service.impl;

import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.proof.userproof.dao.UserProofMapper;
import com.yumiaobaobao.app.proof.userproof.entity.PaperWork;
import com.yumiaobaobao.app.proof.userproof.service.UserProofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by WH on 2019/04/11.
 */
@Service
public class UserProofServiceImpl implements UserProofService {
    @Autowired
    private UserProofMapper userProofMapper;


    @Override
    public int deleteUserIdAuthen(String userId, String AuthenNumber) {
        return userProofMapper.deleteUserIdAuthen(userId,AuthenNumber);
    }

    @Override
    public PaperWork selectbyUserIdAuthen(String userId, String AuthenNumber) {
        return userProofMapper.selectbyUserIdAuthen(userId,AuthenNumber);
    }

    @Override
    public int deldeteFailure(String userId ) {
        return userProofMapper.deldeteFailure(userId);
    }

    @Override
    public PaperWork selectDocument(String userId) {
        return userProofMapper.selectDocument(userId);
    }

    @Override
    public PaperWork selectPaperWork(String userId) {
        return userProofMapper.selectPaperWork(userId);
    }

    @Override
    public PaperWork selectAuthen(String AuthenNumber) {
        return userProofMapper.selectAuthen(AuthenNumber);
    }

    @Override
    public Integer addUserProof(Map<String, Object> map) {
        map.put("startdatetime", DateUtils.newDateTime());
        return userProofMapper.addUserProof(map);
    }
}
