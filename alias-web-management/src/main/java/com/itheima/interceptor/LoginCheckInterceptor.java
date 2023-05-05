package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    // 按下　ctrl + o 弹出需要实现的方法
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("调用　Controller　之前");
        // 获取请求 URL
        String url = req.getRequestURL().toString();
        log.info("Interceptor 请求URL: {}", url);

        // 判断是否是登录请求

        if (url.contains("login")) {
            return true;
        }

        // 获取请求的　token
        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("Interceptor 请求头　token 为空");
            Result error = Result.notLogin();
            // 手动将对象转化为 json, 由于　Controller 中的　RestController　会自动将对象转化为json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        // 校验　jwt
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Interceptor 解析jwt失败");
            Result error = Result.notLogin();
            // 手动将对象转化为 json, 由于　Controller 中的　RestController　会自动将对象转化为json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        log.info("Interceptor token合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("调用　Controller　之后");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
