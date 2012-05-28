package models;

/**
 *
 * @author root
 */
import java.sql.*;

public class Conn {

    private static Connection conn;

    protected static void conectar(String url, String usuario, String senha, String driver) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if(conn == null){
            conectar("jdbc:mysql://localhost/ti_twitter", "root", "root", "com.mysql.jdbc.Driver");
        }
        return conn;
    }

    public static void destroy() {
        try {
            conn = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
