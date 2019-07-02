package com.yumiaobaobao.app.area.service.impl;

import com.yumiaobaobao.app.area.dao.TradingareaMapper;
import com.yumiaobaobao.app.area.entity.trading_area;
import com.yumiaobaobao.app.area.service.trandingAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */

@Service
public class trandingAreaServiceImpl implements trandingAreaService {

    @Autowired
    private TradingareaMapper trandingArea;

    @Override
    public List<trading_area> findAllByFatherid(Integer fatherid) {
        return trandingArea.findAllByFatherid(fatherid);
    }
}
