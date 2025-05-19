package org.unl.pacas.base.models;

import java.util.Date;

public class Notificacion {
    private Integer id;
    private String mensaje;
    private Date fecha;
    private Boolean leida;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getLeida() {
        return this.leida;
    }

    public void setLeida(Boolean leida) {
        this.leida = leida;
    }
    
}
