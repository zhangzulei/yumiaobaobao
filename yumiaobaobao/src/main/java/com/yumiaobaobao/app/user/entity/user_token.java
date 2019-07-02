package com.yumiaobaobao.app.user.entity;

/**
 * @author zzl
 * @date
 * @Description
 */
public class user_token {

    private int tokenid,userid;

    private String token;

    public int getTokenid() {
        return tokenid;
    }

    public void setTokenid(int tokenid) {
        this.tokenid = tokenid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
