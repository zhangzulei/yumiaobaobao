package com.yumiaobaobao.app.moremenu.myattention.taiking.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.index_discover;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class nice_detail implements Serializable {
    private Integer id;

    private String userid;

    private String templateid;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    private Date createtime;

    private UserInfo userinfo;
    private com.yumiaobaobao.app.user.entity.index_discover index_discover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public com.yumiaobaobao.app.user.entity.index_discover getIndex_discover() {
        return index_discover;
    }

    public void setIndex_discover(com.yumiaobaobao.app.user.entity.index_discover index_discover) {
        this.index_discover = index_discover;
    }
}