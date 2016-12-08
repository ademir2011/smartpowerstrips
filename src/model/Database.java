package model;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Database {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/powerstripsdb?useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection open() throws ClassNotFoundException, SQLException  {
        Class.forName(DRIVER);
        Connection connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    
    public static ResultSet query(String query) throws SQLException, ClassNotFoundException{
        String sql = query;
        PreparedStatement stmt = (PreparedStatement) Database.open().prepareStatement(sql);
        ResultSet result = stmt.executeQuery();
        return result;
    }    
    
    public static void update(String query) throws SQLException, ClassNotFoundException{
        String sql = query;
        PreparedStatement stmt = (PreparedStatement) Database.open().prepareStatement(sql);
        stmt.executeUpdate(sql);
    }    
}