package org.unl.pacas.base.dao_models;

public enum TipoTransaccion {
    COMPRA("Compra"),
    VENTA("Venta"),
    AJUSTE_ENTRADA("Ajuste de Entrada"),
    AJUSTE_SALIDA("Ajuste de Salida"),
    DEVOLUCION_COMPRA("Devolución de Compra"),
    DEVOLUCION_VENTA("Devolución de Venta");

    private final String descripcion;

    TipoTransaccion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}