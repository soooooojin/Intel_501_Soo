package com.busanit501.busanit501_soo.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReg", urlPatterns = "/todo/register")
public class TodoRegController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //todo 글 입력 폼
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoReg.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // todo 글 입력 처리 하는 로직.
    // 리다이렉트, 메인: 리스트
    resp.sendRedirect("/todo/list");
  }
}







