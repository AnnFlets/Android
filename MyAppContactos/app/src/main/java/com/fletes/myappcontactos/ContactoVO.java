package com.fletes.myappcontactos;

public class ContactoVO {
    private Integer imagenContacto;
    private String nombreContacto;
    private String numeroContacto;

    public ContactoVO() {
    }

    public ContactoVO(Integer imagenContacto, String nombreContacto, String numeroContacto) {
        this.imagenContacto = imagenContacto;
        this.nombreContacto = nombreContacto;
        this.numeroContacto = numeroContacto;
    }

    public Integer getImagenContacto() {
        return imagenContacto;
    }

    public void setImagenContacto(Integer imagenContacto) {
        this.imagenContacto = imagenContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
}