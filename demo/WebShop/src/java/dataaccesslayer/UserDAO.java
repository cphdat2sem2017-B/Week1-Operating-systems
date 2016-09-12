package dataaccesslayer;

import dbconnector.Connector;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM user");
            while (res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                double balance = res.getDouble("balance");
                boolean isAdmin = res.getBoolean("isadmin");
                users.add(new User(username, password, balance, isAdmin));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User getUser(String username) {
        User user = null;
        try {
            Connector c = new Connector();
            ResultSet res = c.doQuery("SELECT * FROM user WHERE username = '" + username+"'");
            if (res.next()) {
                String password = res.getString("password");
                double balance = res.getDouble("balance");
                boolean isAdmin = res.getBoolean("isadmin");
                user = new User(username, password, balance, isAdmin);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public void withdraw(User customer, double total) {
        String username = customer.getUsername();
        double balance = customer.getBalance() - total;
        try {
            Connector c = new Connector();
            c.doUpdate("UPDATE user SET balance='"+balance+"' WHERE username='"+username+"';");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
