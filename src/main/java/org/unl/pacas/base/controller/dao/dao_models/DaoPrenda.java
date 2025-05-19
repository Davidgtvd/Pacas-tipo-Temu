package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Prenda;
import java.util.ArrayList;
import java.util.List;

public class DaoPrenda {
    private final List<Prenda> prendas = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Prenda prenda) {
        prenda.setId(nextId++);
        prendas.add(prenda);
        return true;
    }

    public List<Prenda> listAll() {
        return new ArrayList<>(prendas);
    }
}