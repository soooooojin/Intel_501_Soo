package com.busanit501.busanit501_soo.todo.controller;

import com.busanit501.busanit501_soo.todo.dto.TodoDTO;
import com.busanit501.busanit501_soo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2 //로깅 도구
@WebServlet(name = "todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
  //주입 , 서비스 인스턴스 , 포함.
  private TodoService todoService = TodoService.INSTANCE;

  // 게시글 하나의 정보의 창(화면), todo(게시글 한개) 하나의 정보가 필요해요.
  // todo 할일 목록, 1. 청소하기. 2.설겆이하기. 3.분리수거하기. 4. 애들 목욕시키기


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      //db에서 가져오기
      Long tno = Long.valueOf(req.getParameter("tno"));
      TodoDTO sample = todoService.getSelectOne(tno);

      log.info("TodoListController , 확인2, sample : " + sample);
      //화면에 전달하기
      req.setAttribute("sample", sample);

      //쿠키 찾기
      //findCookie 메서드, 첫번째 파라미터 : 쿠키의 전체 목록,
      // 두번째 파라미터, 내가 찾고자하는 쿠키의 키 이름
      Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");

      String todoListResult = viewTodoCookie.getValue();
      boolean exist = false;

      if(todoListResult != null && todoListResult.indexOf(tno + "-") >= 0) {
        exist = true;
      }

      //exist가 false면 동작함
      //아래 코드 동작 할려면, 최근에 본 내용이 쿠키에 저장이 안되었다는 말.
      if (!exist) {
        //쿠키의 값에 추가. 예) "1-"
        todoListResult += tno + "-";
        //쿠키의 값을
        viewTodoCookie.setValue(todoListResult);
        viewTodoCookie.setMaxAge(60*60*24);
        viewTodoCookie.setPath("/");
        resp.addCookie(viewTodoCookie);
      }


      req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp")
              .forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }//doGet
  private Cookie findCookie(Cookie[] cookies, String cookieName){
    //찾은 쿠키를 담을 임시 쿠키.
    Cookie targetCookie = null;

    if(cookies != null && cookies.length >0){
      for (Cookie cookie : cookies) {
        if(cookie.getName().equals(cookieName)){
          targetCookie = cookie;
          break;
        }
      }
    }// if 조건문

    if (targetCookie == null) {
      targetCookie = new Cookie(cookieName, "");
      targetCookie.setPath("/");
      targetCookie.setMaxAge(60*60*24);

    }
    return targetCookie;
  } // findCookie 닫는 부분

} //TodoReadController 끝나는 부분.








