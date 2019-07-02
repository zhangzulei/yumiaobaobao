package com.yumiaobaobao.app.message_board.service.impl;

import com.yumiaobaobao.app.message_board.dao.message_boardMapper;
import com.yumiaobaobao.app.message_board.service.message_boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */
@Service
public class message_boardServiceImpl implements message_boardService {
    @Autowired
    private message_boardMapper message_boardMapper;

    @Override
    public int addMessageBoard(Map map) {
        return message_boardMapper.addMessageBoard(map);
    }
}
