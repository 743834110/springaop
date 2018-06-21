<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/21
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <form  action="system/login.action" method="post">
            <table class="table">
                <thead>
                    <th colspan="3" style="text-align: center">
                        用户登录
                    </th>
                </thead>
                <tbody>
                    <tr>
                        <td>账号：</td>
                        <td>
                            <input name="userName" type="text">
                        </td>
                        <td id="userNameHint" class="text-warning">
                            ${error}
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input name = "password" type="password">
                        </td>
                        <td id="passwordHint">

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit">
                        </td>
                        <td>
                            <input type="reset">
                        </td>

                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
