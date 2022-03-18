package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Conexao conexao;
    private Connection conn;
    private PreparedStatement stmt;
    
    public AlunoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConnection();
    }
    
    public boolean cadastro(Pessoa pessoa, Aluno aluno, Classe classe) {
        String sql = "INSERT INTO Aluno (fkPessoa, fkClasse, numEstudante, codAluno) values (?, ?, ?, ?)";
        try {
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, pessoa.getIdPessoa());
            this.stmt.setInt(2, classe.getIdClasse());
            this.stmt.setInt(3, aluno.getNumEstudante());
            this.stmt.setInt(4, aluno.getCodAluno());
            return stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
        return false;
    }
    
    public List<Aluno> mostrarAlunos() {
        String sql = "SELECT alu.numEstudante, pes.nome, cla.sala "
                + "FROM Pessoa AS pes LEFT JOIN Aluno AS alu ON (pes.idPessoa = alu.fkPessoa) "
                + "LEFT JOIN Classe AS cla ON (alu.fkClasse = cla.idClasse) "
                + "ORDER BY cla.sala, alu.numEstudante";
        try {
            this.stmt = this.conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            List<Aluno> listAlunos = new ArrayList<>();
            while(res.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(res.getString("nome"));
                
                Classe classe = new Classe();
                classe.setSala(res.getInt("sala"));
                
                Aluno aluno = new Aluno();
                aluno.setFkPessoa(pessoa);
                aluno.setFkClasse(classe);
                aluno.setNumEstudante(res.getInt("numEstudante"));
                
                listAlunos.add(aluno);
            }
            return listAlunos;
        } catch (SQLException e) {
            return null;
        }
    }    
}
