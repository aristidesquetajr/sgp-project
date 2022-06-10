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
    
    public List<Classe> getCursos(Curso curso) {
        sql = "SELECT * FROM Curso AS cu INNER JOIN Classe AS cla ON(cu.idCurso = cla.fkCurso) WHERE cu.idCurso = 1;";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            res = stmt.executeQuery();
            
            List<Classe> listCursos = new ArrayList<>();
            while(res.next()) {
                Curso newCurso = new Curso();
                newCurso.setIdCurso(res.getInt("idCurso"));
                newCurso.setCurso(res.getString("curso"));
                
                Classe classe = new Classe();
                classe.setIdClasse(res.getInt("idClasse"));
                classe.setFkCurso(curso);
                classe.setSala(res.getInt("sala"));
                
                
                listCursos.add(classe);
            }
            
            return listCursos;
        } catch (SQLException e) {
            System.out.println("Error ");
            return null;
        }
    }
}
