package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Sesion;
import java.util.ArrayList;
import java.util.List;

public class SesionDao {
    private final List<Sesion> sesiones = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Sesion sesion) {
        sesion.setId(nextId++);
        sesiones.add(sesion);
        return true;
    }

    public List<Sesion> listAll() {
        return new ArrayList<>(sesiones);
    }
}
