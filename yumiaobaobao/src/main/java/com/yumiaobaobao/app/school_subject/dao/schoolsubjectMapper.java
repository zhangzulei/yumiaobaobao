package com.yumiaobaobao.app.school_subject.dao;

import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface schoolsubjectMapper {

    /**
     * 根据id查询信息
     * */
    @Select("select * from school_subject where id = #{id}")
    List<schoolsubject> findSchoolSubject(Integer id);

    /**
     * 查询所有一级类目跟二级类目
     * @return
     */
    @Select("SELECT a.schooltypename,b.* FROM school_type a,school_subject b WHERE a.fatherid = b.fatherid")
    List<schoolsubject> selectAlltape();

}
