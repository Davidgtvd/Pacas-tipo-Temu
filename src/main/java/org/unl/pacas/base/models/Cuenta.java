package org.unl.pacas.base.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String usuario;
    
    @Column(nullable = false, length = 255)
    private String contrasena;
    
    @Column(nullable = false)
    private Boolean activo = true;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "ultimo_acceso")
    private LocalDateTime ultimoAcceso;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    // Constructores
    public Cuenta() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Cuenta(String usuario, String contrasena, Rol rol, Persona persona) {
        this();
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.persona = persona;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Cuenta{id=" + id + ", usuario='" + usuario + "', activo=" + activo + 
               ", rol=" + (rol != null ? rol.getNombre() : "null") + "}";
    }
}