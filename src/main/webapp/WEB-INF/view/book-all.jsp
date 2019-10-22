<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="allBooks" scope="request" type="java.util.List"/>
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
            <c:forEach var="book" items="${allBooks}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.year}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/${book.id}">More details...</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
