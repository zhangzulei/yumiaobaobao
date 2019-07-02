package com.yumiaobaobao.app.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class v_nice_detail {
    private Integer userid;
    private String avatarimg;
    private String userinfoId;
    private String news;
    private String templateid;
    private String Image;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")  //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    private Date createtime;
    private Integer id;
    private String content;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAvatarimg() {
        return avatarimg;
    }

    public void setAvatarimg(String avatarimg) {
        this.avatarimg = avatarimg;
    }

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
