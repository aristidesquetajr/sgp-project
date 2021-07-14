package com.sgp.dao;

import com.sgp.beans.Curso;
import com.sgp.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    private final Conexao conexao;
    private final Connection conn;
    private String sql;
    private PreparedStatement stmt;

    public CursoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConnection();
    }

    public void createdCurso(Curso curso) {
        this.sql = "INSERT INTO Curso (curso) VALUES (?)";
        try {
            this.stmt = this.conn.prepareStatement(this.sql);
            this.stmt.setString(1, curso.getCurso());
            this.stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do curso: " + e.getMessage());
        }
    }

    public List<Curso> getCursos() {
        this.sql = "SELECT * FROM Curso ORDER BY curso";
        try {
            this.stmt = this.conn.prepareStatement(this.sql);
            ResultSet res = this.stmt.executeQuery();

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
