package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


// 过滤器的执行顺序是通过　过滤器的类名进行排序的


@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("abc 过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
