package org.unl.pacas.base.controller.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.unl.pacas.base.controller.dao.dao_models.DaoPrenda;
import org.unl.pacas.base.models.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@BrowserCallable
@AnonymousAllowed
public class PrendaService {
    private final DaoPrenda daoPrenda = new DaoPrenda();

    public HashMap<String, String> save(String nombre, String descripcion, String talla, String color) {
        Prenda prenda = new Prenda();
        prenda.setNombre(nombre);
        prenda.setDescripcion(descripcion);
        prenda.setTalla(talla);
        prenda.setColor(color);
        daoPrenda.save(prenda);

        HashMap<String, String> result = new HashMap<>();
        result.put("id", prenda.getId().toString());
        result.put("nombre", prenda.getNombre());
        result.put("descripcion", prenda.getDescripcion());
        result.put("talla", prenda.getTalla());
        result.put("color", prenda.getColor());
        return result;
    }

    public List<HashMap<String, String>> listaPrendas() {
        return daoPrenda.listAll().stream().map(prenda -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", prenda.getId().toString());
            map.put("nombre", prenda.getNombre());
            map.put("descripcion", prenda.getDescripcion());
            map.put("talla", prenda.getTalla());
            map.put("color", prenda.getColor());
            return map;
        }).collect(Collectors.toList());
    }
}