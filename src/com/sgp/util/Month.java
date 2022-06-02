package com.sgp.util;

public class Month {
    
    private String month;
    private Boolean multa;

    public Month(String month, Boolean multa) {
        this.month = month;
        this.multa = multa;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Boolean getMulta() {
        return multa;
    }

    public void setMulta(Boolean multa) {
        this.multa = multa;
    }
    
}
