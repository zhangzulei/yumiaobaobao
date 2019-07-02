package com.yumiaobaobao.app.moremenu.myattention.taiking.entity;

import java.time.LocalDateTime;

/**
 * Created by WH on 2019/04/10.
 */
public class TaiKingFollow {

    private int id;

    private int talkingid;

    private int userid;

    private int status;

    private LocalDateTime   createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTalkingid() {
        return talkingid;
    }

    public void setTalkingid(int talkingid) {
        this.talkingid = talkingid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }
}
