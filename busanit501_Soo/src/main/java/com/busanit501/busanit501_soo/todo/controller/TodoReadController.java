package com.busanit501.busanit501_soo.todo.controller;

import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import com.busanit501.busanit501_soo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name = "todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
  //주입 , 서비스 인스턴스 , 포함.
  private TodoService todoService = TodoService.INSTANCE;

  // 게시글 하나의 정보의 창(화면), todo(게시글 한개) 하나의 정보가 필요해요.
  // todo 할일 목록, 1. 청소하기. 2.설거지하기. 3.분리수거하기. 4. 애들 목욕시키기

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Long tno = Long.valueOf(req.getParameter("tno"));
      TodoDTO sample = todoService.getSelectOne(tno);
      log.info("TodoListController , 확인2, sample : " + sample);
      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}







