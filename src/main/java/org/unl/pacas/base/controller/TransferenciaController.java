package org.unl.pacas.base.controller;

import org.unl.pacas.base.controller.services.TransferenciaService;
import org.unl.pacas.base.models.Transferencia;

public class TransferenciaController {
    private TransferenciaService service = new TransferenciaService();

    public String agregarTransferencia(int id, double monto, String estado) {
        Transferencia t = new Transferencia(id, monto, estado);
        return service.registrarTransferencia(t);
    }

    public void listarTransferencias() {
        Transferencia[] transferencias = service.obtenerTodas();
        for (Transferencia t : transferencias) {
            System.out.println("ID: " + t.getId() + ", Monto: " + t.getMonto());
        }
    }
}