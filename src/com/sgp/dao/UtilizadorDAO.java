package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sgp.conexao.Conexao;
import com.sgp.model.Utilizador;

public class UtilizadorDAO extends Conexao {
        
    public boolean getAccess(Utilizador user) {
        String sql = "CALL login(?, ?)";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet result = stmt.executeQuery();
            return result.first();
        }catch(SQLException e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return false;
    }
}
