package com.fletes.myapprecyclerviewvo;

public class DatosVO {
    private String nombreRestaurante;
    private String calidadRestaurante;
    private Integer imagenRestaurante;

    public DatosVO() {
    }

    public DatosVO(String nombreRestaurante, String calidadRestaurante, Integer imagenRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
        this.calidadRestaurante = calidadRestaurante;
        this.imagenRestaurante = imagenRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getCalidadRestaurante() {
        return calidadRestaurante;
    }

    public void setCalidadRestaurante(String calidadRestaurante) {
        this.calidadRestaurante = calidadRestaurante;
    }

    public Integer getImagenRestaurante() {
        return imagenRestaurante;
    }

    public void setImagenRestaurante(Integer imagenRestaurante) {
        this.imagenRestaurante = imagenRestaurante;
    }
}