package com.grande.app.rutas.models;

import java.time.LocalDate;

public class Ruta {
    private Long id;
    private  Long camionid;
    private  Long choferid;
    private Long direccionOrigenid;
    private Long direccionDestinoid;
    private Float distancia;
    private LocalDate fechaSalida;
    private  LocalDate fechaLlegadaEstimada;
    private  LocalDate fechaLlegadaReal;
    private  Integer aTiempo;

    public Integer getaTiempo() {
        return aTiempo;
    }

    public void setaTiempo(Integer aTiempo) {
        this.aTiempo = aTiempo;
    }

    public Long getCamionid() {
        return camionid;
    }

    public void setCamionid(Long camionid) {
        this.camionid = camionid;
    }

    public Long getChoferid() {
        return choferid;
    }

    public void setChoferid(Long choferid) {
        this.choferid = choferid;
    }

    public Long getDireccionDestinoid() {
        return direccionDestinoid;
    }

    public void setDireccionDestinoid(Long direccionDestinoid) {
        this.direccionDestinoid = direccionDestinoid;
    }

    public Long getDireccionOrigenid() {
        return direccionOrigenid;
    }

    public void setDireccionOrigenid(Long direccionOrigenid) {
        this.direccionOrigenid = direccionOrigenid;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public LocalDate getFechaLlegadaEstimada() {
        return fechaLlegadaEstimada;
    }

    public void setFechaLlegadaEstimada(LocalDate fechaLlegadaEstimada) {
        this.fechaLlegadaEstimada = fechaLlegadaEstimada;
    }

    public LocalDate getFechaLlegadaReal() {
        return fechaLlegadaReal;
    }

    public void setFechaLlegadaReal(LocalDate fechaLlegadaReal) {
        this.fechaLlegadaReal = fechaLlegadaReal;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
