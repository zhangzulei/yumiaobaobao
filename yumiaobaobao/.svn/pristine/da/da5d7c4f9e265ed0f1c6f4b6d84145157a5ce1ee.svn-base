package com.yumiaobaobao.app.user.dao;

import com.yumiaobaobao.app.user.entity.user_draft;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_draftMapper {

    /**
     * 新增草稿
     *
     * @param draft
     */
    @Insert("insert into user_draft (user_id,content,createTime) values(#{user_id},#{content},#{createTime})")
    Boolean addDraft(@Param("draft") user_draft draft);

    /**
     * 删除草稿
     *
     * @Param Id 主键
     */
    @Delete("delete from user_draft where Id = #{Id}")
    Boolean deleteDraft(@Param("Id") Integer Id);

    /**
     * 根据user_id查询草稿
     *
     * @Param user_id
     */
    @Select("select * from user_draft where user_id = #{user_id}")
    List<user_draft> allDraft(String user_id);
}
