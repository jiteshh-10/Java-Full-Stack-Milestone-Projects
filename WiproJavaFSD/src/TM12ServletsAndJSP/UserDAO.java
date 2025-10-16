package TM12ServletsAndJSP;

import java.sql.*;

public class UserDAO {
    // IMPORTANT: Update these values for your database
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUname = "your_username";
    private String dbPassword = "your_password";

    private Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(dbUrl, dbUname, dbPassword);
    }

    public boolean validate(String username, String password) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            return ps.executeQuery().next();
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean addUser(String username, String password) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, password);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        if (!validate(username, oldPassword)) return false;
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {
            ps.setString(1, newPassword);
            ps.setString(2, username);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }
}
