package com.yumiaobaobao.app.proof.otherproof.entity;

import java.time.LocalDateTime;

/**
 * Created by WH on 2019/04/23.
 */
public class Agency {

    private int id;

    private int userId;
    private int agencyType;

    private String agencyName;

    private String agencyAddress;

    private String agencyContact;

    private String agencyPhoneEmail;

    private String Checkinletter;

    private String businesslicense;

    private String OtherCertificate;

    private LocalDateTime createdate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgencyType() {
        return agencyType;
    }

    public void setAgencyType(int agencyType) {
        this.agencyType = agencyType;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    public String getAgencyContact() {
        return agencyContact;
    }

    public void setAgencyContact(String agencyContact) {
        this.agencyContact = agencyContact;
    }

    public String getAgencyPhoneEmail() {
        return agencyPhoneEmail;
    }

    public void setAgencyPhoneEmail(String agencyPhoneEmail) {
        this.agencyPhoneEmail = agencyPhoneEmail;
    }

    public String getCheckinletter() {
        return Checkinletter;
    }

    public void setCheckinletter(String checkinletter) {
        Checkinletter = checkinletter;
    }

    public String getBusinesslicense() {
        return businesslicense;
    }

    public void setBusinesslicense(String businesslicense) {
        this.businesslicense = businesslicense;
    }

    public String getOtherCertificate() {
        return OtherCertificate;
    }

    public void setOtherCertificate(String otherCertificate) {
        OtherCertificate = otherCertificate;
    }
}
