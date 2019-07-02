package com.yumiaobaobao.app.moremenu.Feedback.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by WH on 2019/03/27.
 */
@Repository
public interface OpinionMapper {

    /**
     * 新增意见反馈
     * @param map
     * @return
     */
    @Insert("INSERT INTO opinion(userid,questiontype,problemdescription,probleimg,probledatetime) VALUES(#{map.userid},#{map.questiontype},#{map.problemdescription},#{map.probleimg},#{map.probledatetime})")
    int addopinion(
            @Param("map") Map<String, Object> map);

    /**
     * 新增申诉
     * @param map
     * @return
     */
    @Insert("INSERT INTO note_appeal(appealtype,Details,Detailsimg,notesid,notespeople,appealdatetime) VALUES(#{map.appealtype},#{map.Details},#{map.Detailsimg},#{map.notesid},#{map.notespeople},#{map.appealdatetime})")
    int addNote(
            @Param("map") Map<String, Object> map);
}
