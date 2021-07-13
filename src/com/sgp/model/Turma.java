package com.sgp.model;

public class Turma {
    private int idTurma;
    private String turma;

    public int getIdTurma() {
        return idTurma;
    }
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return this.turma;
    }
}
