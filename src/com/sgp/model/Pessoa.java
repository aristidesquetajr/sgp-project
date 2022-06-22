package com.sgp.model;

import java.sql.Date;

public class Pessoa {
    private int idPessoa;
    private String nome;
    private String email;
    private String genero;
    private Date nascimento;
    private String telefone;

    public Pessoa() {
    }
    
    public Pessoa(String nome, String email, String genero, Date nascimento) {
        this.nome = nome;
        this.email = email;
        this.genero = genero;
        this.nascimento = nascimento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
