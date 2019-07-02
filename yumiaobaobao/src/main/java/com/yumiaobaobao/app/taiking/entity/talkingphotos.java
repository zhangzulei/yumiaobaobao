package com.yumiaobaobao.app.taiking.entity;

/**
 * @author zzl
 * @date
 * @Description
 */
public class talkingphotos {

    private Integer id;

    private String talkingphotosUrl;

    private Integer talkingshopId;

    private Integer lft;

    private Integer rgt;

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTalkingphotosUrl() {
        return talkingphotosUrl;
    }

    public void setTalkingphotosUrl(String talkingphotosUrl) {
        this.talkingphotosUrl = talkingphotosUrl;
    }

    public Integer getTalkingshopId() {
        return talkingshopId;
    }

    public void setTalkingshopId(Integer talkingshopId) {
        this.talkingshopId = talkingshopId;
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
}
