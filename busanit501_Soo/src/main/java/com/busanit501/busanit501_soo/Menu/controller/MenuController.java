package com.busanit501.busanit501_soo.Menu.controller;

import com.busanit501.busanit501_soo.Menu.dto.MenuDTO;
import com.busanit501.busanit501_soo.Menu.service.MenuService;
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
//listController
@WebServlet(name = "MenuController", urlPatterns = "/menu/list")
public class MenuController extends HttpServlet {

    private MenuService menuService = MenuService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 임시 더미 메뉴 10개 등록 .
    // 서비스에서 기능 만든것을 재사용.
    // 서버 -> 클라이언트(뷰)
      try {
          //todoService.listAll(); -> 디비에서, 전체 목록 가져오기.
          List<MenuDTO> sampleList = menuService.listAll();
          log.info("MenuController , 확인2, sampleList : " + sampleList);

          // 컨트롤러에서 -> 화면에 -> 데이터 전달
          req.setAttribute("list",sampleList);
          req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp")
                  .forward(req, resp);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }


  }
}







