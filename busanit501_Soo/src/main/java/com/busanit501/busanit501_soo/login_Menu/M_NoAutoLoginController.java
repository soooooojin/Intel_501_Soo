package com.busanit501.busanit501_soo.login_Menu;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;


@Log4j2
@WebServlet(urlPatterns = "/M_noauto")
public class M_NoAutoLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그 아웃 처리, 세션의 정보를 삭제 하는 것으로 임시 처리.
        log.info("자동로그인 해제, 쿠키제거함. ");
        // 쿠키 정보, 제거하는 코드.
        Cookie cookie = findCookie(req.getCookies(), "remember-me");
        cookie.setValue("");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);

        resp.sendRedirect("/menu/list");
    } //doPost

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        if(cookies == null || cookies.length == 0) {
            return null;
        }
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName)).findFirst();
        return result.isPresent() ? result.get() : null;

    } // findCookie 닫는 부분
} // class