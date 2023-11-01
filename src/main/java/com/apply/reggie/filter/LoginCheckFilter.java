package com.apply.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.apply.reggie.common.BaseContext;
import com.apply.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebFilter(filterName = "loginCheck", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    private String[] uris = {"/employee/login", "/employee/logout",
            "/backend/**", "/front/**", "/common/**", "/user/sendMsg", "/user/login",
            "/doc.html",
            "/webjars/**",
            "/swagger-resources",
            "/v2/api-docs"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (check(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        Long employee = (Long) request.getSession().getAttribute("employee");
        BaseContext.setCurrentId(employee);
        if (!Objects.isNull(employee)) {
            filterChain.doFilter(request, response);
            return;
        }
        //4-2、判断登录状态，如果已登录，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录，用户id为：{}", request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request, response);
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("用户未登录");

    }


    public boolean check(String uri) {
        for (String s : uris) {
            if (PATH_MATCHER.match(s, uri)) return true;
        }
        return false;
    }
}
