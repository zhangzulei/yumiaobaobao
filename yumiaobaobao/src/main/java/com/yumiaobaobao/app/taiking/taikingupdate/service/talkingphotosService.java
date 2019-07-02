package com.yumiaobaobao.app.taiking.taikingupdate.service;

import com.yumiaobaobao.app.taiking.entity.talkingphotos;

import java.util.List;

public interface talkingphotosService {

    List<talkingphotos> selectByTalkingid(String talkingid);
}
