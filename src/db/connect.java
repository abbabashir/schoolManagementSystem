package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    private static final String USERNAME = "abbacodes";
    private static final String PASSWORD = "82206736abba@A1";
    private static final String CONN = "jdbc:mysql://localhost/school";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
