package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
    private final List<Pedido> pedidos = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Pedido pedido) {
        pedido.setId(nextId++);
        pedidos.add(pedido);
        return true;
    }

    public List<Pedido> listAll() {
        return new ArrayList<>(pedidos);
    }
}