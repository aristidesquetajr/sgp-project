package com.sgp.dao;

import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import com.sgp.model.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends PessoaDAO {

    @Override
    public Boolean cadastrar(Aluno aluno) {
        if (super.cadastrar(aluno)) {
            if(checkUpLastId(aluno)) {
                if (cadastrarAluno(aluno)) {
                    System.out.println("Sucesso!");
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkUpLastId(Aluno aluno) {
        sql = "SELECT * FROM Pessoa ORDER BY idPessoa desc LIMIT 1";
        try {
            stmt = getConnection().prepareStatement(sql);
            resultSet = stmt.executeQuery();
            resultSet.first();
            aluno.setIdPessoa(resultSet.getInt("idPessoa"));
            System.out.println(aluno.getIdPessoa() + " <<");
            return true;
        } catch (Exception e) {
            System.out.println("Erro no check up: " + e.getMessage());
        }
        return false;
    }

    private boolean cadastrarAluno(Aluno aluno) {
        sql = "INSERT INTO Aluno (fkPessoa, fkClasse, numAluno,"
            + " codAluno, anoLetivo, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, aluno.getIdPessoa());
            stmt.setInt(2, aluno.getFkClasse().getIdClasse());
            stmt.setInt(3, aluno.getNumAluno());
            stmt.setInt(4, aluno.getCodAluno());
            stmt.setString(5, "2021-2022"); // tem de ser codificado
            stmt.setString(6, "ativo"); // default
            
            return !stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do aluno: " + e.getMessage());
        }
        return false;
    }

    public List<Aluno> showAlunos() {
        sql = "CALL showAlunos";
        try {
            this.stmt = getConnection().prepareStatement(sql);
            resultSet = stmt.executeQuery();

            List<Aluno> listAlunos = new ArrayList<>();
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdPessoa(resultSet.getInt("idPessoa"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setEmail(resultSet.getString("email"));
                aluno.setGenero(resultSet.getString("genero"));

                Turma turma = new Turma();
                turma.setIdTurma(resultSet.getInt("idTurma"));
                turma.setTurma(resultSet.getString("turma"));

                Classe classe = new Classe();
                classe.setIdCurso(resultSet.getInt("idCurso"));
                classe.setCurso(resultSet.getString("curso"));
                classe.setIdClasse(resultSet.getInt("idClasse"));
                classe.setClasse(resultSet.getString("classe"));
                classe.setSala(resultSet.getInt("sala"));
                classe.setFkTurma(turma);

                aluno.setFkClasse(classe);
                aluno.setNumAluno(resultSet.getInt("numAluno"));
                aluno.setCodAluno(resultSet.getInt("codAluno"));
                aluno.setAnoLetivo(resultSet.getString("anoLetivo"));
                aluno.setStatus(resultSet.getString("status"));

                listAlunos.add(aluno);
            }
            return listAlunos;
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    public List<Aluno> findAlunosByName(String n) {
        sql = "CALL findAlunosByName(?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, "%" + n + "%");
            resultSet = stmt.executeQuery();

            List<Aluno> listAlunos = new ArrayList<>();
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdPessoa(resultSet.getInt("idPessoa"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setEmail(resultSet.getString("email"));
                aluno.setGenero(resultSet.getString("genero"));

                Turma turma = new Turma();
                turma.setIdTurma(resultSet.getInt("idTurma"));
                turma.setTurma(resultSet.getString("turma"));

                Classe classe = new Classe();
                classe.setIdCurso(resultSet.getInt("idCurso"));
                classe.setCurso(resultSet.getString("curso"));
                classe.setIdClasse(resultSet.getInt("idClasse"));
                classe.setClasse(resultSet.getString("classe"));
                classe.setSala(resultSet.getInt("sala"));
                classe.setFkTurma(turma);

                aluno.setFkClasse(classe);
                aluno.setNumAluno(resultSet.getInt("numAluno"));
                aluno.setCodAluno(resultSet.getInt("codAluno"));
                aluno.setAnoLetivo(resultSet.getString("anoLetivo"));
                aluno.setStatus(resultSet.getString("status"));

                listAlunos.add(aluno);
            }
            return listAlunos;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

}
