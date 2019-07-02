package com.yumiaobaobao.app.school_subject.service.impl;

import com.yumiaobaobao.app.school_subject.dao.schoolsubjectMapper;
import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import com.yumiaobaobao.app.school_subject.service.schoolsubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */

@Service
public class schoolsubjectServiceImpl implements schoolsubjectService {

    @Autowired
    private schoolsubjectMapper schoolsubject;

    /**
     *查询课程所属类别
     * @param id
     * @return
     */
    @Override
    public List<schoolsubject> findSchoolSubject(Integer id) {
        return schoolsubject.findSchoolSubject(id);
    }
    /**
     * 查询所有一级类目跟二级类目
     * @return
     */
    @Override
    public List<schoolsubject> selectAlltape() {
        return schoolsubject.selectAlltape();
    }
}
