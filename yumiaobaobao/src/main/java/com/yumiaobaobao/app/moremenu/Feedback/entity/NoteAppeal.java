package com.yumiaobaobao.app.moremenu.Feedback.entity;


import java.time.LocalDateTime;

/**
 * 便签申述
 */
public class NoteAppeal {

    private Integer id;
    private Integer appealtype;

    private String details;

    private String detailsimg;

    private Integer notesid;

    private Integer notespeople;

    private Integer appealresult;

    private Integer appealstatus;

    private LocalDateTime appealdatetime;

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppealtype() {
        return appealtype;
    }

    public void setAppealtype(Integer appealtype) {
        this.appealtype = appealtype;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetailsimg() {
        return detailsimg;
    }

    public void setDetailsimg(String detailsimg) {
        this.detailsimg = detailsimg;
    }

    public Integer getNotesid() {
        return notesid;
    }

    public void setNotesid(Integer notesid) {
        this.notesid = notesid;
    }

    public Integer getNotespeople() {
        return notespeople;
    }

    public void setNotespeople(Integer notespeople) {
        this.notespeople = notespeople;
    }

    public Integer getAppealresult() {
        return appealresult;
    }

    public void setAppealresult(Integer appealresult) {
        this.appealresult = appealresult;
    }

    public Integer getAppealstatus() {
        return appealstatus;
    }

    public void setAppealstatus(Integer appealstatus) {
        this.appealstatus = appealstatus;
    }

    public LocalDateTime getAppealdatetime() {
        return appealdatetime;
    }

    public void setAppealdatetime(LocalDateTime appealdatetime) {
        this.appealdatetime = appealdatetime;
    }
}