package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.model.Aluno;
import com.sgp.model.Pessoa;
import java.sql.SQLException;

public class PessoaDAO extends Conexao {

    
    public Boolean cadastrar(Aluno aluno) {
        String sql = "INSERT INTO Pessoa (nome, email, genero, nascimento) VALUES (?, ?, ?, ?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getGenero());
            stmt.setDate(4, aluno.getNascimento());
            return !stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
        return false;
    }
    
    public Pessoa searchPessoa(String fullName) {
        String sql = "SELECT * FROM Pessoa WHERE nome = ?";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, fullName);
            resultSet = stmt.executeQuery();
            Pessoa pessoa = new Pessoa();
            while (resultSet.first()) {
                pessoa.setIdPessoa(resultSet.getInt("IdPessoa"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setGenero(resultSet.getString("genero"));
                pessoa.setNascimento(resultSet.getDate("nascimento"));
            }
            
            return pessoa;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
