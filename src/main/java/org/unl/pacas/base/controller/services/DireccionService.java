package org.unl.pacas.base.controller.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.unl.pacas.base.controller.dao.dao_models.DaoDireccion;
import org.unl.pacas.base.models.Direccion;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed
public class DireccionService {
    private DaoDireccion db;

    public DireccionService() {
        db = new DaoDireccion();
    }

    public void createDireccion(@NotEmpty String calle, @NotEmpty String ciudad, @NotEmpty String estado, @NotEmpty String codigoPostal) throws Exception {
        if(calle.trim().length() > 0 && ciudad.trim().length() > 0) {
            db.getObj().setCalle(calle);
            db.getObj().setCiudad(ciudad);
            db.getObj().setEstado(estado);
            db.getObj().setCodigoPostal(codigoPostal);
            if(!db.save()) {
                throw new Exception("No se pudo guardar los datos de la dirección");
            }
        }
    }

    public void updateDireccion(Integer id, @NotEmpty String calle, @NotEmpty String ciudad, @NotEmpty String estado, @NotEmpty String codigoPostal) throws Exception {
        if(id != null && id > 0) {
            db.setObj(db.listAll().get(id - 1));
            db.getObj().setCalle(calle);
            db.getObj().setCiudad(ciudad);
            db.getObj().setEstado(estado);
            db.getObj().setCodigoPostal(codigoPostal);
            if(!db.update(id - 1)) {
                throw new Exception("No se pudo actualizar la dirección");
            }
        }
    }

    public List<Direccion> listAllDirecciones() {
        return Arrays.asList(db.listAll().toArray());
    }

    public List<HashMap> listDirecciones() {
        List<HashMap> lista = new ArrayList<>();
        if(!db.listAll().isEmpty()) {
            Direccion[] arreglo = db.listAll().toArray();
            for(int i = 0; i < arreglo.length; i++) {
                HashMap<String, String> aux = new HashMap<>();
                aux.put("id", arreglo[i].getId().toString());
                aux.put("calle", arreglo[i].getCalle());
                aux.put("ciudad", arreglo[i].getCiudad());
                aux.put("estado", arreglo[i].getEstado());
                aux.put("codigoPostal", arreglo[i].getCodigoPostal());
                lista.add(aux);
            }
        }
        return lista;
    }
}
