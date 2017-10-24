package cn.itcast.web.controller;

import cn.itcast.domain.Upfile;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.WebUtils;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yvettee on 2017/10/20.
 */
@WebServlet(name = "UpFileServlet", urlPatterns = "/upFileServlet")
public class UpFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            request.setAttribute("message", "不支持的操作");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        try {
            String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
            Upfile upfile = WebUtils.doUpload(request, savePath);
            BusinessService service = new BusinessServiceImpl();
            service.addUpfile(upfile);
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("message", "文件不能超过5M");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "上传失败！");
        }
        request.setAttribute("message", "上传成功！！");
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    //跳转到jsp，显示上传页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addFile.jsp").forward(request, response);
    }
}
