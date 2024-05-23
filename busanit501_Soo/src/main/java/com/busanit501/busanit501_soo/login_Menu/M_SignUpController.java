package com.busanit501.busanit501_soo.login_Menu;

import com.busanit501.busanit501_soo.Menu.dto.M_MemberDTO;
import com.busanit501.busanit501_soo.Menu.service.M_MemberService;
import com.busanit501.busanit501_soo.todo.dto.MemberDTO;
import com.busanit501.busanit501_soo.todo.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "M_signUpController", urlPatterns = "/M_signup")
public class M_SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 입력폼으로 전달.
        System.out.println("get 으로 M_signup 처리");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login/M_signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션의 정보를 설정, setter
        // 화면에서, 아이디, 패스워드를 먼저 받기.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pw = req.getParameter("pw");

        // 화면에서 입력받은 아이디, 패스워드, 이름, 어디 담죠? MemberDTO -> 서비스
        // 임시 모델 DTO
        M_MemberDTO M_memberDTO = M_MemberDTO.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .build();

        try {
            M_MemberService.INSTANCE.insertMember(M_memberDTO);
            resp.sendRedirect("/M_login");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }// doPost 닫는 부분
} // class 닫는 부분

