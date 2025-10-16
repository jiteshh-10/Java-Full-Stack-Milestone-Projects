package TM14AJAX;
import java.sql.*;

public class UserDAO {
    // IMPORTANT: Update these values
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUname = "your_username";
    private String dbPassword = "your_password";

    private Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(dbUrl, dbUname, dbPassword);
    }

    public boolean emailExists(String email) {
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement("SELECT 1 FROM XYZ_PROFILE WHERE Email = ?")) {
            ps.setString(1, email);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }

    public boolean registerUser(String email, String password, String name, String dob) {
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement("INSERT INTO XYZ_PROFILE VALUES (?, ?, ?, ?)")) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setDate(4, Date.valueOf(dob));
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }

    public boolean validateLogin(String email, String password) {
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement("SELECT 1 FROM XYZ_PROFILE WHERE Email = ? AND Password = ?")) {
            ps.setString(1, email);
            ps.setString(2, password);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }
}
