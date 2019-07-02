package com.yumiaobaobao.app.schoolcourse.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.schoolcourse.entity.SchoolCoures;
import com.yumiaobaobao.app.schoolcourse.service.schoolcourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title 课程
 * 　* @author
 * 　* @date 2019.05.28 9:36
 *
 */
@RestController
@Api(tags = "微课程:1.根据id查询课程  2.该商户其他课程推荐  3.相关课程推荐 4:查询课程评论 ")
public class schoolcourseControllor {
    @Autowired
    private schoolcourseService schoolcourse;


    @RequestMapping(value = "allSchoolCourse", method = RequestMethod.GET)
    @ApiOperation(value = "查询课程信息", notes = "查询课程信息 Message 0 没有数据")
    public String allSchoolCourse(Integer id) {
        List<SchoolCoures> schoolcourseList = schoolcourse.allSchoolCourse(id);
        if (schoolcourseList == null || schoolcourseList.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(schoolcourseList) + "}";
    }

    @RequestMapping(value = "commendCourse", method = RequestMethod.GET)
    @ApiOperation(value = "根据店铺id查询所有课程信息", notes = "根据店铺id查询所有课程信息 Message 0 没有数据")
    public String commendCourse(@ApiParam("店铺id") @RequestParam("belongShopid") Integer belongShopid) {
        List<SchoolCoures> schoolcourseList = schoolcourse.commendCourse(belongShopid);
        if (schoolcourseList == null || schoolcourseList.size() == 0) {
            return "{\"Message\": \"0\"}";
        }
        return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(schoolcourseList) + "}";
    }




    @RequestMapping(value = "recommendCourse", method = RequestMethod.GET)
    @ApiOperation(value = "根据课程类型推荐相关课程", notes = "根据课程类型推荐相关课程 Message 0 没有数据")
    public String recommendCourse(Integer id) {
        List<SchoolCoures> schoolcoursesLists = new ArrayList<SchoolCoures>();
        //id查询课程
        List<SchoolCoures> schoolcourseList = schoolcourse.allSchoolCourse(id);
        for (SchoolCoures course : schoolcourseList) {
            Integer classType = course.getClassType();;
            schoolcoursesLists = schoolcourse.recommendCourse(classType,id);
            if (schoolcoursesLists != null && schoolcoursesLists.size() > 0) {
                return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(schoolcoursesLists) + "}";
            }
        }
        return "{\"Message\": \"0\"}";
    }


    @RequestMapping(value = "randomSchoolCourse", method = RequestMethod.GET)
    @ApiOperation(value = "随机课程推荐(10个)", notes = "随机课程推荐 Message 0 没有数据")
    public String randomSchoolCourse() {
        List<SchoolCoures> schoolCoursesList = schoolcourse.randomSchoolCourse();
        if (schoolCoursesList != null && schoolCoursesList.size() > 0) {
            return "{\"Message\": \"1\", \"Data\":" + JSON.toJSONString(schoolCoursesList) + "}";
        }
        return "{\"Message\": \"0\"}";
    }






}
