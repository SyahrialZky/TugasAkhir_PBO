/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nocompany.tugasakhir_pbo.model;

import nocompany.tugasakhir_pbo.db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Users {
    private int user_id;
    private String username;
    private String password;
    private String email;

    public Users(int user_id, String username, String password, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return user_id;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // get items from database
    public static Users authenticate(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = connection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String dbPassword = rs.getString("password");
                String dbEmail = rs.getString("email");
                return new Users(user_id, username, dbPassword, dbEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}