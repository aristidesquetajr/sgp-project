package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sgp.conexao.Conexao;
import com.sgp.model.Turma;

public class TurmaDAO extends Conexao {
    private String sql;
    private PreparedStatement stmt;

    public Turma searchTurma(int id) {
        sql = "SELECT * FROM Turma WHERE idTurma = ?";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            Turma turma = new Turma();

            while(res.first()) {
                turma.setIdTurma(res.getInt("idTurma"));
                turma.setTurma(res.getString("turma"));
            }
            return turma;
        } catch (Exception e) {
            System.out.println("Error because: " + e.getMessage());
        }
        return null;
    }
}
