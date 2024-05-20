package com.busanit501.busanit501_soo.todo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoDelete", urlPatterns = "/todo/delete")
public class TodoDeleteController extends HttpServlet {
  // 처리

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 임시 처리했다 치고, 리스트로
    resp.sendRedirect("/todo/list");
  }
}







