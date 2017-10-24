<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/10/20
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页头</title>
</head>
<body>
<h1>文件上传与下载</h1><br><br>
<a href="${pageContext.request.contextPath}/upFileServlet" target="main">上传文件</a>
<a href="${pageContext.request.contextPath}/listFileServlet" target="main">下载文件</a>
</body>
</html>
