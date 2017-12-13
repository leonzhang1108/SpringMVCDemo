<%--
  Created by IntelliJ IDEA.
  User: jianliangzhang
  Date: 2017/12/13
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<c:if test="${!empty userList}">
    <c:forEach var="user" items="${userList}">
        姓名：${user.name} &nbsp;&nbsp;手机号：${user.password} &nbsp;&nbsp;邮箱：${user.id} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
</body>
</html>