package org.unl.pacas.base.controller.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.unl.pacas.base.controller.dao.dao_models.DaoNotificacion;
import org.unl.pacas.base.models.Notificacion;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed
public class NotificacionService {
    private DaoNotificacion db;

    public NotificacionService() {
        db = new DaoNotificacion();
    }

    public void createNotificacion(@NotEmpty String mensaje, @NotEmpty Date fecha, @NotEmpty String leida) throws Exception {
        if(mensaje.trim().length() > 0) {
            db.getObj().setMensaje(mensaje);
            db.getObj().setFecha(fecha);
            db.getObj().setLeida(Boolean.parseBoolean(leida));
            if(!db.save()) {
                throw new Exception("No se pudo guardar la notificación");
            }
        }
    }

   /* public void updateNotificacion(Integer id, @NotEmpty String mensaje, @NotEmpty Date fecha, @NotEmpty String leida) throws Exception {
        if(id != null && id > 0) {
            db.setObj(db.listAll().get(id - 1));
            db.getObj().setMensaje(mensaje);
            db.getObj().setFecha(fecha);
            db.getObj().setLeida(Boolean.parseBoolean(leida));
            if(!db.update(id - 1)) {
                throw new Exception("No se pudo editar datso de la notificación");
            }
        }
    }*/

    public List<Notificacion> listAllNotificaciones() {
        return Arrays.asList(db.listAll().toArray());
    }

    public List<HashMap> listNotificaciones() {
        List<HashMap> lista = new ArrayList<>();
        if(!db.listAll().isEmpty()) {
            Notificacion[] arreglo = db.listAll().toArray();
            for(int i = 0; i < arreglo.length; i++) {
                HashMap<String, String> aux = new HashMap<>();
                aux.put("id", arreglo[i].getId().toString());
                aux.put("mensaje", arreglo[i].getMensaje());
                aux.put("fecha", arreglo[i].getFecha().toString());
                aux.put("leida", arreglo[i].getLeida().toString());
                lista.add(aux);
            }
        }
        return lista;
    }
}
