<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/14
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
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
    <header>
    </header>
    <aside>

    </aside>
    <section>
        <div class="container">
            <h2 class="text-center">书籍列表</h2>
            <ul class="list-unstyled list-inline">
                <li><a href="book/addBook.action">添加书籍</a></li>
                <li><a href="#">搜索</a></li>
            </ul>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>ISBN</th>
                    <th>书籍名称</th>
                    <th>价格</th>
                    <th>出版社</th>
                    <th>出版时间</th>
                    <th>分类</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.bookName}</td>
                        <td>${book.price}</td>
                        <td>${book.publisher}</td>
                        <td>${book.publishDate.toLocaleString()}</td>
                        <td>${book.category.id}</td>
                        <td>
                            <a href="" id="">修改</a>
                            <a href="javascript:deleteIsbn('${book.isbn}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </section>
</body>
    <script>
        function deleteIsbn(isbn) {
            if (confirm("确认要删除该书籍吗?")){
                window.location.href = "book/deleteBook.action?isbn=" + isbn;
            }
        }
    </script>
</html>