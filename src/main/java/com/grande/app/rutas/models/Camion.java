package com.grande.app.rutas.models;

import com.grande.app.rutas.models.enums.Marcas;
import com.grande.app.rutas.models.enums.Tipos;

public class Camion {
    private Long id;
    private String matricula;
    private Tipos tipoCamion;
    private Integer modelo;
    private Marcas marca;
    private Integer capacidad;
    private Double kilometro;
    private Boolean disponibilidad;

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKilometro() {
        return kilometro;
    }

    public void setKilometro(Double kilometro) {
        this.kilometro = kilometro;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Tipos getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(Tipos tipoCamion) {
        this.tipoCamion = tipoCamion;
    }
}
