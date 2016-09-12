<%-- 
    Document   : loggedIn
    Created on : Feb 15, 2016, 10:51:13 AM
    Author     : Ronnie Dalsgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, dataaccesslayer.CupcakeDAO, dataaccesslayer.UserDAO, model.User, model.LineItem, model.Cupcake" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            th {text-align: center;width:50%;}
            td {vertical-align:top;}
        </style>
    </head>
    <body>
        <h1>Logged In</h1>
        <% 
            ArrayList<LineItem> cart = (ArrayList<LineItem>)session.getAttribute("cart");
            out.print(showUser(session));
        %>
        <a href="login.jsp">Logout</a>
        <hr>
        <table>
            <tr>
                <th><h2>Cupcakes:</h2></th>
                <th><h2><%= cart != null ? "Shopping cart:" : "Shopping cart is empty" %></h2></th>
            </tr>
            <tr>
                <td><% out.print(showCupcakes()); %></td>
                <td><% out.print(showCart(cart)); %></td>
            </tr>
        </table>
    </body>
</html>
<%!
    private String showUser(HttpSession session){
        String out = "";
        User user = (User)session.getAttribute("user"); 
        String username = user.getUsername();
        // Reload user from DB
        user = new UserDAO().getUser(username);
        session.setAttribute("user", user);

        if(user.isAdmin()) username += " *";
        String balance = String.format("%.2f", user.getBalance());
        out += "<p>As: " + username + " (kr. " + balance + ")</p>";
        return out;
    }
%>

<%!
    private String showCart(ArrayList<LineItem> cart){
        String out = "";
        if(cart == null || cart.isEmpty()) return out;
        out += "<form action='Buy' method='GET'>";
        out += "<table>";
        for(LineItem item : cart){
            out += "<tr>";
                out += "<td>"+item.getQty()+"</td>";
                out += "<td> x </td>";
                out += "<td>"+item.getCupcake().getName()+"</td>";
                out += "<td> á kr. </td>";
                double price = item.getCupcake().getPrice();
                out += "<td>"+String.format("%.2f", price)+"</td>";
                out += "<td> = kr. </td>";
                double total = item.getQty() * item.getCupcake().getPrice();
                out += "<td>"+String.format("%.2f", total)+"</td>";
            out += "<tr>";
        }
        if(!cart.isEmpty()){
            out += "<tr>";
                out += "<td><input type='submit' name='dothis' value='Finish'/></td>";
            out += "<tr>";
        }
        out += "</table>";
        out += "</form>";
        return out;
    }
%>

<%!
    private String showCupcakes(){
        String out = "";
        CupcakeDAO dao = new CupcakeDAO();
        ArrayList<Cupcake> cupcakes = dao.getCupcakes();

        out += "<table>";
        for(Cupcake c : cupcakes){
            out += "<form action='Buy'>";
                out += "<tr>";
                    out += "<td>"+c.getId()+"</td>";
                    out += "<td><strong>"+c.getName()+"</strong><br>";
                    out += c.getTop()+" on "+c.getBase()+"</td>";
                    out += "<td> kr."+String.format("%.2f",c.getPrice())+"</td>";
                    out += "<td><input type='submit' name='dothis' Value='Add'/></td>";
                    out += "<input type='hidden' name='cupcake_id' value='"+c.getId()+"'";
                out += "</tr>";
            out += "</form>";
        }
        out += "</table>";
        return out;
    }
%>