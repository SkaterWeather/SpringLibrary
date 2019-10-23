<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="rents" scope="request" type="java.util.List"/>

<html>
    <head>
        <title>My rents</title>
    </head>
    <body>
        That's all your rents:
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Rent date</th>
                <th>Book</th>
                <th>Status</th>
            </tr>
            <c:forEach var="rent" items="${rents}">
                <tr>
                    <td>${rent.id}</td>
                    <td>${rent.rentDate}</td>
                    <td>${rent.book.title}</td>
                    <c:choose>
                        <c:when test="${rent.active == true}">
                            <td>
                                Taken
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/rent/discredit?rent_id=${rent.id}">Return</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                Returned
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="${pageContext.request.contextPath}/book">Rent a book</a>
    </body>
</html>
