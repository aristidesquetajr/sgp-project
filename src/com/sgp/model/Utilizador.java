package com.sgp.model;

public class Utilizador extends Funcionario {
    private String username;
    private String password;
    private int logado;

    public Utilizador() {
    }
    
    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
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
