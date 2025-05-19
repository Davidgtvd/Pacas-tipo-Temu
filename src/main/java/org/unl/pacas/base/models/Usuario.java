package org.unl.pacas.base.models;

public class Usuario {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String nombre;
    private String rol;
    private boolean activo;

    public Usuario() {
        this.activo = true;
    }

    public Usuario(Integer id, String username, String password, String email, String nombre, String rol, boolean activo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.rol = rol;
        this.activo = activo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}