package servlet;

import dataaccesslayer.CupcakeDAO;
import dataaccesslayer.InvoiceDAO;
import dataaccesslayer.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cupcake;
import model.Invoice;
import model.LineItem;
import model.User;

public class Buy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        
        // Cart
        ArrayList<LineItem> cart;
        if(session.getAttribute("cart") == null){
            session.setAttribute("cart", new ArrayList<>());
        }
        cart = (ArrayList<LineItem>)session.getAttribute("cart");
        
        switch(request.getParameter("dothis")){
            case "Add":
                buy(request, response, session, cart);
                break;
            case "Finish":
                finish(request, response, session, cart);
                break;
        }
        
 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/"+path);
        rd.forward(req, res);
    }

    private void buy(HttpServletRequest request, HttpServletResponse response, HttpSession session, 
            ArrayList<LineItem> cart) throws IOException, ServletException {
        
        // Cupcake
        int id = Integer.parseInt(request.getParameter("cupcake_id"));
        CupcakeDAO dao = new CupcakeDAO();
        Cupcake cupcake = dao.getCupcake(id);
        
        
        // LineItem
        LineItem item = null;
        for(LineItem itm : cart){
            if(itm.getCupcake().equals(cupcake)) item = itm;
        }
        if(item == null) {
            item = new LineItem(cupcake, 1);
            cart.add(item);
        }
        else  item.setQty(item.getQty()+1);
        
        forward(request, response, "shop.jsp");
    }

    private void finish(HttpServletRequest request, HttpServletResponse response, HttpSession session, 
            ArrayList<LineItem> cart) throws IOException, ServletException {
        
        User customer = (User)session.getAttribute("user");
        
        InvoiceDAO dao = new InvoiceDAO();
        int id = dao.getNextId();
        double total = 0;
        for(LineItem item : cart){
            total += item.getQty() * item.getCupcake().getPrice();
        }
        Invoice invoice = new Invoice(id, customer, cart, total);
        
        if(total <= customer.getBalance()){
            session.setAttribute("cart", null);
            dao.putInvoice(invoice);
            new UserDAO().withdraw(customer, total);
            request.setAttribute("invoice", invoice);
            forward(request, response, "invoice.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Webshop</title>");            
            out.println("</head><body>");
            out.println("<h1>Not enough funds</h2>");
            out.println("<p><a href='shop.jsp'>Shop</a></p>");
            out.println("</body></html>");
        }
        
        
    }
}
