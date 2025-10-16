package TM809RDBMSSQLJDBC;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    // Scenario 1
    public String getUserType(String userId) {
        String sql = "SELECT UserType FROM Users WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("UserType");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Scenario 2
    public String getIncorrectAttempts(String userId) {
        String sql = "SELECT IncorrectAttempts FROM Users WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int attempts = rs.getInt("IncorrectAttempts");
                    if (attempts == 0) return "No Incorrect Attempt";
                    if (attempts == 1) return "One Time";
                    return "Incorrect Attempt Exceeded";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User not found";
    }

    // Scenario 3
    public String changeUserType(String userId) {
        String sql = "UPDATE Users SET UserType = 'Admin' WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0 ? "Update Success" : "Update Failed";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Update Failed";
    }

    // Scenario 4
    public int getLockStatus() {
        String sql = "SELECT COUNT(*) FROM Users WHERE LockStatus = 0";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Scenario 5
    public String changeName(String id, String newName) {
        String sql = "UPDATE Users SET Name = ? WHERE UserID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setString(2, id);
            return ps.executeUpdate() > 0 ? "Success" : "Failed";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }

    // Scenario 6
    public String changePassword(String newPassword) {
        String sql = "UPDATE Users SET Password = ? WHERE UserType = 'Admin'";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            return ps.executeUpdate() > 0 ? "Changed" : "0";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }

    // Scenario 7
    public String addUser_1(UserBean bean) {
        String sql = "INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bean.getId());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());
            return ps.executeUpdate() > 0 ? "Success" : "Fail";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    // Scenario 8
    public String addUser_2(UserBean bean) {
        if (bean.getLockStatus() != 0) {
            return "Fail"; // Do not insert if lock status is not 0
        }
        // Re-use the logic from addUser_1
        return addUser_1(bean);
    }

    // Scenario 9
    public ArrayList<UserBean> getUsers(String userType) {
        ArrayList<UserBean> userList = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE UserType = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userType);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UserBean user = new UserBean();
                    user.setId(rs.getString("UserID"));
                    user.setPassword(rs.getString("Password"));
                    user.setName(rs.getString("Name"));
                    user.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                    user.setLockStatus(rs.getInt("LockStatus"));
                    user.setUserType(rs.getString("UserType"));
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Scenario 10
    public ArrayList<UserBean> storeAllRecords() {
        ArrayList<UserBean> userList = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setId(rs.getString("UserID"));
                user.setPassword(rs.getString("Password"));
                user.setName(rs.getString("Name"));
                user.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                user.setLockStatus(rs.getInt("LockStatus"));
                user.setUserType(rs.getString("UserType"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Scenario 11
    public String[] getNames() {
        ArrayList<String> names = new ArrayList<>();
        String sql = "SELECT Name FROM Users";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                names.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convert ArrayList to String array
        return names.toArray(new String[0]);
    }
}
