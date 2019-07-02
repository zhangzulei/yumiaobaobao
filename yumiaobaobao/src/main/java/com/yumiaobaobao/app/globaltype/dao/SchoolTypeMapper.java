package com.yumiaobaobao.app.globaltype.dao;

import com.yumiaobaobao.app.globaltype.entity.SchoolType;
import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WH on 2019/04/17.
 */

@Repository
public interface SchoolTypeMapper {


    /**
     * 行业类别展示主类
     *
     * @param fatherid
     * @return
     */
    List<SchoolType> faterfindAll(@Param("fatherid") String fatherid);

    /**
     * 查询所有的一级类目
     */
    @Select("select * from school_type")
    List<SchoolType> selectSchoolAllType();

    /**
     * 根据一级类目查询二级类目
     *
     * @return
     */
    @Select("SELECT a.*, b.* FROM school_subject a,school_type b WHERE a.fatherid = b.id AND a.fatherid = #{fatherid}")
    List<schoolsubject> selectSubclassType(@Param("fatherid") String fatherid);

    List<SchoolType> allTypeName();

    /**
     * 展示类别中详细分类
     */
    @Select("select * from school_subject where fatherid = #{fatherid}")
    List<schoolsubject> findByFatherId(Integer fatherid);
}
