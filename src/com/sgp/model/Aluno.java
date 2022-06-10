package com.sgp.model;

public class Aluno {
    private Pessoa fkPessoa;
    private Classe fkClasse;
    private int numAluno;
    private int codAluno;
    private String anoLetivo;
    private String status;
    
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

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
