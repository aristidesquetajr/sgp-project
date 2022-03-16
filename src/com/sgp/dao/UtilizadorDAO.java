package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sgp.beans.Utilizador;
import com.sgp.conexao.Conexao;

public class UtilizadorDAO extends Conexao {
        
    public boolean getAccess(Utilizador user) {
        String sql = "SELECT * FROM Pessoa AS pes " +
            "INNER JOIN Funcionario AS fun ON (pes.idPessoa = fun.fkPessoa) " +
            "INNER JOIN Utilizador AS uti ON (fun.idFuncionario = uti.fkFuncionario) " +
            "WHERE uti.username = ? AND uti.password = md5(?)";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql);
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
