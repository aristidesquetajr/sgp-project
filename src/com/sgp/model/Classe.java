package com.sgp.model;

public class Classe extends Curso {
    private int idClasse;
    private String classe;
    private Turma fkTurma;
    private int sala;

    public int getIdClasse() {
        return this.idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Turma getFkTurma() {
        return fkTurma;
    }

    public void setFkTurma(Turma fkTurma) {
        this.fkTurma = fkTurma;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return this.classe;
    }
    

}
