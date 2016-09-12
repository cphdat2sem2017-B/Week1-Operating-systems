package dbconnector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    private final String HOST     = "Localhost";
    private final int    PORT     = 3306;
    private final String DATABASE = "cupcakedb";
    private final String USERNAME = "root"; 
    private final String PASSWORD = "root";
    private Connection connection;
    
    public Connector() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
    
    public ResultSet doQuery(String query) throws SQLException{
        System.out.println("*********"+query);
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        return res;
    }
    
    public void doUpdate(String query) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }
}
