<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/14
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
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
        <form  action="book/toAddBook.action" method="post">
            <table class="table table-striped table-bordered">
                <tbody>
                    <tr>
                        <td>ISBN</td>
                        <td>
                            <input title="ISBN" type="text" name="isbn">
                        </td>
                    </tr>
                    <tr>
                        <td>书籍名称</td>
                        <td>
                            <input type="text" name="bookName">
                        </td>
                    </tr>
                    <tr>
                        <td>价格</td>
                        <td>
                            <input type="text" name="price">
                        </td>
                    </tr>
                    <tr>
                        <td>出版社</td>
                        <td>
                            <input type="text" name="publisher">
                        </td>
                    </tr>
                    <tr>
                        <td>出版时间</td>
                        <td>
                            <input type="date" name="publishDate">
                        </td>
                    </tr>
                    <tr>
                        <td>分类</td>
                        <td>
                            <select name="category.id">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="提交">
            <input type="reset" name="重置">
        </form>
    </div>
</body>
</html>
