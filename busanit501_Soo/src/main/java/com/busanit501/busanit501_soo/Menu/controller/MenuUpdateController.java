package com.busanit501.busanit501_soo.Menu.controller;


import com.busanit501.busanit501_soo.Menu.dto.MenuDTO;
import com.busanit501.busanit501_soo.Menu.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "MenuUpdate", urlPatterns = "/menu/update")
public class MenuUpdateController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long menuNo = Long.parseLong(request.getParameter("menuNo"));
            MenuDTO sample = menuService.getSelectOne(menuNo);
            log.info("MenuController: " + sample);

            request.setAttribute("sample", sample);
            request.getRequestDispatcher("/WEB-INF/menu/menuUpd.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Long menuNo = Long.parseLong(request.getParameter("menuNo"));
        log.info("MenuController: " + menuNo);
        String MenuTitle = request.getParameter("menuTitle");
        log.info("MenuController: " + MenuTitle);
        LocalDate MenuRegDate = LocalDate.parse(request.getParameter("regDate"));
        log.info("MenuController: " + MenuRegDate);

        MenuDTO menuDTO = MenuDTO.builder()
                .menuNo(menuNo)
                .menuTitle(MenuTitle)
                .regDate(MenuRegDate)
                .build();

        //서비스 전달
        try {
            menuService.MenuUpdate(menuDTO);
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}





















