package org.unl.pacas.base.controller.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AdapterDao<T> {
    protected String tableName;

    public AdapterDao(String tableName) {
        this.tableName = tableName;
    }

    // Método para mapear un ResultSet a una entidad
    protected abstract T mapResultSetToEntity(java.sql.ResultSet rs) throws SQLException;

    // Método para obtener una conexión (debes implementar la lógica real según tu proyecto)
    protected Connection getConnection() throws SQLException {
        // Aquí deberías retornar una conexión real a tu base de datos
        throw new UnsupportedOperationException("Implementa la obtención de la conexión a la base de datos.");
    }
}