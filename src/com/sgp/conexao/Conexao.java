package com.sgp.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
    
    private final String host;
    private final String user;
    private final String pass;
    
    public String sql;
    public PreparedStatement stmt;
    public ResultSet res;
    
    public Conexao() {
        this.host = "jdbc:mysql://localhost:3306/gesp";
        this.user = "root";
        this.pass = "KASHIKI";
    }
    
    public Connection getConnection() {
        try {
            return (Connection) DriverManager.getConnection(this.host, this.user, this.pass);
        } catch (SQLException e) {
            System.out.println("Erro na conexao " + e.getMessage());
            return null;
        }
    }
}
