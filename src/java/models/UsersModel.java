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
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
        }
        return user;
    }

    public static User findByEmail(String email) throws SQLException, ClassNotFoundException {
        User user = null;
        PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                "SELECT * FROM users WHERE email = ?");
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        System.out.println(pstmt);
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
        }

        return user;
    }

    public static User findByUsername(String username) throws SQLException, ClassNotFoundException {
        User user = null;
        PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                "SELECT * FROM users WHERE username = ?");
        pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
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
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
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
        }

        return user;
    }

    public static User save(User user) throws SQLException, ClassNotFoundException {
        String sql = "";
        if (user.getId() > 0) {
            sql = "UPDATE users set name = ?, email = ?, sex = ?, username = ?, password = ? WHERE id = ?;";
        } else {
            sql = "INSERT INTO users (name, email, sex, username, password ) VALUES(?, ?, ?, ?, SHA1(?));";
        }

        PreparedStatement pstmt = Conn.getConnection().prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getSex());
        pstmt.setString(4, user.getUsername());
        pstmt.setString(5, user.getPassword());
        if (user.getId() > 0) {
            pstmt.setLong(6, user.getId());
        }

        int id = pstmt.executeUpdate();
        if (id > 0) {
            user.setId(Long.parseLong(String.valueOf(id)));
        }

        return user;
    }
}
