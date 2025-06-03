package org.unl.pacas.base.dao_models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransaccion tipo;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precioUnitario;

    @Column(nullable = false)
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPago metodoPago;

    @Column(length = 500)
    private String observaciones;

    @Column(nullable = false)
    private String numeroComprobante;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false)
    private String usuario = "sistema";

    // Constructores
    public Transaccion() {}

    public Transaccion(Producto producto, TipoTransaccion tipo, Integer cantidad, 
                      Double precioUnitario, MetodoPago metodoPago) {
        this.producto = producto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = cantidad * precioUnitario;
        this.metodoPago = metodoPago;
        this.numeroComprobante = generarNumeroComprobante();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public TipoTransaccion getTipo() { return tipo; }
    public void setTipo(TipoTransaccion tipo) { this.tipo = tipo; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { 
        this.cantidad = cantidad;
        if (this.precioUnitario != null) {
            this.total = cantidad * this.precioUnitario;
        }
    }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Double precioUnitario) { 
        this.precioUnitario = precioUnitario;
        if (this.cantidad != null) {
            this.total = this.cantidad * precioUnitario;
        }
    }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getNumeroComprobante() { return numeroComprobante; }
    public void setNumeroComprobante(String numeroComprobante) { this.numeroComprobante = numeroComprobante; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    // Métodos de utilidad
    private String generarNumeroComprobante() {
        return tipo.name() + "-" + System.currentTimeMillis();
    }

    @PrePersist
    public void prePersist() {
        if (this.numeroComprobante == null) {
            this.numeroComprobante = generarNumeroComprobante();
        }
        if (this.total == null && this.cantidad != null && this.precioUnitario != null) {
            this.total = this.cantidad * this.precioUnitario;
        }
    }
}