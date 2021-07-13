package com.sgp.model;

public class Funcionario {
    private Pessoa fkPessoa;
    private String cargo;

    public Pessoa getFkPessoa() {
        return this.fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
