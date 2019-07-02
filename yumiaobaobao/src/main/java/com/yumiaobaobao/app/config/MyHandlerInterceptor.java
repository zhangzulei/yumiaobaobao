package com.yumiaobaobao.app.config;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyHandlerInterceptor  implements HandlerInterceptor {

   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
//        User user = (User)
        String user = (String)request.getSession().getAttribute("user");
        if(null == user){
            response.sendRedirect("login");
        }else{
            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }*/
}
