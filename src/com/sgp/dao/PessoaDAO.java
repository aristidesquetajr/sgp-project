package com.sgp.dao;

import com.sgp.beans.Pessoa;
import com.sgp.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {
    private final Conexao conexao;
    private final Connection conn;
    
    public PessoaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConnection();
    }
    
    public Boolean cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa (nome, email, genero, nascimento) values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getGenero());
            stmt.setString(4, pessoa.getNascimento());
            return stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
        return null;
    }
    
    public Pessoa searchPessoa(String fullName) {
        String sql = "SELECT * FROM Pessoa WHERE nome = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
