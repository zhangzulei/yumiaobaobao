package com.yumiaobaobao.app.schoolteacher.service;

import com.yumiaobaobao.app.schoolteacher.entity.school_teacher;

import java.util.List;

public interface schoolteacherService {
    /**
     * 根据商铺id查询教师信息
     * @param schoolShopid
     * @return
     */
    List<school_teacher> selectByShopid(Integer schoolShopid);
}
