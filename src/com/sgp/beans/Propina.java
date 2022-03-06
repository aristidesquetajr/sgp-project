package com.sgp.beans;

public class Propina {
    private int idPropina;
    private Aluno fkAluno;
    private Utilizador fkUtilizador;
    private float valor;
    private String dataPagamento;
    
    public int getIdPropina() {
        return idPropina;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setIdPropina(int idPropina) {
        this.idPropina = idPropina;
    }

    public Aluno getFkAluno() {
        return fkAluno;
    }

    public void setFkAluno(Aluno fkAluno) {
        this.fkAluno = fkAluno;
    }

    public Utilizador getFkUtilizador() {
        return fkUtilizador;
    }

    public void setFkUtilizador(Utilizador fkUtilizador) {
        this.fkUtilizador = fkUtilizador;
    }
}
