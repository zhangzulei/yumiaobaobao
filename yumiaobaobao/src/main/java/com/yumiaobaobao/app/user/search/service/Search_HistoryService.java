package com.yumiaobaobao.app.user.search.service;


import com.yumiaobaobao.app.user.entity.search_history;

import java.util.List;
import java.util.Map;

public interface Search_HistoryService {
    int addHistory(Map map);
    List<search_history> allHistory(String userId);
}
