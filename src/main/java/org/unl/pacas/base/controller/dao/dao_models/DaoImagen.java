package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Imagen;
import java.util.ArrayList;
import java.util.List;

public class DaoImagen {
    private final List<Imagen> imagenes = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Imagen imagen) {
        imagen.setId(nextId++);
        imagenes.add(imagen);
        return true;
    }

    public List<Imagen> listAll() {
        return new ArrayList<>(imagenes);
    }
}