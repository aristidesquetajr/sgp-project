package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sgp.beans.Pessoa;
import com.sgp.conexao.Conexao;

public class PessoaDAO extends Conexao {
    
    public Boolean cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa (nome, email, genero, nascimento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getGenero());
            stmt.setString(4, pessoa.getNascimento());
            return stmt.execute() ? false : true;
        } catch(SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
        return false;
    }
    
    public Pessoa searchPessoa(String fullName) {
        String sql = "SELECT * FROM Pessoa WHERE nome = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, fullName);
            ResultSet res = stmt.executeQuery();
            Pessoa pessoa = new Pessoa();
            while (res.first()) {
                pessoa.setIdPessoa(res.getInt("IdPessoa"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setEmail(res.getString("email"));
                pessoa.setGenero(res.getString("genero"));
                pessoa.setNascimento(res.getString("nascimento"));
            }
            
            return pessoa;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
