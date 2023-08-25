/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.*;

/**
 *
 * @author my
 */
public class Database {
    private Connection conn;
    
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection established");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection not established : " + ex);
        }
        
        String url = "jdbc:mysql://localhost/anggaran_app";
        
        try {
            conn = (Connection) DriverManager.getConnection(url,"root","");
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Connection not establsihed : " + e);
        }
        
        return conn;
    }
    
    public void insertData(Connection conn, String tableName, String[] colName, Object[] values) throws SQLException {
        StringBuilder sbColumns = new StringBuilder();
        StringBuilder sbValues = new StringBuilder();
        
        for (int i = 0; i < colName.length; i++) {
            if (i > 0) {
                sbColumns.append(", ");
                sbValues.append(", ");
            }
            sbColumns.append(colName[i]);
            sbValues.append("?");
        }
        
        String sql = "INSERT INTO " + tableName + " (" + sbColumns.toString() + ") VALUES (" + sbValues.toString() + ")";
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            
            statement.executeUpdate();
        }
    }
    
    public int insertAndGetId(Connection conn, String tableName, String[] colName, Object[] values) throws SQLException {
        StringBuilder sbColumns = new StringBuilder();
        StringBuilder sbValues = new StringBuilder();

        for (int i = 0; i < colName.length; i++) {
            if (i > 0) {
                sbColumns.append(", ");
                sbValues.append(", ");
            }
            sbColumns.append(colName[i]);
            sbValues.append("?");
        }

        String sql = "INSERT INTO " + tableName + " (" + sbColumns.toString() + ") VALUES (" + sbValues.toString() + ")";

        try (PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated ID
                } else {
                    throw new SQLException("Failed to get generated ID.");
                }
            }
        }
    }
    
    public void updateData(Connection conn, String tableName, String[] colName, Object[] values, String condition) throws SQLException {
        StringBuilder sbColumns = new StringBuilder();
        
        for (int i = 0; i < colName.length; i++) {
            if (i > 0) {
                sbColumns.append(", ");
            }
            sbColumns.append(colName[i]).append(" = ?");
        }
        
        String sql = "UPDATE " + tableName + " SET " + sbColumns.toString() + " WHERE " + condition;
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            
            statement.executeUpdate();
        }
    }
    
    public void deleteData(Connection conn, String tableName, String condition) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + condition ;
        System.out.println(sql);
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    } 
}
