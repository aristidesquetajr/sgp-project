package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import com.sgp.model.Pessoa;
import com.sgp.model.Turma;

public class AlunoDAO extends PessoaDAO {
    private PreparedStatement stmt;
    private String sql;

    public Boolean insertIdAluno() {
        sql = "INSERT INTO (fkPessoa) " +
                "(SELECT idPessoa FROM Pessoa ORDER BY idPessoa DESC LIMIT 1)";
        try {
            stmt = getConnection().prepareStatement(sql);
            return stmt.execute() ? false : true;
        } catch (Exception e) {
            System.out.println("Erro na insercao do ID, " + e.getMessage());
        }
        return false;
    }
        
    public boolean CadastrarAluno(Pessoa pessoa, Aluno aluno, Classe classe) {
        String sql = "UPDATE Aluno set fkClasse = ?, numAluno = ?, codAluno = ? WHERE fkPessoa = ";
        try {
            this.stmt = getConnection().prepareStatement(sql);
            this.stmt.setInt(1, pessoa.getIdPessoa());
            this.stmt.setInt(2, classe.getIdClasse());
            this.stmt.setInt(3, aluno.getNumAluno());
            this.stmt.setInt(4, aluno.getCodAluno());
            return stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
        return false;
    }
    
    public List<Aluno> showAlunos() {
        String sql = "CALL showAlunos";
        try {
            this.stmt = getConnection().prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            List<Aluno> listAlunos = new ArrayList<>();
            while(res.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(res.getInt("idPessoa"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setEmail(res.getString("email"));
                pessoa.setGenero(res.getString("genero"));

                Turma turma = new Turma();
                turma.setIdTurma(res.getInt("idTurma"));
                turma.setTurma(res.getString("turma"));

                Curso curso = new Curso();
                curso.setIdCurso(res.getInt("idCurso"));
                curso.setCurso(res.getString("curso"));

                Classe classe = new Classe();
                classe.setIdClasse(res.getInt("idClasse"));
                classe.setClasse(res.getString("classe"));
                classe.setSala(res.getInt("sala"));
                classe.setFkCurso(curso);
                classe.setFkTurma(turma);
                
                Aluno aluno = new Aluno();
                aluno.setFkPessoa(pessoa);
                aluno.setFkClasse(classe);
                aluno.setNumAluno(res.getInt("numAluno"));
                aluno.setCodAluno(res.getInt("codAluno"));
                aluno.setStatus(res.getString("status"));
                
                listAlunos.add(aluno);
            }
            return listAlunos;
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean cadastrarPessoa(Pessoa pessoa) {
        super.cadastrarPessoa(pessoa);
        
        return false;
    }    
}
