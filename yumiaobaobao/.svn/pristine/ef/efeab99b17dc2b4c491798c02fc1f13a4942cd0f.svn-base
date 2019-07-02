package com.yumiaobaobao.app.user.like.service;

import com.yumiaobaobao.app.user.entity.nice_detail;
import com.yumiaobaobao.app.user.entity.v_nice_detail;

import java.util.List;
import java.util.Map;

public interface Nice_DetailService {
    //查找点赞信息
    List<nice_detail> findNiceDetail(Map<String,Object> map);
    //查找被点赞人的点赞信息列表
    List<v_nice_detail> selectNiceDetailCount(String userinfoId);
    //删除点赞信息
    Integer deleteNiceDetail(Integer id);
    //增加点赞信息
    Integer addNiceDetail(Map<String,Object> map);

    List<nice_detail> noticeCollect();

    Map<String,Object> countFavoAtMonth( String userinfoId,String year);

    Map<String,Object> countFavoAtYear( String userinfoId);

    List<nice_detail> getTextByUserid(String userId);
}
