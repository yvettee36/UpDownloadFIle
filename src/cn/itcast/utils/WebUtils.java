package cn.itcast.utils;

import cn.itcast.domain.Upfile;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by yvettee on 2017/10/20.
 */
public class WebUtils {

    public static Upfile doUpload(HttpServletRequest request, String upPath) throws FileUploadBase.FileSizeLimitExceededException {

        Upfile bean = new Upfile();

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            File file = new File(request.getServletContext().getRealPath("/WEB-INF/temp"));
            if (!file.exists()){
                file.mkdirs();
            }
            //建一个缓存目录
            factory.setRepository(file);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(1000 * 1000 * 5);
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();//userName = aaa
                    String value = item.getString("UTF-8");
                    BeanUtils.setProperty(bean, name, value);
                } else {
                    //得到上传文件名
                    String fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
                    //得到文件保存名称
                    String uuidName = generateFileName(fileName);
                    //得到文件保存路径
                    String savePath = generateSavePath(upPath, uuidName);

                    InputStream in = item.getInputStream();
                    int len = 0;
                    byte buffer[] = new byte[1024];
                    FileOutputStream out = new FileOutputStream(savePath + File.separator + uuidName);
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();

                    bean.setFileName(fileName);
                    bean.setId(UUID.randomUUID().toString());
                    bean.setSavePath(savePath);
                    bean.setUpTime(new Date());
                    bean.setUuidName(uuidName);
                }
            }
            return bean;
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //生成UUID文件名
    private static String generateFileName(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        return UUID.randomUUID().toString() + "." + ext;
    }

    //文件打散存储
    private static String generateSavePath(String path, String fileName) {
        int hashCode = fileName.hashCode();//二进制32位
        int dir1 = hashCode & 0xf;//一级目录
        int dir2 = (hashCode >> 4) & 0xf;//二级目录
        String savePath = path + File.separator + dir1 + File.separator + dir2;
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();//多级目录
        }
        return savePath;
    }
}
