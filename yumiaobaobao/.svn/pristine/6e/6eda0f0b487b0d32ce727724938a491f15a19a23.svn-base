package com.yumiaobaobao.app.common.utils.config.listen;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author zzl
 * @date
 * @Description
 */

//@WebListener
@Slf4j
public class MySessionListner implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(MySessionListner.class);

    /**
     * 新建session时（打开浏览器访问登录页面时，服务器会创建一个新的session）
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("创建Session");
        HttpSession session = event.getSession();
        if(session.getAttribute("userid")!=null){
            //表明已经有人登录,销毁session
            session.invalidate();
        }
        //再放入新的session
        session.setAttribute("userid",session.getAttribute("userid"));
    }


    /**
     * 删除session时（退出系统）
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("销毁session时");
        HttpSession session = event.getSession();
        session.invalidate();
    }

}
