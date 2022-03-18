package com.sgp.model;

public class Aluno {
    private int idAluno;
    private Pessoa fkPessoa;
    private Classe fkClasse;
    private int codAluno;
    private int numEstudante;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    public Classe getFkClasse() {
        return fkClasse;
    }

    public void setFkClasse(Classe fkClasse) {
        this.fkClasse = fkClasse;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int numProcesso) {
        this.codAluno = numProcesso;
    }

    public int getNumEstudante() {
        return numEstudante;
    }

    public void setNumEstudante(int numEstudante) {
        this.numEstudante = numEstudante;
    }
}
