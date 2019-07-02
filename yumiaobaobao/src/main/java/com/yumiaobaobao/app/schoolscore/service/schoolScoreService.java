package com.yumiaobaobao.app.schoolscore.service;

import com.yumiaobaobao.app.schoolscore.entity.schoolscore;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/03/27.
 */
public interface schoolScoreService {
    /**
     * 新增评分
     *
     * @return
     */
    int addScore(Map<String, Object> map);

    /**
     * 综合排序
     *
     * @return
     */
    List<schoolscore> queryOrder();

    /**
     * 课堂质量
     *
     * @return
     */
    List<schoolscore> queryScoreQualityOrder();

    /**
     * 人气排序
     *
     * @return
     */
    List<schoolscore> queryPopularity();


    /**
     * 距离排序
     *
     * @return
     */
    List<schoolscore> queryDistance();


    /**
     * 价格排序
     *
     * @return
     */
    List<schoolscore> queryPrice();


    /**
     * 根据课程id查询评论
     *
     * @param courseId
     * @return
     */
    List<schoolscore> selectByCourseId(Integer courseId);


    /**
     * 根据课程id查询课程评论
     * */
    List<schoolscore> courseComment(Integer courseId);

}
