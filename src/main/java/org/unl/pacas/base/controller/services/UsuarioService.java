package org.unl.pacas.base.controller.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.unl.pacas.base.controller.dao.dao_models.DaoUsuario;
import org.unl.pacas.base.models.Usuario;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed
public class UsuarioService {
    private DaoUsuario db;

    public UsuarioService() {
        db = new DaoUsuario();
    }

    public void createUsuario(@NotEmpty String nombre, @NotEmpty String contrasena,  @NotEmpty String telefono) throws Exception {
        if(nombre.trim().length() > 0 && contrasena.trim().length() > 0 && telefono.trim().length() > 0) {
            db.getObj().setNombre(nombre);
            db.getObj().setContrasena(contrasena);
            db.getObj().setTelefono(telefono);

            if(!db.save()) {
                throw new Exception("No se pudo guardar los datos de usuario");
            }
        }
    }

    public void updateUsuario(Integer id, @NotEmpty String nombre, @NotEmpty String contrasena,  @NotEmpty String telefono) throws Exception {
        if(id != null && id > 0) {
            db.setObj(db.listAll().get(id - 1));
            db.getObj().setNombre(nombre);
            db.getObj().setContrasena(contrasena);
            db.getObj().setTelefono(telefono);
            if(!db.update(id - 1)) {
                throw new Exception("No se pudo actualizar el usuario");
            }
        }
    }

    public List<Usuario> listAllUsuarios() {
        return Arrays.asList(db.listAll().toArray());
    }

    public List<HashMap> listUsuarios() {
        List<HashMap> lista = new ArrayList<>();
        if(!db.listAll().isEmpty()) {
            Usuario[] arreglo = db.listAll().toArray();
            for(int i = 0; i < arreglo.length; i++) {
                HashMap<String, String> aux = new HashMap<>();
                aux.put("id", arreglo[i].getId().toString());
                aux.put("nombre", arreglo[i].getNombre());
                aux.put("contrasena", arreglo[i].getContrasena());
                aux.put("telefono", arreglo[i].getTelefono());
                lista.add(aux);
            }
        }
        return lista;
    }
}
