package com.yumiaobaobao.app.shop.entity;

/**
  * @Title 商户信息
　* @author
　* @date 2019.05.28 14:55
　*/
public class Schoolshop {
    /**
     * id
     */
    private Integer id;

    /**
     * 商铺名字
     */
    private String schoolname;

    /**
     * 平均评分
     */
    private Double avgscore;

    /**
     * 课堂质量
     */
    private Double qualityscore;

    /**
     * 环境
     */
    private Double surroundingsscore;

    /**
     * 人气
     */
    private Double Popularityscore;

    /**
     * 人均价格
     */
    private Integer percapita;

    /**
     * 个性签名/描述
     */
    private String description;

    /**
     * 营业状态 0闭业 1营业
     */
    private Short schooltype;

    /**
     * 营业时间
     */
    private String schoolopentime;

    /**
     * 地址
     */
    private String schooladdress;

    /**
     * 电话
     */
    private String schoolphone;

    /**
     * 座机
     */
    private String schoolcoll;

    /**
     * 特色服务
     */
    private String schoolserviceid;

    /**
     * 其他需知
     */
    private String otherid;

    /**
     * 闭业时间
     */
    private String sendtime;

    /**
     * 是否可以停车 0否 1是
     */
    private Integer isparking;

    /**
     * 是否有wifi 0否 1是
     */
    private Integer iswifi;

    /**
     * 是否有优惠活动 0否 1是
     */
    private Integer isactivity;

    /**
     * 距离
     */
    private Integer distance;

    /**
     * 店铺封面
     */
    private String schoolshopimg;

    /**
     * 粉丝数
     */
    private Integer fennumber;

    /**
     * 所属商圈
     */
    private Integer tradingarea;

    /**
     * 商品数
     */
    private Integer couresnumber;


    private Integer classType;

    /**
     * 店铺头像
     */
    private String avatarImg;
    /**
     *商圈名称
     */
    private String tradingAreaName;

    private Double longitude;

    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTradingAreaName() {
        return tradingAreaName;
    }

    public void setTradingAreaName(String tradingAreaName) {
        this.tradingAreaName = tradingAreaName;
    }

    public String getAvatarImg() {
        return avatarImg;
    }

    public void setAvatarImg(String avatarImg) {
        this.avatarImg = avatarImg;
    }

    public Double getPopularityscore() {
        return Popularityscore;
    }

    public void setPopularityscore(Double popularityscore) {
        Popularityscore = popularityscore;
    }


    private String attention;

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Double avgscore) {
        this.avgscore = avgscore;
    }

    public Double getQualityscore() {
        return qualityscore;
    }

    public void setQualityscore(Double qualityscore) {
        this.qualityscore = qualityscore;
    }

    public Double getSurroundingsscore() {
        return surroundingsscore;
    }

    public void setSurroundingsscore(Double surroundingsscore) {
        this.surroundingsscore = surroundingsscore;
    }



    public Integer getPercapita() {
        return percapita;
    }

    public void setPercapita(Integer percapita) {
        this.percapita = percapita;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(Short schooltype) {
        this.schooltype = schooltype;
    }


    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress;
    }

    public String getSchoolphone() {
        return schoolphone;
    }

    public void setSchoolphone(String schoolphone) {
        this.schoolphone = schoolphone;
    }

    public String getSchoolcoll() {
        return schoolcoll;
    }

    public void setSchoolcoll(String schoolcoll) {
        this.schoolcoll = schoolcoll;
    }

    public String getSchoolserviceid() {
        return schoolserviceid;
    }

    public void setSchoolserviceid(String schoolserviceid) {
        this.schoolserviceid = schoolserviceid;
    }

    public String getOtherid() {
        return otherid;
    }

    public void setOtherid(String otherid) {
        this.otherid = otherid;
    }

    public String getSchoolopentime() {
        return schoolopentime;
    }

    public void setSchoolopentime(String schoolopentime) {
        this.schoolopentime = schoolopentime;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getIsparking() {
        return isparking;
    }

    public void setIsparking(Integer isparking) {
        this.isparking = isparking;
    }

    public Integer getIswifi() {
        return iswifi;
    }

    public void setIswifi(Integer iswifi) {
        this.iswifi = iswifi;
    }

    public Integer getIsactivity() {
        return isactivity;
    }

    public void setIsactivity(Integer isactivity) {
        this.isactivity = isactivity;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getSchoolshopimg() {
        return schoolshopimg;
    }

    public void setSchoolshopimg(String schoolshopimg) {
        this.schoolshopimg = schoolshopimg;
    }

    public Integer getFennumber() {
        return fennumber;
    }

    public void setFennumber(Integer fennumber) {
        this.fennumber = fennumber;
    }

    public Integer getTradingarea() {
        return tradingarea;
    }

    public void setTradingarea(Integer tradingarea) {
        this.tradingarea = tradingarea;
    }

    public Integer getCouresnumber() {
        return couresnumber;
    }

    public void setCouresnumber(Integer couresnumber) {
        this.couresnumber = couresnumber;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }
}
