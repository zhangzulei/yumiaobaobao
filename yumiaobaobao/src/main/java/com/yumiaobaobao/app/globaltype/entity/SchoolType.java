package com.yumiaobaobao.app.globaltype.entity;

/**
 * Created by WH on 2019/04/17.
 */
public class SchoolType {

    private Integer id;

    private Integer fatherid;

    private String schooltypename;

    private Integer typeid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getSchooltypename() {
        return schooltypename;
    }

    public void setSchooltypename(String schooltypename) {
        this.schooltypename = schooltypename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}
