package com.sgp.dao;

import com.sgp.beans.Classe;
import com.sgp.beans.Curso;
import com.sgp.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO {
    private Conexao conexao;
    private Connection conn;
    private String sql;
    private PreparedStatement stmt;
    
    public ClasseDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConnection();
    }
    
    public void createdClasse(Classe classe) {
        this.sql = "INSERT INTO Classe (curso) VALUES (?)";
        try {
            this.stmt = this.conn.prepareStatement(this.sql);
            this.stmt.setInt(1, classe.getClasse());
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do curso: " + e.getMessage());
        }
    }
    
    public List<Classe> getCursos(Curso curso) {
        this.sql = "SELECT * FROM Classe WHERE fkCurso = ?";
        try {
            this.stmt = this.conn.prepareStatement(this.sql);
            this.stmt.setString(1, curso.getCurso());
            ResultSet res = this.stmt.executeQuery();
            
            List<Classe> listCursos = new ArrayList<>();
            while(res.next()) {
                Classe classe = new Classe();
                Curso newCurso = new Curso();
                newCurso.setIdCurso(res.getInt("fkCurso"));
                
                //classe.setCurso(curso.(res.getInt("curso")));
                listCursos.add(classe);
            }
            
            return listCursos;
        } catch (SQLException e) {
            return null;
        }
    }
}
