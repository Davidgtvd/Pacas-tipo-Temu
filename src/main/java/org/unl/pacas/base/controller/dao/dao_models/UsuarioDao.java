package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.models.Usuario;
import java.util.ArrayList;
import java.util.List;




public class UsuarioDao {
    private final List<Usuario> usuarios = new ArrayList<>();
    private int nextId = 1;

    public boolean save(Usuario usuario) {
        usuario.setId(nextId++);
        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> listAll() {
        return java.util.Collections.emptyList();
    }
}

