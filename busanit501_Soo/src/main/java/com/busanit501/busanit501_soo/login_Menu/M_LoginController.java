package com.busanit501.busanit501_soo.login_Menu;

import com.busanit501.busanit501_soo.Menu.dto.M_MemberDTO;
import com.busanit501.busanit501_soo.Menu.service.M_MemberService;
import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import com.busanit501.busanit501_soo.todo.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "M_loginController", urlPatterns = "/M_login")
public class M_LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 입력폼으로 전달.
        System.out.println("get 으로 login 처리");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/M_login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String auto = req.getParameter("auto");
        boolean rememberMe = auto != null && auto.equals("on");


        try {
            M_MemberDTO M_memberDTO = M_MemberService.INSTANCE.getOneMember(id, pw);

            if (rememberMe) {
               String uuid = UUID.randomUUID().toString();
                M_MemberService.INSTANCE.updateUUID(id, uuid);
                M_memberDTO.setUuid(uuid);

            Cookie rememberCookie = new Cookie("remember-me",uuid);

                rememberCookie.setPath("/");
                resp.addCookie(rememberCookie);

                 HttpSession session = req.getSession();
                session.setAttribute("loginInfo", M_memberDTO);
                resp.sendRedirect("/menu/list");
            } else {
               HttpSession session = req.getSession();
                session.setAttribute("loginInfo", M_memberDTO);
                resp.sendRedirect("/menu/list");
            }

       } catch (Exception e) {
            resp.sendRedirect("/M_login?result=error");
        }

    }// doPost 닫는 부분
} // class 닫는 부분



