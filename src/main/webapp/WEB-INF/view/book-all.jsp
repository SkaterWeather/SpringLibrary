<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="books" scope="request" type="java.util.List"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>All Books</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Price</th>
                <th>Year</th>
                <th>About Book</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.year}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/${book.id}">More details...</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rent/add?book_id=${book.id}">Rent</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/book/add">Add new book</a>
    </body>
</html>
