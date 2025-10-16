package TM10HTML.LoginModule.dao;

// In package: com.example.dao
package com.example.dao;

import java.sql.*;
import com.example.bean.User;

public class UserDAO {

    // IMPORTANT: Update these values
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUname = "your_db_username";
    private String dbPassword = "your_db_password";
    private String dbDriver = "oracle.jdbc.driver.OracleDriver";

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean validateUser(String userid, String password) {
        String sql = "SELECT * FROM users WHERE userid = ? AND password = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // True if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getPassword());
            ps.setDate(3, user.getDob());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getState());
            ps.setString(6, user.getContact());
            ps.setString(7, user.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String userid, String oldPassword, String newPassword) {
        // First, validate the old password
        if (!validateUser(userid, oldPassword)) {
            return false; // Old password does not match
        }

        // If old password is correct, update to the new one
        String sql = "UPDATE users SET password = ? WHERE userid = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            ps.setString(2, userid);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}