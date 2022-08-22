package com.fletes.myapprecyclerclickfragmenttraslado;

public class DatosVO {
    //Definimos todas las variables de tipo Integer, ya que se trabajara por medio de la clase @string
    //ya que esta se maneja por medio de recursos
    private Integer imagen;
    private Integer nombre;
    private Integer precio;
    private Integer detalle;
    private Integer especificaciones;

    public DatosVO() {
    }

    public DatosVO(Integer imagen, Integer nombre, Integer precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public DatosVO(Integer detalle, Integer especificaciones) {
        this.detalle = detalle;
        this.especificaciones = especificaciones;
    }

    public DatosVO(Integer imagen, Integer nombre, Integer precio, Integer detalle, Integer especificaciones) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle = detalle;
        this.especificaciones = especificaciones;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getDetalle() {
        return detalle;
    }

    public void setDetalle(Integer detalle) {
        this.detalle = detalle;
    }

    public Integer getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Integer especificaciones) {
        this.especificaciones = especificaciones;
    }
}
