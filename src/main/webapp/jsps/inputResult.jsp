<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/20
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <meta charset="UTF-8">
    <base href="${pageContext.request.contextPath}/">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <meta name="viewport" content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">

</head>
<body>
    <div class="container">
        来自demo的问候：${input}
        数组：
        <pre>
            <c:forEach items="${isbns}" var="book">
                <c:out value="${book}"/>
            </c:forEach>
        </pre>
        <div>
        </div>

        <div class="clearfix row">
        </div>
    </div>
</body>
<script>
    $(function () {
        $.get(
            "showBooks.html",
            function (res, status, xhr) {
                $("div.row").html(res)
                console.log(status)
        })
    })
</script>
</html>
