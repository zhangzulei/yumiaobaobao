package com.yumiaobaobao.app.schoolscore.service.impl;

import com.yumiaobaobao.app.schoolscore.dao.schoolscoreMapper;
import com.yumiaobaobao.app.schoolscore.entity.schoolscore;
import com.yumiaobaobao.app.schoolscore.service.schoolScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2019/03/27.
 */
@Service
public class schoolScoreServiceImpl implements schoolScoreService {

    @Autowired
    private schoolscoreMapper schoolscore1;

    @Override
    public int addScore(Map<String, Object> map) {

        return schoolscore1.addScore(map);
    }

    /**
     * 综合排序
     *
     * @return
     */
    @Override
    public List<schoolscore> queryOrder() {
        return schoolscore1.queryOrder();
    }

    /**
     * 课堂质量排序
     *
     * @return
     */
    @Override
    public List<schoolscore> queryScoreQualityOrder() {
        return schoolscore1.queryScoreQualityOrder();
    }

    /**
     * 人气排序
     *
     * @return
     */
    @Override
    public List<schoolscore> queryPopularity() {
        return schoolscore1.queryPopularity();
    }

    /**
     * 距离排序
     *
     * @return
     */
    @Override
    public List<schoolscore> queryDistance() {
        return schoolscore1.queryDistance();
    }

    /**
     * 价格排序
     *
     * @return
     */
    @Override
    public List<schoolscore> queryPrice() {
        return schoolscore1.queryPrice();
    }

    /**
     * 根据课程id查询评论
     * @param courseId
     * @return
     */
    @Override
    public List<schoolscore> selectByCourseId(Integer courseId) {
        return schoolscore1.selectByCourseId(courseId);
    }

    /**
     * 根据课程id查询课程评论
     * @param courseId
     * @return
     */
    @Override
    public List<schoolscore> courseComment(Integer courseId) {
        return schoolscore1.courseComment(courseId);
    }

}
