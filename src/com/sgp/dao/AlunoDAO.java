package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Pessoa;

public class AlunoDAO extends PessoaDAO {
    private PreparedStatement stmt;
        
    public boolean makeCadastroAluno(Pessoa pessoa, Aluno aluno, Classe classe) {
        String sql = "INSERT INTO Aluno (fkPessoa, fkClasse, numAluno, codAluno) values (?, ?, ?, ?)";
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
                pessoa.setNome(res.getString("nome"));
                
                Classe classe = new Classe();
                classe.setSala(res.getInt("sala"));
                
                Aluno aluno = new Aluno();
                aluno.setFkPessoa(pessoa);
                aluno.setFkClasse(classe);
                aluno.setNumAluno(res.getInt("numEstudante"));
                
                listAlunos.add(aluno);
            }
            return listAlunos;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Boolean cadastrarPessoa(Pessoa pessoa) {
        super.cadastrarPessoa(pessoa);
        
        return false;
    }    
}
