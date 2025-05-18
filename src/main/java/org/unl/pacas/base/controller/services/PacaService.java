package org.unl.pacas.base.controller.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.unl.pacas.base.controller.dao.dao_models.DaoPaca;
import org.unl.pacas.base.models.Paca;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@BrowserCallable
@AnonymousAllowed
public class PacaService {
    private final DaoPaca daoPaca = new DaoPaca();

    public HashMap<String, String> save(String nombre, String descripcion) {
        Paca paca = new Paca();
        paca.setNombre(nombre);
        paca.setDescripcion(descripcion);
        daoPaca.save(paca);

        HashMap<String, String> result = new HashMap<>();
        result.put("id", paca.getId().toString());
        result.put("nombre", paca.getNombre());
        result.put("descripcion", paca.getDescripcion());
        return result;
    }

    public List<HashMap<String, String>> listaPacas() {
        return daoPaca.listAll().stream().map(paca -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", paca.getId().toString());
            map.put("nombre", paca.getNombre());
            map.put("descripcion", paca.getDescripcion());
            return map;
        }).collect(Collectors.toList());
    }
}