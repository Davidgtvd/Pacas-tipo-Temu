package org.unl.pacas.base.models;

import java.time.LocalDateTime;

public class Sesion {
    private Integer id;
    private Integer usuarioId;
    private String token;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean activa;

    public Sesion() {
        this.activa = true;
    }

    public Sesion(Integer id, Integer usuarioId, String token, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean activa) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.token = token;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = activa;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}