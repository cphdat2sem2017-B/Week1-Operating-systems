<%-- 
    Document   : login
    Created on : Feb 15, 2016, 12:25:59 PM
    Author     : Ronnie Dalsgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, dataaccesslayer.UserDAO, model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="GET">
            <p>Username:</p>
            <select name="username">
                <% 
                    UserDAO dao = new UserDAO();
                    ArrayList<User> users = dao.getUsers();
                    for(User user : users){
                        out.print("<option value='" + user.getUsername()+ "'>");
                        out.print(user.getUsername());
                        out.println("</option>");
                    }
                %>
            </select>
            <p>Password:</p>
            <input type="text" name="password" value="1234"/>
            <br>
            <input type="submit" value="Login"/>
       </form>
    </body>
</html>
