package com.oops.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DatabaseManager implements DatabaseInterface {
    private Connection conn;

    public DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/userdatamanager";
            String username = "root";
            String password = "4724";

            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertRecord(UUID id, String name, String address, String phone, String zip, String comments) {
        try {
            String sql = "INSERT INTO users(id, name, address, phone, zip, comments) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, id);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, zip);
            statement.setString(6, comments);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRecord(UUID id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<UUID, Map<String, String>> getListOfAllRecords() {
        Map<UUID, Map<String, String>> records = new HashMap<>();
        try {
            String sql = "SELECT id, name, address, phone, zip, comments FROM users";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UUID id = (UUID) resultSet.getObject("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String zip = resultSet.getString("zip");
                String comments = resultSet.getString("comments");

                Map<String, String> record = new HashMap<>();
                record.put("name", name);
                record.put("address", address);
                record.put("phone", phone);
                record.put("zip", zip);
                record.put("comments", comments);

                records.put(id, record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }


    @Override
    public boolean updateRecord(UUID id, Map<String, String> records) {
        try {
            String sql = "UPDATE users SET name=?, address=?, phone=?, zip=?, comments=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, records.get("name"));
            statement.setString(2, records.get("address"));
            statement.setString(3, records.get("phone"));
            statement.setString(4, records.get("zip"));
            statement.setString(5, records.get("comments"));
            statement.setObject(6, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
