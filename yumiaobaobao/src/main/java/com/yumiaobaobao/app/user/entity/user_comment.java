package com.yumiaobaobao.app.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class user_comment implements Serializable {
    private Integer id;

    private String commentid;

    private String commentcontent;

    private String userid;

    private Long favocount;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss") //FastJson包使用注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //Jackson包使用注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")   //格式化前台日期参数注解
    private Date createtime;
    private UserInfo userinfo;
    private index_discover index_discover;
    private Integer favostatus;


}