package com.yumiaobaobao.app.schoolscore.entity;

/**
 * @Title 评分表
 * 　* @author
 * 　* @date 2019.05.24 14:08
 *
 */
public class schoolscore {
    private Integer id;

    private Integer userId;
    //课程id
    private Integer courseId;

    private Double scoreQuality;

    private Double scoreSurroundings;

    private Double scorePopularity;

    private Integer schoolId;

    private Integer scoreAverage;
    //评论
    private String comment;

    private String commentimg;
    //课程名称
    private String schoolcourseName;

    private String username;

    private String avatarImg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public String getSchoolcourseName() {
        return schoolcourseName;
    }

    public void setSchoolcourseName(String schoolcourseName) {
        this.schoolcourseName = schoolcourseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getScoreQuality() {
        return scoreQuality;
    }

    public void setScoreQuality(Double scoreQuality) {
        this.scoreQuality = scoreQuality;
    }

    public Double getScoreSurroundings() {
        return scoreSurroundings;
    }

    public void setScoreSurroundings(Double scoreSurroundings) {
        this.scoreSurroundings = scoreSurroundings;
    }

    public Double getScorePopularity() {
        return scorePopularity;
    }

    public void setScorePopularity(Double scorePopularity) {
        this.scorePopularity = scorePopularity;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(Integer scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommentimg() {
        return commentimg;
    }

    public void setCommentimg(String commentimg) {
        this.commentimg = commentimg == null ? null : commentimg.trim();
    }
}