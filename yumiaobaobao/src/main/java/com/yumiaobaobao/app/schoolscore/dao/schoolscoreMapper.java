package com.yumiaobaobao.app.schoolscore.dao;

import com.yumiaobaobao.app.schoolscore.entity.schoolscore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface schoolscoreMapper {
    /**
     * 新增评分
     *
     * @return
     */
    @Insert("INSERT INTO\n" +
            "     school_score(user_id,course_id,score_quality,score_surroundings,score_Popularity,school_id,comment,commentimg)\n" +
            "     VALUES(#{map.userid},#{map.courseid},#{map.scorequality},\n" +
            "     #{map.scoresurroundings},#{map.scorePopularity},#{map.school_id},#{map.comment},#{map.commentimg})")
    int addScore(
            @Param("map") Map<String, Object> map
    );

    //查询综合评分进行排序
    @Select("SELECT b.schoolcourseName FROM school_score a,school_coures b WHERE a.course_id = b.schoolcourseId ORDER BY a.score_average DESC")
    List<schoolscore> queryOrder();

    /*查询质量评分进行排序*/
    @Select("select s2.schoolcourseName from school_score s1,school_coures s2 where s1.course_id=s2.schoolcourseId ORDER BY score_quality DESC")
    List<schoolscore> queryScoreQualityOrder();

    /*查询人气评分进行排序*/
    @Select("select s2.schoolcourseName from school_score s1,school_coures s2 where s1.course_id=s2.schoolcourseId ORDER BY score_Popularity DESC")
    List<schoolscore> queryPopularity();

    /*查询距离排序进行排序*/
    @Select("select s2.schoolcourseName from school_score s1,school_coures s2 where s1.course_id=s2.schoolcourseId ORDER BY score_distance DESC")
    List<schoolscore> queryDistance();

    /*查询价格排序进行排序*/
    @Select("select s2.schoolcourseName from school_score s1,school_coures s2 where s1.course_id=s2.schoolcourseId ORDER BY score_price DESC")
    List<schoolscore> queryPrice();


    //根据课程id查询评分以及评论
    @Select("SELECT * FROM school_score WHERE course_id =#{courseId}")
    List<schoolscore> selectByCourseId(@Param("courseId") Integer courseId);

    //查询店铺的平均评分
    @Select("select avg(sumScore) from(select sum(score_quality + score_surroundings + score_Popularity) as sumScore from school_score " +
            "where school_id = #{shopId} ) a ")
    String getAvgScore(@Param("shopId") String shopId);


    /**
     * 根据店铺id查询所有课程信息
     */
    List<schoolscore> courseComment(Integer courseId);
}