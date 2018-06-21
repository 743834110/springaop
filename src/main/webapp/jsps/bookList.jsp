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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <form id="searchBooksForm" role="form" class="form-inline" style="text-align: center" action="book/list.action" method="post">
                    <input id="nextCurrentPageInput" name="currentPage" type="hidden" value="${bookPager.currentPage}">
                    <div class="form-group">
                        <label>ISBN</label>
                        <input class="form-control" type="text" name="isbn" value="${bookPager.param.isbn}"/>
                    </div>
                    <div class="form-group">
                        <label>书籍名称</label>
                        <input class="form-control" type="text" name="bookName" value="${bookPager.param.bookName}"/>
                    </div>
                    <div class="form-group">
                        <label>出版社</label>
                        <input class="form-control" type="text" name = "publisher" value="${bookPager.param.publisher}"/>
                    </div>
                    <div class="form-group">
                        <label>分类</label>
                        <select class="form-control" name="category.id">
                            <c:choose>
                                <c:when test="${bookPager.param.category == null }">
                                    <option value="0" selected></option>
                                </c:when>
                                <c:otherwise>
                                    <option value="0"></option>
                                </c:otherwise>
                            </c:choose>
                            <c:forEach items="${categories}" var="category">
                                <c:choose>
                                    <c:when test="${bookPager.param != null and bookPager.param.category.id == category.id}">
                                        <option value="${category.id}" selected>${category.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.id}">${category.name}</option>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>页内记录数</label>
                        <input type="text" class="form-control" value="${bookPager.pageSize}" name="pageSize">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            <table class="table table-striped table-bordered table-condensed">
                <tr class="active">
                    <th><input type="checkbox"/></th>
                    <th>ISBN</th>
                    <th>书籍名称</th>
                    <th>价格</th>
                    <th>出版社</th>
                    <th>出版时间</th>
                    <td>图片</td>
                    <th>分类</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${bookPager.results}" var="book">
                    <tr>
                        <td><input type="checkbox" name="isbns[]" value="${book.isbn}" /></td>
                        <td>${book.isbn}</td>
                        <td>${book.bookName}</td>
                        <td>${book.price}</td>
                        <td>${book.publisher}</td>
                        <td>${book.publishDate.toLocaleString()}</td>
                        <td><img width="30px" src="${book.bookImage}" alt=""/></td>
                        <td>${book.category.name}</td>
                        <td>
                            <a href="" id="">修改</a>
                            <a href="javascript:deleteIsbn('${book.isbn}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="list-inline" style="float: left">
                        <li>
                            <a href="book/addBook.action">添加书籍</a>
                        </li>
                        <li>
                            <a id="batchDeleteAnchor" href="javascript:void(0)">批量删除</a>
                        </li>
                    </ul>
                    <ul class="pagination" style="float: right; margin-top: 0px">
                        <li>
                            <a href="javascript:submit(${bookPager.prePage})">上一页</a>
                        </li>
                        <li class="active">
                            <a href="javascript:void(0)">${bookPager.currentPage}</a>
                        </li>
                        <li>
                            <a href="javascript:submit(${bookPager.nextPage})">下一页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</body>
    <script>
        $(function () {
            $("a#batchDeleteAnchor").click(function (event) {
                console.log(event)
                var inputs = $("input[name='isbns[]']");
                var data = [];
                var i = 0;
                inputs.each( function(){
                    var input = $(this);

                    if (input['0'].checked){
                        data[i++] = "isbns=" + input["0"].attributes[2].value
                    }
                })
                data = data.join('&')
                if (data.length === 0)
                    return;
                $.ajax({
                    url:"book/batchDeleteBooks.action",
                    data:data,
                    type:"get",
                    success:function(res, status, xhr){
                        //window.location.href = "book/list.action";
                        $("#searchBooksForm").submit()
                        console.log("success!!")
                    },
                    error:function (xhr, status, error) {
                        console.log(xhr)
                    }
                })
            })
        });
        function deleteIsbn(isbn) {
            if (confirm("确认要删除该书籍吗?")){
                window.location.href = "book/deleteBook.action?isbn=" + isbn;
            }
        }
        function submit(pageIndex) {
            $("#nextCurrentPageInput").val(pageIndex)
            $("#searchBooksForm").submit()
        }
    </script>
</html>
