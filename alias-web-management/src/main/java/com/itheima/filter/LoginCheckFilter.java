package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("登录检查过滤器被调用了");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取请求 URL
        String url = req.getRequestURL().toString();
        log.info("请求URL: {}", url);

        // 判断是否是登录请求

        if (url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取请求的　token
        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头　token 为空");
            Result error = Result.notLogin();
            // 手动将对象转化为 json, 由于　Controller 中的　RestController　会自动将对象转化为json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 校验　jwt
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析jwt失败");
            Result error = Result.notLogin();
            // 手动将对象转化为 json, 由于　Controller 中的　RestController　会自动将对象转化为json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        log.info("token合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
