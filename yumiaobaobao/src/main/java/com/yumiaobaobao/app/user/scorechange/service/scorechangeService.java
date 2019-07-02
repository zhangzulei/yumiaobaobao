package com.yumiaobaobao.app.user.scorechange.service;

import com.yumiaobaobao.app.user.scorechange.entity.scorechange;

import java.util.List;
import java.util.Map;

/**
 * @author zzl
 * @date
 * @Description
 */
public interface scorechangeService {

    int addScorechange(Map map);

    List<scorechange> selectByUserid(String userid);

    List<scorechange> selectLastByUserid(String userid);

    int updateScoreZero(String userid);
}
