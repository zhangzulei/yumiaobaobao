package com.yumiaobaobao.app.user.entity;

import java.util.Date;

/**
 * @author zzl
 * @date
 * @Description  草稿
 */
public class user_draft {
    private Integer Id;

    private Integer user_id;

    private String content;

    private Date createTime;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
