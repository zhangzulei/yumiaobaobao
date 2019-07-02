package com.yumiaobaobao.app.moremenu.myattention.personal.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class UserFollow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.followuser_id
     *
     * @mbggenerated
     */
    private Integer followuserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.createtime
     *
     * @mbggenerated
     */
    private LocalDateTime createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User_Follow.updatetime
     *
     * @mbggenerated
     */
    private Date updatetime;

    private String username;

    private String avatarimg;

    private String attention;

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarimg() {
        return avatarimg;
    }

    public void setAvatarimg(String avatarimg) {
        this.avatarimg = avatarimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.id
     *
     * @return the value of User_Follow.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.id
     *
     * @param id the value for User_Follow.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.user_id
     *
     * @return the value of User_Follow.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.user_id
     *
     * @param userId the value for User_Follow.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.followuser_id
     *
     * @return the value of User_Follow.followuser_id
     *
     * @mbggenerated
     */
    public Integer getFollowuserId() {
        return followuserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.followuser_id
     *
     * @param followuserId the value for User_Follow.followuser_id
     *
     * @mbggenerated
     */
    public void setFollowuserId(Integer followuserId) {
        this.followuserId = followuserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.status
     *
     * @return the value of User_Follow.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.status
     *
     * @param status the value for User_Follow.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.createtime
     *
     * @return the value of User_Follow.createtime
     *
     * @mbggenerated
     */
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.createtime
     *
     * @param createtime the value for User_Follow.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User_Follow.updatetime
     *
     * @return the value of User_Follow.updatetime
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User_Follow.updatetime
     *
     * @param updatetime the value for User_Follow.updatetime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}