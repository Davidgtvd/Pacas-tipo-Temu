package org.unl.pacas.base.dao;

import org.unl.pacas.base.models.Transferencia;

public class DaoTransferencia {
    private Transferencia[] transferencias = new Transferencia[100];
    private int contador = 0;

    public void guardar(Transferencia t) {
        if (contador < transferencias.length) {
            transferencias[contador++] = t;
        }
    }

    public Transferencia buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (transferencias[i].getId() == id) {
                return transferencias[i];
            }
        }
        return null;
    }

    public Transferencia[] listarTodas() {
        Transferencia[] resultado = new Transferencia[contador];
        System.arraycopy(transferencias, 0, resultado, 0, contador);
        return resultado;
    }
}