package models;

import java.sql.*;
import java.util.*;
import models.bean.User;

/**
 *
 * @author davi
 */
public class UsersModel {
    
    public static User find(long id){
        User user = null;
        try{
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * @return
     * @throws SQLException 
     */
    public static ArrayList<User> findAll() {
        try {
            ArrayList<User> users = null;
            PreparedStatement pstmt = Conn.getConnection().prepareStatement(
                    "SELECT * FROM users");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                users = new ArrayList<User>();
                do {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("nome"));
                    user.setEmail(rs.getString("email"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setSex(rs.getString("sex"));

                    users.add(user);
                } while (rs.next());
            }else{
                System.out.print("nenhum usuário encontrado");
            }
            rs.close();
            pstmt.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
