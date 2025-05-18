package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Paca;
import java.util.ArrayList;
import java.util.List;

public class DaoPaca {
    private final List<Paca> pacas = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Paca paca) {
        paca.setId(nextId++);
        pacas.add(paca);
        return true;
    }

    public List<Paca> listAll() {
        return new ArrayList<>(pacas);
    }
}