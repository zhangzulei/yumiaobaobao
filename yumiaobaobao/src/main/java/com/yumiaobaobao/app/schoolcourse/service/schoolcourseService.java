package com.yumiaobaobao.app.schoolcourse.service;

import com.yumiaobaobao.app.schoolcourse.entity.SchoolCoures;

import java.util.List;


public interface schoolcourseService {

    /**
     *  查询课程
     * */
    List<SchoolCoures> allSchoolCourse(Integer id);





    /**
     * 根据课程类型推荐相关课程
     *
     */
    List<SchoolCoures> recommendCourse(Integer classType,Integer id);

    /**
     * 随机获取10条课程
     * @return
     */
    List<SchoolCoures> randomSchoolCourse();

    /**
     * 根据店铺id查询所有课程信息
     * */
    List<SchoolCoures> commendCourse(Integer belongShopid);
}
