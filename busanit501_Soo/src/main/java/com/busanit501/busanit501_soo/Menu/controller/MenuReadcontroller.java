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

@Log4j2
@WebServlet(name = "menuRead", urlPatterns = "/menu/read")
public class MenuReadcontroller extends HttpServlet {

    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            MenuDTO sample = menuService.getSelectOne(menuNo);

            req.setAttribute("sample", sample);
            req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
