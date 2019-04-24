<%--
  Created by IntelliJ IDEA.
  User: Mr.chen
  Date: 2019/4/19
  Time: 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>展示所有数据的页面</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.createtime}</td>
            <td>${item.detail}</td>
        <td>    <a href="${pageContext.request.contextPath}/showDetail/${item.id}">详情</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
