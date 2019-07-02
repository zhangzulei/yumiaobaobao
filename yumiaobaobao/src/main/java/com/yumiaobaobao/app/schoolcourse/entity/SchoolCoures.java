package com.yumiaobaobao.app.schoolcourse.entity;

import java.io.Serializable;

/**
 * 课程表
 */
public class SchoolCoures implements Serializable {

    /**
     * 课程ID
     */
    private Integer id;

    /**
     * 学校课程id
     */
    private Integer schoolcourseid;

    /**
     * 课程名称
     */
    private String schoolcoursename;

    /**
     * 学校课程介绍
     */
    private String schoolcourseintroduction;

    /**
     * 原价
     */
    private String originalprice;

    /**
     * 现价
     */
    private String currentprice;

    /**
     * 上课日期
     */
    private String classdate;

    /**
     * 上课时间
     */
    private String casstime;

    /**
     * 下课日期
     */
    private String afterclassdate;

    /**
     * 下课时间
     */
    private String afterclasstime;

    /**
     * 学习目标
     */
    private String learningtarget;

    /**
     * 被收藏数量
     */
    private Integer bycollection;

    /**
     * 是否是热门  0不是  1是
     */
    private Integer ispopular;

    /**
     * 是否推荐 0不是 1是
     */
    private Integer isrecommend;

    /**
     * 图文详情
     */
    private String imgtextinfo;
    /**
     * 图片地址（图片详情）
     */
    private String picurl;

    /**
     * 套餐详情
     */
    private String packagedetails;

    /**
     * 课程类型
     */
    private Integer classType;

    /**
     *
     */
    private Integer belongshopid;

    private Integer lft;

    private Integer rgt;

    private Integer level;

    private String avgprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolcourseid() {
        return schoolcourseid;
    }

    public void setSchoolcourseid(Integer schoolcourseid) {
        this.schoolcourseid = schoolcourseid;
    }

    public String getSchoolcoursename() {
        return schoolcoursename;
    }

    public void setSchoolcoursename(String schoolcoursename) {
        this.schoolcoursename = schoolcoursename;
    }

    public String getSchoolcourseintroduction() {
        return schoolcourseintroduction;
    }

    public void setSchoolcourseintroduction(String schoolcourseintroduction) {
        this.schoolcourseintroduction = schoolcourseintroduction;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }

    public String getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(String currentprice) {
        this.currentprice = currentprice;
    }

    public String getClassdate() {
        return classdate;
    }

    public void setClassdate(String classdate) {
        this.classdate = classdate;
    }

    public String getCasstime() {
        return casstime;
    }

    public void setCasstime(String casstime) {
        this.casstime = casstime;
    }

    public String getAfterclassdate() {
        return afterclassdate;
    }

    public void setAfterclassdate(String afterclassdate) {
        this.afterclassdate = afterclassdate;
    }

    public String getAfterclasstime() {
        return afterclasstime;
    }

    public void setAfterclasstime(String afterclasstime) {
        this.afterclasstime = afterclasstime;
    }

    public String getLearningtarget() {
        return learningtarget;
    }

    public void setLearningtarget(String learningtarget) {
        this.learningtarget = learningtarget;
    }

    public Integer getBycollection() {
        return bycollection;
    }

    public void setBycollection(Integer bycollection) {
        this.bycollection = bycollection;
    }

    public Integer getIspopular() {
        return ispopular;
    }

    public void setIspopular(Integer ispopular) {
        this.ispopular = ispopular;
    }

    public Integer getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Integer isrecommend) {
        this.isrecommend = isrecommend;
    }

    public String getImgtextinfo() {
        return imgtextinfo;
    }

    public void setImgtextinfo(String imgtextinfo) {
        this.imgtextinfo = imgtextinfo;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPackagedetails() {
        return packagedetails;
    }

    public void setPackagedetails(String packagedetails) {
        this.packagedetails = packagedetails;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public Integer getBelongshopid() {
        return belongshopid;
    }

    public void setBelongshopid(Integer belongshopid) {
        this.belongshopid = belongshopid;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(String avgprice) {
        this.avgprice = avgprice;
    }
}