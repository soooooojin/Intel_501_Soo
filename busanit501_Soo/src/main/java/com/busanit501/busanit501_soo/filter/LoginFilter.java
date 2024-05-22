package com.busanit501.busanit501_soo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 기본 설정,
        // 동작 여부 확인.
        log.info("로그인 필터 동작 여부 확인. ");

        // ServletRequest는 HttpServletRequest 의 상위. -> 다운캐스팅.

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        // 세션을 이용하기위해서, 도구 필요. 도구 준비.
        HttpSession session = req.getSession();
        // 로그인시, 세션의 임시 공간의 이름 : loginInfo ,
        // 로그인을 해야 -> 세션 생성. -> 필터를 통과해요.
        //
        if(session.getAttribute("loginInfo") ==null) {
            resp.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}

