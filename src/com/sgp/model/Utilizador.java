package com.sgp.model;

public class Utilizador {
    private Funcionario fkFuncionario;
    private String username;
    private String password;
    private int logado;

    public Funcionario getFkFuncionario() {
        return this.fkFuncionario;
    }

    
    public void setFkFuncionario(Funcionario fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }
    
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getLogado() {
        return logado;
    }
    
    public void setLogado(int logado) {
        this.logado = logado;
    }
    
}
