package com.fletes.myappcine;

public class PeliculaVO {
    //Variables
    private Integer imgPeli;
    private Integer nombrePeli;
    private Integer duracionPeli;
    private Integer sinopsisPeli;
    private Integer directorPeli;
    private Integer repartoPeli;
    private Integer puntuacionPeli;
    private Integer recaudacionPeli;

    //Constructores
    public PeliculaVO() {
    }

    public PeliculaVO(Integer imgPeli, Integer nombrePeli, Integer duracionPeli) {
        this.imgPeli = imgPeli;
        this.nombrePeli = nombrePeli;
        this.duracionPeli = duracionPeli;
    }

    public PeliculaVO(Integer sinopsisPeli, Integer directorPeli, Integer repartoPeli, Integer puntuacionPeli, Integer recaudacionPeli) {
        this.sinopsisPeli = sinopsisPeli;
        this.directorPeli = directorPeli;
        this.repartoPeli = repartoPeli;
        this.puntuacionPeli = puntuacionPeli;
        this.recaudacionPeli = recaudacionPeli;
    }

    public PeliculaVO(Integer imgPeli, Integer nombrePeli, Integer duracionPeli, Integer sinopsisPeli, Integer directorPeli, Integer repartoPeli, Integer puntuacionPeli, Integer recaudacionPeli) {
        this.imgPeli = imgPeli;
        this.nombrePeli = nombrePeli;
        this.duracionPeli = duracionPeli;
        this.sinopsisPeli = sinopsisPeli;
        this.directorPeli = directorPeli;
        this.repartoPeli = repartoPeli;
        this.puntuacionPeli = puntuacionPeli;
        this.recaudacionPeli = recaudacionPeli;
    }

    //Getter & Setter
    public Integer getImgPeli() {
        return imgPeli;
    }

    public void setImgPeli(Integer imgPeli) {
        this.imgPeli = imgPeli;
    }

    public Integer getNombrePeli() {
        return nombrePeli;
    }

    public void setNombrePeli(Integer nombrePeli) {
        this.nombrePeli = nombrePeli;
    }

    public Integer getDuracionPeli() {
        return duracionPeli;
    }

    public void setDuracionPeli(Integer duracionPeli) {
        this.duracionPeli = duracionPeli;
    }

    public Integer getSinopsisPeli() {
        return sinopsisPeli;
    }

    public void setSinopsisPeli(Integer sinopsisPeli) {
        this.sinopsisPeli = sinopsisPeli;
    }

    public Integer getDirectorPeli() {
        return directorPeli;
    }

    public void setDirectorPeli(Integer directorPeli) {
        this.directorPeli = directorPeli;
    }

    public Integer getRepartoPeli() {
        return repartoPeli;
    }

    public void setRepartoPeli(Integer repartoPeli) {
        this.repartoPeli = repartoPeli;
    }

    public Integer getPuntuacionPeli() {
        return puntuacionPeli;
    }

    public void setPuntuacionPeli(Integer puntuacionPeli) {
        this.puntuacionPeli = puntuacionPeli;
    }

    public Integer getRecaudacionPeli() {
        return recaudacionPeli;
    }

    public void setRecaudacionPeli(Integer recaudacionPeli) {
        this.recaudacionPeli = recaudacionPeli;
    }
}