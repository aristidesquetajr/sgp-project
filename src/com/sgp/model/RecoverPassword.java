package com.sgp.model;

public class RecoverPassword {
    private int idRecoverPassword;
    private Utilizador fkUtilizador;
    private String pergunta;
    private Resposta fkResposta;
    
    public int getIdRecoverPassword() {
        return idRecoverPassword;
    }
    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public Resposta getFkResposta() {
        return fkResposta;
    }
    public void setFkResposta(Resposta fkResposta) {
        this.fkResposta = fkResposta;
    }
    public Utilizador getFkUtilizador() {
        return fkUtilizador;
    }
    public void setFkUtilizador(Utilizador fkUtilizador) {
        this.fkUtilizador = fkUtilizador;
    }
    public void setIdRecoverPassword(int idRecoverPassword) {
        this.idRecoverPassword = idRecoverPassword;
    }
    
}
