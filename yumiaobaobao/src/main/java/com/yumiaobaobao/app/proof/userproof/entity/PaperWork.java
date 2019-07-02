package com.yumiaobaobao.app.proof.userproof.entity;

import java.time.LocalDateTime;

/**
 * Created by WH on 2019/04/11.
 */
public class PaperWork {

    private int id;
    private int userid;
    private int isSuccess;
    private int paperworktype;
    private String  TicketId;
    private String paperworkName;
    private String paperworkNumber;
    private String paperworkPhotoSelfie;
    private String paperworkPhotofacade;
    private String paperworkPhotoobverse;
    private LocalDateTime startdatetime;

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
    }

    public String getPaperworkPhotoSelfie() {
        return paperworkPhotoSelfie;
    }

    public void setPaperworkPhotoSelfie(String paperworkPhotoSelfie) {
        this.paperworkPhotoSelfie = paperworkPhotoSelfie;
    }

    public LocalDateTime getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(LocalDateTime startdatetime) {
        this.startdatetime = startdatetime;
    }

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

    public int getPaperworktype() {
        return paperworktype;
    }

    public void setPaperworktype(int paperworktype) {
        this.paperworktype = paperworktype;
    }

    public String getPaperworkName() {
        return paperworkName;
    }

    public void setPaperworkName(String paperworkName) {
        this.paperworkName = paperworkName;
    }

    public String getPaperworkNumber() {
        return paperworkNumber;
    }

    public void setPaperworkNumber(String paperworkNumber) {
        this.paperworkNumber = paperworkNumber;
    }

    public String getPaperworkPhotofacade() {
        return paperworkPhotofacade;
    }

    public void setPaperworkPhotofacade(String paperworkPhotofacade) {
        this.paperworkPhotofacade = paperworkPhotofacade;
    }

    public String getPaperworkPhotoobverse() {
        return paperworkPhotoobverse;
    }

    public void setPaperworkPhotoobverse(String paperworkPhotoobverse) {
        this.paperworkPhotoobverse = paperworkPhotoobverse;
    }



    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }


}
