<jsp:useBean id="book" scope="request" type="libraryapp.entity.Book"/>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 21-Oct-19
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${book.title}</title>
    </head>
    <body>
        <h2>${book.title}</h2><br/>
        <b>Publication date: </b>${book.year} <br/>
        <b>Author: </b>${book.authors.get(0).name} ${book.authors.get(0).surname} <br/>
        <b>Price: </b>${book.price}$ <br/>
    </body>
</html>
