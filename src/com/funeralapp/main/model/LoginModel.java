
package com.funeralapp.main.model;

import com.funeralapp.database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;
    
    public LoginModel() {
        try {
            this.connection = DbConnection.getConnection();
        } catch (SQLException ex) {
            this.connection = null;
            ex.printStackTrace();
        }
        
        if (this.connection == null) {
           System.exit(1); 
        }
    }
    
    public boolean isDatabaseConnected() {
        return this.connection != null;
    }
    
    public boolean isLoggedIn(String username, String password) throws Exception {

        System.out.println("---------------");
        
        System.out.println("Model username: " + username);
        System.out.println("Model password: " + password);
        System.out.println("Model connection: " + this.connection != null);
        
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        String sql = "SELECT * FROM users";
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            
            System.out.println("---------------");
            return resultSet.next();
        } catch (SQLException ex) {
            System.out.println("Login failed +++++++++++");
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return false;
    }
}
