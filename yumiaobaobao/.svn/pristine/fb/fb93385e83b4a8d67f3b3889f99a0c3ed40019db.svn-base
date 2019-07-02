package com.yumiaobaobao.app.user.draft.service;

import com.yumiaobaobao.app.user.entity.user_draft;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface user_draftService {

    Boolean addDraft(@Param("draft") user_draft draft);

    Boolean deleteDraft(@Param("Id") Integer Id);

    List<user_draft> allDraft(String user_id);
}
