package org.unl.pacas.base.models;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class HistorialEstadoPedido {
    private Integer id;
    private Integer usuarioId;
    private LocalDateTime fechaCreacion;
    private String estado;
    private BigDecimal total;
    private String direccionEntrega;
    private String metodoPago;

    public HistorialEstadoPedido() {}

    public HistorialEstadoPedido(Integer id, Integer usuarioId, LocalDateTime fechaCreacion, String estado, 
                BigDecimal total, String direccionEntrega, String metodoPago) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.total = total;
        this.direccionEntrega = direccionEntrega;
        this.metodoPago = metodoPago;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}