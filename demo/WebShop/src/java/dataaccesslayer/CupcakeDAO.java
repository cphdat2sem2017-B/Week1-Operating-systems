package dataaccesslayer;

import dbconnector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cupcake;

public class CupcakeDAO {
    
    public ArrayList<Cupcake> getCupcakes(){
        ArrayList<Cupcake> cupcakes = new ArrayList<>();
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM cupcake NATURAL JOIN base NATURAL JOIN top;");
            while (res.next()) {
                int id = res.getInt("cupcake_id");
                String name = res.getString("cupcake_name");
                String base = res.getString("base_name");
                String top = res.getString("top_name");
                double price = res.getDouble("price");
                cupcakes.add(new Cupcake(id, name, base, top, price));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return cupcakes;
    }
    
    public Cupcake getCupcake(int id){
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM cupcake NATURAL JOIN base NATURAL JOIN top WHERE cupcake_id = '"+id+"'");
            if (res.next()) {
                String name = res.getString("cupcake_name");
                String base = res.getString("base_name");
                String top = res.getString("top_name");
                double price = res.getDouble("price");
                return new Cupcake(id, name, base, top, price);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Cupcake getCupcake(String name){
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM cupcake NATURAL JOIN base NATURAL JOIN top WHERE cupcake_name = '"+name+"'");
            if (res.next()) {
                int id = res.getInt("cupcake_id");
                String base = res.getString("base_name");
                String top = res.getString("top_name");
                double price = res.getDouble("price");
                return new Cupcake(id, name, base, top, price);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
