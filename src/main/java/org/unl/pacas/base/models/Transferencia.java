package org.unl.pacas.base.models;

public class Transferencia {
    private int id;
    private double monto;
    private String estado;

    public Transferencia() {}

    public Transferencia(int id, double monto, String estado) {
        this.id = id;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}