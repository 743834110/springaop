<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/14
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

        <%--@elvariable id="errors" type="java.util.List"--%>
        <c:forEach items="${errors}" var="error">
            <%--@elvariable id="error" type="org.springframework.validation.ObjectError"--%>
            <%--${error.code}--%>
            <%--${error.objectName}--%>
            <%--${error.defaultMessage}--%>
            <h2>argument</h2>
            ${fn:contains(error.arguments[0],'bookName')}: ${error.defaultMessage}
            <%--<h2>code</h2>--%>
            <%--${error.codes}--%>
            <br/>
        </c:forEach>

        <form  action="book/toAddBook.action" method="post" enctype="multipart/form-data">
            <table class="table table-striped table-bordered">
                <tbody>
                    <tr>
                        <td>ISBN</td>
                        <td>
                            <input title="ISBN" type="text" name="isbn" id="isbn">
                        </td>
                        <td>
                            <p id="isbnHint"></p>
                        </td>
                        <td>
                            <p id="isbnHint"></p>
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
                        <td>封面图片</td>
                        <td>
                            <%--设置为bookImage会因为类型不一而发生异常--%>
                            <input type="file" name="image">
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
        <div class="clearfix row">

        </div>
    </div>
</body>
<script>
    $(function () {

        $("input[title=ISBN]").blur(function () {
            console.log(this)
            $.ajax({
                url: "${pageContext.request.contextPath}/book/search.action",
                data: {isbn: $(this).val()},
                sync: false,
                success: function (res, status, xhr) {
                    var json = eval( '(' + res + ')')
                    if (json.success)
                        $("p#isbnHint").html("ISBN已经存在")
                    else
                        $("p#isbnHint").html("该ISBN合法")

                },
                error: function (status, xhr) {
                    console.log(status)
                }
            })
        })
//        -----------------

        $("input[type = 'reset']").click(function () {
            $.ajax({
                url: "book/findAllBooks.action",
                sync: false,
                success: function (res, status, xhr) {
//                    var json = $.parseJSON(res
                    $.each(res, function (k, v) {
                        var tag = '<p>' + v['isbn'] + v['bookName'] + new Date(v['publishDate']) + '</p>';
                        $("div.clearfix").append(tag)
                    })
                },
                error: function (status, xhr) {
                    console.log(status)
                }
            })
        })
    })
</script>
</html>
