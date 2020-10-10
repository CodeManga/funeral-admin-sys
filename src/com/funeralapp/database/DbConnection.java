/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funeralapp.database;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbConnection {
    private static final String SQLCONN = "jdbc:sqlite:funeralManagent.sqlite";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection conn = DriverManager.getConnection(SQLCONN);
            JOptionPane.showMessageDialog(null, "Connection Successful");
            return conn;
        } catch (ClassNotFoundException | HeadlessException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
