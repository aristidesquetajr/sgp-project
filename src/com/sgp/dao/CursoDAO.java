package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.model.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO  extends Conexao {

    public CursoDAO() {
    }

    public void createdCurso(Curso curso) {
        sql = "INSERT INTO Curso (curso) VALUES (?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do curso: " + e.getMessage());
        }
    }

    public List<Curso> getCursos() {
        sql = "SELECT * FROM Curso ORDER BY curso";
        try {
            stmt = getConnection().prepareStatement(sql);
            res = stmt.executeQuery();

            List<Curso> listCursos = new ArrayList<>();
            while (res.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(res.getInt("idCurso"));
                curso.setCurso(res.getString("curso"));
                listCursos.add(curso);
            }

            return listCursos;
        } catch (SQLException e) {
            System.out.println("Erro na obtençao dos dados: " + e.getMessage());
            return null;
        }
    }
}
