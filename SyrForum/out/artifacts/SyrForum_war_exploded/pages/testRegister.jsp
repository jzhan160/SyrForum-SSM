<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/27
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/user/register" method="post">
    username: <input name="UserName" /> <br />
    password: <input name="UserPassword" /> <br />
    Email: <input name="Email" /> <br />
    gender: <input name="Gender" /> <br />
    <input type="submit" value="submit" />

</form>
</body>
</html>
