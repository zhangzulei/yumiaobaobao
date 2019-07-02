package com.yumiaobaobao.app.schoolteacher.service.impl;

import com.yumiaobaobao.app.schoolteacher.dao.schoolteacherMapper;
import com.yumiaobaobao.app.schoolteacher.entity.school_teacher;
import com.yumiaobaobao.app.schoolteacher.service.schoolteacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Service
public class schoolteacherServiceImpl implements schoolteacherService {

    @Autowired
    private schoolteacherMapper schoolteacherMapper;

    /**
     * 根据商铺id查询教师信息
     * @param schoolShopid
     * @return
     */
    @Override
    public List<school_teacher> selectByShopid(Integer schoolShopid) {
        return schoolteacherMapper.selectByShopid(schoolShopid);
    }
}
