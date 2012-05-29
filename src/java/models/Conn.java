package models;

/**
 *
 * @author root
 */
import java.sql.*;

public class Conn {

    private static Connection conn;

    protected static void conectar(String url, String usuario, String senha, String driver) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            conectar("jdbc:mysql://localhost/ti_twitter", "root", "root", "com.mysql.jdbc.Driver");
        }
        return conn;
    }

    public static void destroy() throws SQLException {
        conn = null;
    }
}
