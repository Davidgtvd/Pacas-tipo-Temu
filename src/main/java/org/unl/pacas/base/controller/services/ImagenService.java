package org.unl.pacas.base.controller.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.unl.pacas.base.controller.dao.dao_models.DaoImagen;
import org.unl.pacas.base.models.Imagen;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@BrowserCallable
@AnonymousAllowed
public class ImagenService {
    private final DaoImagen daoImagen = new DaoImagen();

    public HashMap<String, String> save(String url, String prendaId, String pacaId) {
        Imagen imagen = new Imagen();
        imagen.setUrl(url);
        if (prendaId != null) imagen.setPrendaId(Long.parseLong(prendaId));
        if (pacaId != null) imagen.setPacaId(Long.parseLong(pacaId));
        daoImagen.save(imagen);

        HashMap<String, String> result = new HashMap<>();
        result.put("id", imagen.getId().toString());
        result.put("url", imagen.getUrl());
        result.put("prendaId", imagen.getPrendaId() != null ? imagen.getPrendaId().toString() : "");
        result.put("pacaId", imagen.getPacaId() != null ? imagen.getPacaId().toString() : "");
        return result;
    }

    public List<HashMap<String, String>> listaImagenes() {
        return daoImagen.listAll().stream().map(imagen -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", imagen.getId().toString());
            map.put("url", imagen.getUrl());
            map.put("prendaId", imagen.getPrendaId() != null ? imagen.getPrendaId().toString() : "");
            map.put("pacaId", imagen.getPacaId() != null ? imagen.getPacaId().toString() : "");
            return map;
        }).collect(Collectors.toList());
    }
}