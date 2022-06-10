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
            stmt.setString(1, aluno.getFkPessoa().getNome());
            stmt.setString(2, aluno.getFkPessoa().getEmail());
            stmt.setString(3, aluno.getFkPessoa().getGenero());
            stmt.setDate(4, aluno.getFkPessoa().getNascimento());
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
            res = stmt.executeQuery();
            Pessoa pessoa = new Pessoa();
            while (res.first()) {
                pessoa.setIdPessoa(res.getInt("IdPessoa"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setEmail(res.getString("email"));
                pessoa.setGenero(res.getString("genero"));
                pessoa.setNascimento(res.getDate("nascimento"));
            }
            
            return pessoa;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
