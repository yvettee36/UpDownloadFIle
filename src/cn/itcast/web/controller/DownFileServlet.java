package cn.itcast.web.controller;

import cn.itcast.domain.Upfile;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by yvettee on 2017/10/23.
 */
@WebServlet(name = "DownFileServlet", urlPatterns = "/downFileServlet")
public class DownFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BusinessService service = new BusinessServiceImpl();
        Upfile upfile = service.findUpfile(id);

        File upFile = new File(upfile.getSavePath() + "\\" + upfile.getUuidName());
        if (!upFile.exists()) {
            request.setAttribute("message", "下载资源已被删除！！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(upfile.getFileName(), "UTF-8"));

        File file = new File(upfile.getSavePath() + "\\" + upfile.getUuidName());
        FileInputStream in = new FileInputStream(file);
        int len = 0;
        byte buffer[] = new byte[1024];
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
    }
}
