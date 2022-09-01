package com.fletes.myappsqlite.basededatos;

public class BebidaVO {
    private Integer codBebida;
    private String nombreBebida;
    private String saborBebida;
    private Integer presentacionBebida;
    private String tipoBebida;
    private Double precioBebida;

    public BebidaVO() {
    }

    public BebidaVO(Integer codBebida, String nombreBebida, String saborBebida, Integer presentacionBebida, String tipoBebida, Double precioBebida) {
        this.codBebida = codBebida;
        this.nombreBebida = nombreBebida;
        this.saborBebida = saborBebida;
        this.presentacionBebida = presentacionBebida;
        this.tipoBebida = tipoBebida;
        this.precioBebida = precioBebida;
    }

    public Integer getCodBebida() {
        return codBebida;
    }

    public void setCodBebida(Integer codBebida) {
        this.codBebida = codBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getSaborBebida() {
        return saborBebida;
    }

    public void setSaborBebida(String saborBebida) {
        this.saborBebida = saborBebida;
    }

    public Integer getPresentacionBebida() {
        return presentacionBebida;
    }

    public void setPresentacionBebida(Integer presentacionBebida) {
        this.presentacionBebida = presentacionBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Double precioBebida) {
        this.precioBebida = precioBebida;
    }
}