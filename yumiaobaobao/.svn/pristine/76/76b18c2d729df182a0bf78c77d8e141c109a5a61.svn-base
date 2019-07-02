package com.yumiaobaobao.app.globaltype.service.impl;

import com.yumiaobaobao.app.globaltype.dao.SchoolTypeMapper;
import com.yumiaobaobao.app.globaltype.entity.SchoolType;
import com.yumiaobaobao.app.globaltype.service.SchoolTypeService;
import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WH on 2019/04/17.
 */
@Service
public class SchoolTypeServiceImpl implements SchoolTypeService {

    @Autowired
    private SchoolTypeMapper schoolTypeMapper;


    /**
     * 行业类别展示主类
     * @param fatherid
     * @return
     */
    @Override
    public List<SchoolType> faterfindAll(String fatherid) {
        return schoolTypeMapper.faterfindAll(fatherid);
    }


    /**
     * 查询所有的一级类目
     * @return
     */
    @Override
    public List<SchoolType> selectSchoolAllType() {
        return schoolTypeMapper.selectSchoolAllType();
    }
    /**
     * 根据一级类目查询二级类目
     * @param fatherid
     * @return
     */
    @Override
    public List<schoolsubject> selectSubclassType(String fatherid) {
        return schoolTypeMapper.selectSubclassType(fatherid);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<SchoolType> allTypeName() {
        return schoolTypeMapper.allTypeName();
    }

    @Override
    public List<schoolsubject> findByFatherId(Integer fatherid){
        return schoolTypeMapper.findByFatherId(fatherid);
    }
}
