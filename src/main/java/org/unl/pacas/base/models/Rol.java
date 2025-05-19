package org.unl.pacas.base.models;

public class Rol {
    private int id;
    private String nombre;

    private int[] usuariosIds = new int[100];

    public void agregarUsuario(int userId) {
        for (int i = 0; i < usuariosIds.length; i++) {
            if (usuariosIds[i] == 0) { // 0 = vacío
                usuariosIds[i] = userId;
                break;
            }
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int[] getUsuariosIds() { return usuariosIds; }
}