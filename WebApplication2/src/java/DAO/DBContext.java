/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {

            String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    private final String serverName = "localhost";
    private final String dbName = "pttk";
    private final String portNumber = "3306";
    private final String instance = "";
    private final String userID = "root";
    private final String password = "g08022002";
}
