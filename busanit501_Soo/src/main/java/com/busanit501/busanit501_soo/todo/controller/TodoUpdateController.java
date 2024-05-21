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
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "todoUpdate",urlPatterns = "/todo/update")
public class TodoUpdateController extends HttpServlet {
  private TodoService todoService = TodoService.INSTANCE;
  // 폼, 처리도

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Long tno = Long.valueOf(req.getParameter("tno"));
      TodoDTO sample = todoService.getSelectOne(tno);
      log.info("TodoListController ,확인2, sample : " + sample);

      req.setAttribute("sample", sample);
      req.getRequestDispatcher("/WEB-INF/todo/todoUpd.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //처리
    Long tno = Long.valueOf(req.getParameter("tno"));
    log.info("tno: 수정작업중, 데이터받아서 확인중.1 tno : " + tno);
    String title = req.getParameter("title");
    log.info("tno: 수정작업중, 데이터받아서 확인중.2 title: " + title);
    LocalDate localDate = LocalDate.parse(req.getParameter("dueDate"));
    log.info("tno: 수정작업중, 데이터받아서 확인중.3 localDate: " + localDate);
    String checkBox = req.getParameter("finished");
    log.info("tno: 수정작업중, 데이터받아서 확인중.4 checkBox: " + checkBox);

    // 박스에 담기. DTO  담고, -> VO 변환.
    TodoDTO todoDTO = TodoDTO.builder()
            .title(title)
            .dueDate(localDate)
            .finished(checkBox != null && checkBox.equals("on") ? true : false)
            .tno(tno)
            .build();

    // 서비스에 전달하기.
    try {
      todoService.updateTodo(todoDTO);
      resp.sendRedirect("/todo/list");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}







