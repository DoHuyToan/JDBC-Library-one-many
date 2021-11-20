<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/19/2021
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BOOK MANAGER</h1>
<h2><a href="/librarys?action=listcard">DANH SÁCH CARD ĐANG MƯỢN</a></h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AUTHOR</th>
        <th>DESCRIPTION</th>
        <th>QUANTITY</th>
        <th>BORROW</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
    <tr>
        <td>${book.id}</td>
        <td>${book.name} </td>
        <td>${book.author} </td>
        <td>${book.description}</td>
        <td>${book.quantity}</td>
        <td><a href="/librarys?action=borrow&id=${book.id}">Borrow</a></td>
    </tr>
    </c:forEach>

</body>
</html>
