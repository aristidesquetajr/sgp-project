package com.sgp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sgp.conexao.Conexao;
import com.sgp.model.Funcionario;
import com.sgp.model.Pessoa;
import com.sgp.model.Utilizador;

public class UtilizadorDAO extends Conexao {

    public Utilizador getAccess(Utilizador user) {
        String sql = "CALL login(?, ?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            ResultSet result = stmt.executeQuery();
            Utilizador utilizador = new Utilizador();
            utilizador.setLogado(0);
            while (result.first()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(result.getInt("idPessoa"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setEmail(result.getString("email"));
                pessoa.setGenero(result.getString("genero"));
                /* pessoa.setNascimento(result.getDate("nascimento")); */

                Funcionario funcionario = new Funcionario();
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setFkPessoa(pessoa);

                utilizador.setFkFuncionario(funcionario);
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
