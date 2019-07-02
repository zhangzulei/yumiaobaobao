package com.yumiaobaobao.app.user.entity;

import com.yumiaobaobao.app.globaltype.entity.SchoolType;

import java.io.Serializable;


public class user_distance implements Serializable {
    private Integer id;

    private Double distance;

    private index_discover index_discover;

    private UserInfo userinfo;

    private SchoolType school_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public index_discover getIndex_discover() {
        return index_discover;
    }

    public void setIndex_discover(index_discover index_discover) {
        this.index_discover = index_discover;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public SchoolType getSchool_type() {
        return school_type;
    }

    public void setSchool_type(SchoolType school_type) {
        this.school_type = school_type;
    }
}