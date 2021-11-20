<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/19/2021
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DANH SÁCH CARD ĐANG MƯỢN</h1>
<h2> <a href="/librarys">RETURN BOOKLIST</a> </h2>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>BOOK</th>
        <th>AUTHOR</th>
        <th>STUDENT BORROW</th>
        <th>CLASSNAME</th>
        <th>BORROEDATE</th>
        <th>PAYDATE</th>
        <th>DElETE</th>
    </tr>
    <c:forEach items="${cardList}" var="card">
        <tr>
            <td>${card.getId()}</td>
            <td>${card.getBook().name} </td>
            <td>${card.getBook().getAuthor()}</td>
            <td>${card.getStudent().name}</td>
            <td>${card.getStudent().getClassName()}</td>
            <td>${card.getBorrowDate()}</td>
            <td>${card.getPayDate()}</td>
            <td> <a href="/librarys?action=delete&id=${card.id}">DELETE</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
