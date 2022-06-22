package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO extends Conexao {
    
    
    public void createdClasse(Classe classe) {
        sql = "INSERT INTO Classe (curso) VALUES (?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, classe.getClasse());
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do curso: " + e.getMessage());
        }
    }
    
    public int gerarID(String curso, String classe) {
        sql = "SELECT * FROM Classe as cla LEFT JOIN Curso as cur on (cla.fkCurso = cur.idCurso) "
            + "WHERE cur.curso = ? AND cla.classe = ? LIMIT 1";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, curso);
            stmt.setString(2, classe);
            resultSet = stmt.executeQuery();
            resultSet.first();
            return resultSet.getInt("idClasse");
        } catch (Exception e) {
            System.out.println("Erro ao gerar ID " + e.getMessage());
        }
        return -1;
    }
    
    public List<Classe> getClasses() {
        sql = "SELECT DISTINCT(classe) FROM Classe";
        try {
            stmt = getConnection().prepareStatement(sql);
            resultSet = stmt.executeQuery();
            List<Classe> listClasse = new ArrayList<>();
            while(resultSet.next()) {
                Classe classe = new Classe();
                classe.setClasse(resultSet.getString("classe"));
                listClasse.add(classe);
            }
            return listClasse;
        } catch (SQLException e) {
            System.out.println("Erro nao retornou os valores: " + e.getMessage());
        }
        return null;
    }
    
    public List<Classe> getCursos(Curso curso) {
        sql = "SELECT * FROM Curso AS cu INNER JOIN Classe AS cla ON(cu.idCurso = cla.fkCurso) WHERE cu.idCurso = 1;";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            resultSet = stmt.executeQuery();
            
            List<Classe> listCursos = new ArrayList<>();
            while(resultSet.next()) {
                Classe classe = new Classe();
                classe.setIdCurso(resultSet.getInt("idCurso"));
                classe.setCurso(resultSet.getString("curso"));
                classe.setIdClasse(resultSet.getInt("idClasse"));
                classe.setSala(resultSet.getInt("sala"));
                
                listCursos.add(classe);
            }
            
            return listCursos;
        } catch (SQLException e) {
            System.out.println("Error ");
            return null;
        }
    }
}
