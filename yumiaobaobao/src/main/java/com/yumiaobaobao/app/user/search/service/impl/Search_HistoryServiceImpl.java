package com.yumiaobaobao.app.user.search.service.impl;


import com.yumiaobaobao.app.user.dao.search_historyMapper;
import com.yumiaobaobao.app.user.entity.search_history;
import com.yumiaobaobao.app.user.search.service.Search_HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class Search_HistoryServiceImpl implements Search_HistoryService {
    @Autowired
    private search_historyMapper searchMapper;


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int addHistory(Map map) {
        return searchMapper.addHistory(map);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<search_history> allHistory(String userId) {
        return searchMapper.allHistory(userId);
    }
}
