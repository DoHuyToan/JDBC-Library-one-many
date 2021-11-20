<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/19/2021
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><a href="/librarys">DANH SÁCH SÁCH TRONG THƯ VIỆN</a></h1>
<form method="post">
    <table border="1" cellpadding="5">
        <tr>
            <td>BOOKS</td>
            <td> <input  hidden> ${book.name}</td>
        </tr>
        <tr>
            <td>STUDENT</td>
            <td>
                <select name="student">
                    <c:forEach items="${studentList}" var="student">
                        <option value="${student.id}">${student.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>BORROWDATE</td>
            <td> <input type="text" name="borrowDate" placeholder="Nhập ngày mượn"></td>
        </tr>
        <tr>
            <td>PAYDATE</td>
            <td> <input type="text" name="payDate" placeholder="Nhập ngày trả"></td>
        </tr>
        <tr>
            <td></td>
            <td> <input type="submit" value="Borrow"></td>
        </tr>
    </table>
</form>
<h2><a href="/librarys?action=listcard">DANH SÁCH CARD ĐANG MƯỢN</a></h2>
</body>
</html>
