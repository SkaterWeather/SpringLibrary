<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Add book</title>
    </head>
    <body>
        Input information about book:
        <form action="${pageContext.request.contextPath}/book/add" method="post">
            <table>
                <tr>
                    <td><label for="title">Title:</label></td>
                    <td><input name="title" type="text" required></td>
                </tr>
                <tr>
                    <td><label for="year">Year:</label></td>
                    <td><input name="year" type="number" required></td>
                </tr>
                <tr>
                    <td><label for="price">Price:</label></td>
                    <td><input name="price" type="number" required></td>
                </tr>
            </table>
            <br/>
            <button type="submit">Create</button>
        </form>
    </body>
</html>
