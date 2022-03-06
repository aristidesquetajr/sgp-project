package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.beans.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilizadorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public UtilizadorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConnection();
    }
    
    public boolean getAccess(Utilizador user) {
        try{
            String sql = "SELECT * FROM Utilizador WHERE username = ? AND password = md5(?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet result = stmt.executeQuery();
            
            return result.first();
        }catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }
}
