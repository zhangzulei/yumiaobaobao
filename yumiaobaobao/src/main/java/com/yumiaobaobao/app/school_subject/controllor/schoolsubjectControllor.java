package com.yumiaobaobao.app.school_subject.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import com.yumiaobaobao.app.school_subject.service.schoolsubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@RestController
@Api(tags = "课程类别分类")
public class schoolsubjectControllor {
    @Autowired
    private schoolsubjectService schoolsubject;

    @RequestMapping(value = "findSchoolSubject",method = RequestMethod.GET)
    @ApiOperation(value = "查询课程所属类别",notes = "查询课程所属类别  Message = 0 查询失败")
    public String findSchoolSubject(Integer id){
        List<schoolsubject> schoolSubjectList = schoolsubject.findSchoolSubject(id);
        if(schoolSubjectList==null||schoolSubjectList.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+ JSON.toJSONString(schoolSubjectList)+"}";
    }



    @RequestMapping(value = "selectAlltape",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有一级类目跟二级类目",notes = "查询所有一级类目跟二级类目  Message = 0 查询失败")
    public String selectAlltape(){
        List<schoolsubject> selectAlltapeList = schoolsubject.selectAlltape();
        if(selectAlltapeList==null||selectAlltapeList.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+ JSON.toJSONString(selectAlltapeList)+"}";
    }




}
