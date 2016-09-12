<%-- 
    Document   : invoice
    Created on : Feb 15, 2016, 5:11:15 PM
    Author     : Ronnie Dalsgaard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.LineItem, model.Invoice" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice page</title>
    </head>
    <body>
        <h2>Invoice:</h2>
        <% 
            ArrayList<LineItem> lineItems;
            Invoice inv = (model.Invoice)request.getAttribute( "invoice" );
            if( inv != null ){
                lineItems = inv.getItems(); 
                out.print("<table>");
                for(LineItem item : lineItems){
                    out.print("<tr>");
                        out.print("<td>"+item.getQty()+"</td>");
                        out.print("<td> x </td>");
                        out.print("<td>"+item.getCupcake().getName()+"</td>");
                        out.print("<td> á kr. </td>");
                        double price = item.getCupcake().getPrice();
                        out.print("<td>"+String.format("%.2f", price)+"</td>");
                        out.print("<td> = kr. </td>");
                        double total = item.getQty() * item.getCupcake().getPrice();
                        out.print("<td>"+String.format("%.2f", total)+"</td>");
                    out.print("<tr>");
                }
                out.print("</table>");
                out.println( "<P>Total: " + inv.getTotal() + "</p>");
            }
            else {
                out.println("<p><em>Empty shopping cart</em></p>");
            }
        %>
        <a href="shop.jsp">Go to shop</a>
        <a href="login.jsp">Go to login</a>
    </body>
</html>
