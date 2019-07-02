package com.yumiaobaobao.app.taiking.taikingupdate.service.impl;

import com.yumiaobaobao.app.taiking.dao.talkingphotosMapper;
import com.yumiaobaobao.app.taiking.entity.talkingphotos;
import com.yumiaobaobao.app.taiking.taikingupdate.service.talkingphotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Service
public class talkingphotosServiceImpl implements talkingphotosService {

    @Autowired
    private talkingphotosMapper talkingphotosMapper;


    @Override
    public List<talkingphotos> selectByTalkingid(String talkingid) {
        return talkingphotosMapper.selectByTalkingid(talkingid);
    }
}
