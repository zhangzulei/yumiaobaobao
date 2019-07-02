package com.yumiaobaobao.app.schoolcourse.service.impl;

import com.yumiaobaobao.app.schoolcourse.dao.SchoolCouresMapper;
import com.yumiaobaobao.app.schoolcourse.entity.SchoolCoures;
import com.yumiaobaobao.app.schoolcourse.service.schoolcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

;

/**
  * @Title 课程
　* @author
　* @date 2019.05.28 9:59
　*/
@Service
public class schoolcourseServiceImpl implements schoolcourseService {
    @Autowired
    private SchoolCouresMapper schoolcourse;

    /**
     * 根据id查课程详情
     *
     * @param id
     * @return
     */
    @Override
    public List<SchoolCoures> allSchoolCourse(Integer id) {
        return schoolcourse.allSchoolCourse(id);
    }


    /**
     * 根据课程类型推荐相关课程
     * @param classType
     * @return
     */
    @Override
    public List<SchoolCoures> recommendCourse(Integer classType,Integer id) {
        return schoolcourse.recommendCourse(classType,id);
    }

    /**
     * 随机获取10条课程
     *
     * @return
     */
    @Override
    public List<SchoolCoures> randomSchoolCourse() {
        return schoolcourse.randomSchoolCourse();
    }

    /**
     * 根据店铺id查询所有课程信息
     *
     * @param belongShopid
     * @return
     */
    @Override
    public List<SchoolCoures> commendCourse(Integer belongShopid) {
        return schoolcourse.commendCourse(belongShopid);
    }




}
