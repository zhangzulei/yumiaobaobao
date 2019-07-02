package com.yumiaobaobao.app.moremenu.myattention.Shop.entity;

import java.time.LocalDateTime;

/**
 * Created by WH on 2019/03/27.
 */
public class shopFollow {


    private int id;

    private int userid;

    private int shopid;

    private LocalDateTime createtime;
    private int stutas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public int getStutas() {
        return stutas;
    }

    public void setStutas(int stutas) {
        this.stutas = stutas;
    }
}
