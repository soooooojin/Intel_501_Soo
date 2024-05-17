package com.busanit501.busanit501_soo.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
  // 게시글 하나의 정보의 창(화면), todo(게시글 한개) 하나의 정보가 필요해요.
  // todo 할일 목록, 1. 청소하기. 2.설겆이하기. 3.분리수거하기. 4. 애들 목욕시키기


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp");
    requestDispatcher.forward(req, resp);
  }
}







