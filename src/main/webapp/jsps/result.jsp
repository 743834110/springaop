<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/19
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.css"></script>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <meta name="viewport" content="width=device-width, maximum-scale=1.0, initial-scale=1.0, user-scalable=no">
    <meta charset="UTF-8">
</head>
<body>
    <div class="container">
        <c:choose>
            <c:when test="${requestScope.get('result')}">
                <h3>操作成功</h3>
            </c:when>
            <c:otherwise>
                <h3>操作失败</h3>
            </c:otherwise>
        </c:choose>
        <a id="forwardAnchor" href="${url}">点击返回</a>
        <p id="timerTag"></p>
        <p>${param}</p>
        <p>${paramValues}</p>
        <p>${initParam}</p>
        <p>${cookie}</p>
    </div>
</body>
<script>
    $(function () {
        var seconds = 5;
        function reFlash() {
            var html = "剩余" + (seconds --) + "秒返回";
            $("#timerTag").html(html)
            if (seconds === 0){
                $("#forwardAnchor").click()
                clearInterval(id)
            }

        }

        var id = setInterval(reFlash, 1000)
    })
</script>
</html>
