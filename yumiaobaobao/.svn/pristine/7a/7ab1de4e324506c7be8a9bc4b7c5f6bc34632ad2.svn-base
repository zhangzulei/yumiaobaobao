package com.yumiaobaobao.app.globaltype.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.globaltype.entity.SchoolType;
import com.yumiaobaobao.app.globaltype.service.SchoolTypeService;
import com.yumiaobaobao.app.school_subject.entity.schoolsubject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WH on 2019/04/17.
 */


@RestController
@Component
@Api(tags = "管理类别的接口 1.查询所有的一级类目 2.根据一级类目查询二级类目(课程用)")
public class SchoolTypeController {


    @Autowired
    private SchoolTypeService schoolTypeService;


    @ApiOperation(value = "行业类别展示) ",notes = "查询所有行业类别 Message:0=>没有数据")
    @RequestMapping(value = "/selectSchoolType",method = RequestMethod.GET)
    public String selectSchoolType(@ApiParam(value = "父级id") @RequestParam(value = "fatherid")String fatherid){
        List<SchoolType> list = schoolTypeService.faterfindAll(fatherid);
        if(list.size()>0){
            return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(list)+"}";
        }
        return "{\"Message\": \"0\"}";
    }


    @ApiOperation(value = "查询所有的一级类目 ",notes = "查询所有的一级类目 Message:0=>没有数据")
    @RequestMapping(value = "/selectSchoolAllType",method = RequestMethod.GET)
    public String selectSchoolAllType(){
        List<SchoolType> selectSchoolAllTypeList = schoolTypeService.selectSchoolAllType();
        if(selectSchoolAllTypeList==null|| selectSchoolAllTypeList.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(selectSchoolAllTypeList)+"}";
    }


    @ApiOperation(value = "根据一级类目查询二级类目",notes = "根据一级类目查询二级类目 Message:0=>没有数据")
    @RequestMapping(value = "/selectSubclassType",method = RequestMethod.GET)
    public String selectSubclassType(@ApiParam(value = "父级id") @RequestParam(value = "fatherid")String fatherid){
        List<schoolsubject> subclassTypeId = schoolTypeService.selectSubclassType(fatherid);
        if(subclassTypeId==null|| subclassTypeId.size()==0){
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(subclassTypeId)+"}";
    }
}
