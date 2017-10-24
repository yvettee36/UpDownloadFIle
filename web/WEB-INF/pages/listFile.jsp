<%--
  Created by IntelliJ IDEA.
  User: yvettee
  Date: 2017/10/23
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>下载列表</title>
</head>
<body style="text-align: center;">
<br/>
<table width="90%" frame="border">
    <tr>
        <td>文件名称</td>
        <td>上传时间</td>
        <td>文件描述</td>
        <td>上传人</td>
        <td>操作</td>
    </tr>
    <c:forEach var="upfile" items="${list}">
        <tr>
            <td>${upfile.fileName }</td>
            <td>${upfile.upTime }</td>
            <td>${upfile.description }</td>
            <td>${upfile.userName }</td>
            <td>
                <a href="${pageContext.request.contextPath }/downFileServlet?id=${upfile.id }">下载</a>
                <a href="#">修改文件信息</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
