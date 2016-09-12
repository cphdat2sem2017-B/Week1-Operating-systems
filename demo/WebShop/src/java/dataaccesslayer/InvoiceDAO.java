package dataaccesslayer;

import dbconnector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cupcake;
import model.Invoice;
import model.LineItem;
import model.User;

public class InvoiceDAO {
    
    public ArrayList<Invoice> getInvoices(){
        UserDAO userdao = new UserDAO();
        
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT invoice_id, customer_id, SUM(price * qty) AS 'Total' "
                    + "FROM invoice NATURAL JOIN invoice_line NATURAL JOIN cupcake "
                    + "GROUP BY invoice_id;");
            while (res.next()) {
                int invoice_id = res.getInt("invoice_id");
                String customer = res.getString("customer_id");
                User user = userdao.getUser(customer);
                double total = res.getDouble("Total");
                ArrayList<LineItem> items = getItems(invoice_id);
                invoices.add(new Invoice(invoice_id, user, items, total));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return invoices;
    }
    
    public ArrayList<LineItem> getItems(int invoice_id){
        CupcakeDAO cupcakedao = new CupcakeDAO();
        ArrayList<LineItem> items = new ArrayList<>();
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM invoice_line WHERE invoice_id ="+invoice_id+";");
            while (res.next()) {
                int cupcake_id = res.getInt("cupcake_id");
                int qty = res.getInt("qty");
                Cupcake cupcake = cupcakedao.getCupcake(cupcake_id);
                items.add(new LineItem(cupcake, qty));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return items;
    }

    public int getNextId() {
        int nextId = 0;
        for(Invoice invoice : getInvoices()){
            if(invoice.getId() >= nextId)
                nextId = invoice.getId()+1;
        }
        return nextId;
    }

    public void putInvoice(Invoice invoice) {
         try {
            Connector c = new Connector();
            int invoice_id = invoice.getId();
            String customer = invoice.getCustomer().getUsername();
            c.doUpdate("INSERT INTO invoice (invoice_id, customer_id) VALUES ('"+invoice_id+"', '"+customer+"');");
            
            for(LineItem item : invoice.getItems()){
                int cupcake_id = item.getCupcake().getId();
                int qty = item.getQty();
                
                c.doUpdate("INSERT INTO invoice_line (invoice_id, cupcake_id, qty) "
                        + "VALUES ('"+invoice_id+"', '"+cupcake_id+"', '"+qty+"');");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
