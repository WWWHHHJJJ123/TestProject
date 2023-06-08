package com.whj.test.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/8
 * @描述 实现功能登录检查
 * 1.配置拦截器要拦截那些请求
 * 2.把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是{}",requestURI);
        //登录检查逻辑
        HttpSession session = request.getSession();
        //判断session中是否存在loginUser，登录成功的用户会在session中加入loginUser对象
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return true;
        }
        //拦截请求。未登录，跳转到登录页
        //response.sendRedirect("/");//使用重定向传不过去msg信息，需要修改为请求转发
        request.setAttribute("msg","请先登录！");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    /**
     * 目标方法执行之后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }
    /**
     * 目标方法页面渲染之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }

}
