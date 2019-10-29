<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        Hello, this is login page
        <br/>
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <table>
                <tr>
                    <td><label for="username">Login:</label></td>
                    <td><input name="username" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input name="password" type="password" required></td>
                </tr>
            </table>
            <br/>
            <button type="submit">Login</button>
            <br/>
        </form>
    </body>
</html>
