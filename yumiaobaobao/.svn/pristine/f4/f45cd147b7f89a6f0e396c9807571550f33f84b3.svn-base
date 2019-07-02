package com.yumiaobaobao.app.shop.shophone.controller;

import com.alibaba.fastjson.JSON;
import com.yumiaobaobao.app.common.dto.AliyunOssParameter;
import com.yumiaobaobao.app.common.utils.aliyunossutil.AliyunOSSUpLoadUtil;
import com.yumiaobaobao.app.common.utils.aliyunossutil.LocalDelete;
import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.common.utils.util.RandomNumberUtil;
import com.yumiaobaobao.app.shop.entity.Schoolshop;
import com.yumiaobaobao.app.shop.entity.school_shop_score;
import com.yumiaobaobao.app.user.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */
@RestController
@Component
@Api(tags = "店铺评论：1.增加评论  2.根据店铺id查询店铺评论")
public class school_shop_scoreControllor {
    @Autowired
    private com.yumiaobaobao.app.user.userupdate.service.UserUpdateService userUpdateService;
    @Autowired
    private com.yumiaobaobao.app.shop.shophone.service.school_shop_scoreService school_shop_scoreService;
    @Autowired
    private com.yumiaobaobao.app.shop.shophone.service.ShopHomeService shopHomeService;
    @Autowired
    private com.yumiaobaobao.app.shop.shophone.service.SchoolshopService schoolshopService;

    @Transactional
    @RequestMapping(value = "/addShopScore", method = RequestMethod.POST)
    @ApiOperation(value = "提交店铺评分", notes = "提交店铺评分 Message 0 新增失败 -1更新店铺平均分失败")
    public String addShopScore(
            @ApiParam("评价该商铺的用户id") @RequestParam("userid") String userid,
            @ApiParam("商铺id") @RequestParam("shopid") String shopid,
            @ApiParam("质量评分") @RequestParam("scorequality") String scorequality,
            @ApiParam("环境评分") @RequestParam("scoresurroundings") String scoresurroundings,
            @ApiParam("人气评分") @RequestParam("scorePopularity") String scorePopularity,
            @ApiParam("评论") @RequestParam(value = "comment", defaultValue = "null") String comment,
            @ApiParam("评论图片") @RequestParam(value = "commentimg", required = false) MultipartFile commentimg
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("scorequality", scorequality);
        map.put("scoresurroundings", scoresurroundings);
        map.put("scorePopularity", scorePopularity);
        map.put("shopid", shopid);
        map.put("comment", comment);
        map.put("createtime", DateUtils.newDateTime());
        if (comment != null) {
            try {
                if (commentimg != null) {
                    String filename = commentimg.getOriginalFilename();
                    if (!"".equals(filename.trim())) {
                        String substr = filename.substring(filename.lastIndexOf(".") + 1);
                        String newName = RandomNumberUtil.randomnumberEnglish(8);
                        File newFile = new File(newName);
                        FileOutputStream os = new FileOutputStream(newFile);
                        os.write(commentimg.getBytes());
                        os.close();
                        commentimg.transferTo(newFile);
                        //上传到OSS  //uploadUrl文件全路径存放到对应的数据库表中
                        String uploadUrl = AliyunOSSUpLoadUtil.upLoad(newFile, AliyunOssParameter.FILE_HOST_SHOPCOMMENT, userid);
                        if (uploadUrl == null || uploadUrl == "") {
                            return "{\"Message\":\"0\"}";
                        }
                        map.put("commentimg", uploadUrl);//存入对应数据库的map
                        File file1 = new File("");
                        String s = file1.getAbsolutePath();
                        LocalDelete.delete(s + "\\" + newName);// 删除上传的文件  上传成功后会在项目根目录存在一张图片
                    }
                } else {
                    map.put("commentimg", null);
                }
                //   map.put("commentimg", commentimg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int result = school_shop_scoreService.addShopScore(map);
        if (result <= 0) {
            return "{\"Message\": \"0\"}";
        }
        //评论成功之后改变店铺的平均分 以及环境 人气 质量
        List<Schoolshop> schoolshops = shopHomeService.selectAllShopbyId(shopid);
        for (Schoolshop schoolshop : schoolshops) {
            Map<String, Object> param = new HashMap<String, Object>();
            Double du = (schoolshop.getAvgscore() + (Double.parseDouble(scorequality) + Double.parseDouble(scoresurroundings) +
                    Double.parseDouble(scorePopularity)) / 3) / 2;   //店铺平均分
            Double ps = (schoolshop.getPopularityscore() + Double.parseDouble(scorePopularity)) / 2;
            Double ss = (schoolshop.getSurroundingsscore() + Double.parseDouble(scoresurroundings)) / 2;
            Double sq = (schoolshop.getQualityscore() + Double.parseDouble(scorequality)) / 2;
            //更新商铺信息
            param.put("du", du);
            param.put("ps", ps);
            param.put("ss", ss);
            param.put("sq", sq);
            int i1 = schoolshopService.updateAvgScoreByShopid(String.valueOf(schoolshop.getId()), param);
            if (i1 <= 0) {
                return "{\"Message\": \"1\",\"Message\":" + "更新店铺评分失败" + "}";
            }
        }
        return "{\"Message\": \"1\"}";
    }

    @RequestMapping(value = "/selectCommentByShopId", method = RequestMethod.GET)
    @ApiOperation(value = "根据商铺id查询评论", notes = "根据商铺id查询评论 Message =>0 失败 =>1成功")
    public String selectByShopId(@ApiParam("商铺id") @RequestParam("shopid") String shopid) {
        List<school_shop_score> school_shop_scores = school_shop_scoreService.selectByShopid(shopid);
        if (school_shop_scores == null || school_shop_scores.size() <= 0) {
            return "{\"Message\":\"0\"}";
        }
        for (school_shop_score schoolscore : school_shop_scores) {
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(String.valueOf(schoolscore.getUserid()));
            schoolscore.setUsername(userInfo.getUsername());
            schoolscore.setAvatarImg(userInfo.getAvatarimg());
        }
        return "{\"Message\":\"1\",\"Data\":" + JSON.toJSONString(school_shop_scores) + "}";
    }

}
