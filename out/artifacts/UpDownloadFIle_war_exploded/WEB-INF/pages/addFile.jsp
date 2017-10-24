<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/10/20
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传页面</title>
</head>
<body style="text-align: center">
<form method="post" action="${pageContext.request.contextPath}/upFileServlet" enctype="multipart/form-data">
    <table width="40%" bgcolor="#f0f8ff" border="1">
        <tr>
            <td>上传用户</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>上传文件</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td>文件描述</td>
            <td><textarea rows="6" cols="50" name="description"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
