<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/4
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${!empty page}">
    <c:forEach items = "${page.list}" var = "user">
        <div class="contentList">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h4><a class="title" href="#">${user.userName}</a></h4>
                    <p>
                        <span class="overView">User ID: &nbsp </span><span class="overView">${user.userID}</span>
                        <span class="overView">&nbsp Email: &nbsp </span><span class="overView">${user.email}</span>
                        <span class="overView">&nbsp Birthday: &nbsp </span><span class="overView">${user.userBirthday}</span>
                        <span class="overView">&nbsp Gender: &nbsp </span><span class="overView">${user.gender}</span>
                        <span><a action="action" type="button">&nbsp Delete</a></span>
                        </span>
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>
<c:if test="${page != null && page.getTotal() > 0 }">
    <nav style="text-align: center">
        <ul class="pagination pagination-lg">
            <li><a>Page ${page.pageNum  } </a></li>
            <c:if test="${page.pageNum!= 1 }">
                <li><a href="?userId=${userId }&page=${page.pageNum -1}">Previous</a></li>
            </c:if>
            <c:if test="${page.pageNum < page.pages }">
                <li><a href="?userId=${userId }&page=${page.pageNum +1}">Next</a></li>
            </c:if>
            <li><a>Total Pages: ${page.pages} </a></li>
        </ul>
    </nav>
</c:if>
</body>
</html>
