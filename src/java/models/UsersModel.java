package models;

import java.sql.*;
import java.util.*;
import models.beans.User;

/**
 *
 * @author davi
 */
public class UsersModel {

    public static User find(long id) throws SQLException, ClassNotFoundException {
        User user = null;
        PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                "SELECT * FROM users");
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            fillObject(rs, user);
        }
        return user;
    }

    /**
     * @return @throws SQLException
     */
    public static ArrayList<User> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = null;
        PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                "SELECT * FROM users");
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            users = new ArrayList<User>();
            do {
                User user = null;
                System.out.println(rs.getString("name"));
                fillObject(rs, user);
                users.add(user);
            } while (rs.next());
        } else {
            System.out.print("nenhum usuário encontrado");
        }
        rs.close();
        pstmt.close();

        return users;

    }

    public static User authenticate(String username, String password) throws SQLException, ClassNotFoundException {
        User user = null;
        PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = SHA1( ? )");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            System.out.println(user.getName());
        }

        return user;
    }

    private static void fillObject(ResultSet rs, User user) throws SQLException {
        user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getString("sex"));
    }
}
