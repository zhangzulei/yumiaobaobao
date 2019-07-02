package com.yumiaobaobao.app.area.service.impl;

import com.yumiaobaobao.app.area.dao.areaMapper;
import com.yumiaobaobao.app.area.entity.area;
import com.yumiaobaobao.app.area.service.areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzl
 * @date
 * @Description
 */
@Service
public class areaServiceImpl implements areaService {

    @Autowired
    private areaMapper areas;

    @Override
    public List<area> allArea() {
        return areas.allArea();
    }
}
