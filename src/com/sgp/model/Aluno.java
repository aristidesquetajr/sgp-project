package com.sgp.model;

public class Aluno {
    private Pessoa fkPessoa;
    private Classe fkClasse;
    private int numAluno;
    private int codAluno;

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

    public int getNumAluno() {
        return numAluno;
    }

    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }  

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int numProcesso) {
        this.codAluno = numProcesso;
    }
}
