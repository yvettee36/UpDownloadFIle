package cn.itcast.web.controller;

import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yvettee on 2017/10/23.
 */
//
@WebServlet(name = "ListFileServlet", urlPatterns = "/listFileServlet")
public class ListFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        List list = service.getAllUpfile();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/pages/listFile.jsp").forward(request, response);
    }
}
