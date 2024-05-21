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
import java.util.List;

@Log4j2
@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

  //주입, 서비스 인스턴스, 포함
  private  TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //DB에서 전체 목록 가져오기
  //화면 처리
    try {
      //todoService.listAll(); -> 디비에서, 전체 목록 가져오기.
      List<TodoDTO> sampleList = todoService.listAll();
      log.info("TodoListController , 확인2, sampleList : " + sampleList);

      // 컨트롤러에서 -> 화면에 -> 데이터 전달
      req.setAttribute("list",sampleList);
      req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}







