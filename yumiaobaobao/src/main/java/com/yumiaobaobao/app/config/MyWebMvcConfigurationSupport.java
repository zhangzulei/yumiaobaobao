
package com.yumiaobaobao.app.config;

/**
 * 配置静态资源访问
 */

//@Configuration
public class MyWebMvcConfigurationSupport /*extends WebMvcConfigurationSupport*/ {

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addInterceptors 方法 可以实现 拦截器配置
     * addPathPatterns 添加拦截器规则
     * excludePathPatterns 用户访问拦截排除
     * @param registry
     */
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyHandlerInterceptor())
//                .addPathPatterns("/**").excludePathPatterns("/","/login");
//        super.addInterceptors(registry);
//    }

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addResourceHandlers 方法 可以实现 静态资源的访问
     * addResourceHandler 相对路径 项目中 resources 文件夹下文件访问
     * addResourceLocations 绝对路径 url 直接可以访问 resources 下的访问
     * @param registry
 /*    *//*
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*//**").addResourceLocations("classpath:/");
        super.addResourceHandlers(registry);
    }*/

    /**
     * 重写 父类 WebMvcConfigurationSupport 中的 addViewControllers 方法 可以实现 页面跳转
     * addViewController 设置项目路径根路径
     * setViewName 设置访问根路径跳转到的页面
     * @param registry
     */
    /*protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        super.addViewControllers(registry);
    }*/
}
