package com.sgp.beans;

public class Pagamentos {
    private int idPagamentos;
    private Propina fkPropina;
    private Mensalidade fkMesalidade;
    private int multa;

    public int getIdPagamentos() {
        return idPagamentos;
    }
    public int getMulta() {
        return multa;
    }
    public void setMulta(int multa) {
        this.multa = multa;
    }
    public Mensalidade getFkMesalidade() {
        return fkMesalidade;
    }
    public void setFkMesalidade(Mensalidade fkMesalidade) {
        this.fkMesalidade = fkMesalidade;
    }
    public Propina getFkPropina() {
        return fkPropina;
    }
    public void setFkPropina(Propina fkPropina) {
        this.fkPropina = fkPropina;
    }
    public void setIdPagamentos(int idPagamentos) {
        this.idPagamentos = idPagamentos;
    }
     
}
