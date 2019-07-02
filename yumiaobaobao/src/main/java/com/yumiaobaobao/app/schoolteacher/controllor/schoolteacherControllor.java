package com.yumiaobaobao.app.schoolteacher.controllor;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.schoolteacher.entity.school_teacher;
import com.yumiaobaobao.app.schoolteacher.service.schoolteacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 教师信息操作
 * @date
 * @Description
 */
@RestController
@Api(tags = "教师信息操作：1.根据商铺id查询教师信息")
public class schoolteacherControllor {
    @Autowired
    private schoolteacherService schoolteacherService;

    @RequestMapping(value = "selectByShopId",method = RequestMethod.GET)
    @ApiOperation(value = "根据商铺id查询教师信息",notes = "根据商铺id查询教师信息 Message =>0没有数据  =>1查询成功")
    public String selectByShopId(@ApiParam("商铺id") @RequestParam("schoolShopid") String schoolShopid){
        List<school_teacher> teacherList = schoolteacherService.selectByShopid(Integer.valueOf(schoolShopid));
        if(teacherList!=null && teacherList.size()>0){
            return "{\"Message\":\"1\",\"Date\":"+JSON.toJSONString(teacherList)+"}";
        }
        return "{\"Message\":\"0\"}";
    }

}
