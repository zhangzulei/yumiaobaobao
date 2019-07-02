package com.yumiaobaobao.app.user.draft.service.impl;

import com.yumiaobaobao.app.user.dao.user_draftMapper;
import com.yumiaobaobao.app.user.draft.service.user_draftService;
import com.yumiaobaobao.app.user.entity.user_draft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */

@Service
public class user_draftServiceImpl implements user_draftService {

    @Autowired
    private user_draftMapper userDraftMapper;

    @Override
    public Boolean addDraft(user_draft draft) {
        return userDraftMapper.addDraft(draft);
    }

    @Override
    public Boolean deleteDraft(Integer Id) {
        return userDraftMapper.deleteDraft(Id);
    }

    @Override
    public List<user_draft> allDraft(String user_id) {
        return userDraftMapper.allDraft(user_id);
    }
}
