<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h3>Please fill this form to create user:</h3>
        <br/>
        <form action="${pageContext.request.contextPath}/user/registration" method="post">
            <table>
                <tr>
                    <td><label for="username">Username:</label></td>
                    <td><input name="username" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="firstName">First name:</label></td>
                    <td><input name="firstName" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="lastName">Last name:</label></td>
                    <td><input name="lastName" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input name="email" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input name="password" type="password" required></td>
                </tr>
                <tr>
                    <td><label for="matchingPassword">Repeat password:</label></td>
                    <td><input name="matchingPassword" type="password" required></td>
                </tr>
            </table>
            <br/>
            <c:forEach var="error" items="${errors}">
                Error: ${error.defaultMessage}
                <br/>
            </c:forEach>
            <button type="submit">Register</button>
            or <a href="${pageContext.request.contextPath}/user/login">Login</a>
            <br/>
        </form>
    </body>
</html>
