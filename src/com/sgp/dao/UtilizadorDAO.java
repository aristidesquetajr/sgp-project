package com.sgp.dao;

import com.sgp.conexao.Conexao;
import com.sgp.model.Utilizador;
import java.sql.SQLException;

public class UtilizadorDAO extends Conexao {

    public Utilizador getAccess(Utilizador user) {
        String sql = "CALL login(?, ?)";
        try {
            stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            resultSet = stmt.executeQuery();
            Utilizador utilizador = new Utilizador();
            utilizador.setLogado(0);
            while (resultSet.first()) {
                utilizador.setIdPessoa(resultSet.getInt("idPessoa"));
                utilizador.setNome(resultSet.getString("nome"));
                utilizador.setEmail(resultSet.getString("email"));
                utilizador.setGenero(resultSet.getString("genero"));
                /* pessoa.setNascimento(result.getDate("nascimento")); */
                utilizador.setCargo(resultSet.getString("cargo"));
                utilizador.setLogado(1);
                break;
            }

            return utilizador;

        } catch (SQLException e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return null;
    }

}
