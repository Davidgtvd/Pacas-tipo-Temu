package org.unl.pacas.base.controller.services;

import org.unl.pacas.base.dao.DaoTransferencia;
import org.unl.pacas.base.models.Transferencia;

public class TransferenciaService {
    private DaoTransferencia dao = new DaoTransferencia();

    public String registrarTransferencia(Transferencia t) {
        if (t.getMonto() <= 0) {
            return "Monto debe ser positivo";
        }
        dao.guardar(t);
        return "Transferencia registrada";
    }

    public Transferencia[] obtenerTodas() {
        return dao.listarTodas();
    }
}