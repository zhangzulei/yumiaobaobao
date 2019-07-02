package com.yumiaobaobao.app.user.like.service.impl;


import com.yumiaobaobao.app.user.dao.nice_detailMapper;
import com.yumiaobaobao.app.user.entity.v_nice_detail;
import com.yumiaobaobao.app.user.like.service.Nice_DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.yumiaobaobao.app.user.entity.nice_detail;
import java.util.List;
import java.util.Map;

@Service
public class Nice_DetailServiceImpl implements Nice_DetailService {
    @Autowired
    private nice_detailMapper detailMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<nice_detail> findNiceDetail(Map<String,Object> map) {
        return detailMapper.findNiceDetail(map);
    }

    @Override
    public List<v_nice_detail> selectNiceDetailCount(String userinfoId) {
        return detailMapper.selectNiceDetailCount(userinfoId);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Integer deleteNiceDetail(Integer id) {
        return detailMapper.deleteNiceDetail(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Integer addNiceDetail(Map<String,Object> map) {
        return detailMapper.addNiceDetail(map);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<nice_detail> noticeCollect() {
        return detailMapper.noticeCollect();
    }

    @Override
    public Map<String, Object> countFavoAtMonth(String userinfoId, String year) {
        return detailMapper.countFavoAtMonth(userinfoId,year);
    }

    @Override
    public Map<String, Object> countFavoAtYear(String userinfoId) {
        return detailMapper.countFavoAtYear(userinfoId);
    }

    @Override
    public List<nice_detail> getTextByUserid(String userId) {
        return detailMapper.getTextByUserid(userId);
    }
}
