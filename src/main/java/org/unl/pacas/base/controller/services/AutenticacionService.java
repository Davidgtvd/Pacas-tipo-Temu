package org.unl.pacas.base.controller.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.unl.pacas.base.controller.dao.dao_models.UsuarioDao;
import org.unl.pacas.base.controller.dao.dao_models.SesionDao;

import java.util.HashMap;
import java.util.List;

@BrowserCallable
@AnonymousAllowed
public class AutenticacionService {
    private final UsuarioDao usuarioDao = new UsuarioDao();
    private final SesionDao sesionDao = new SesionDao();

    public HashMap<String, String> login(String username, String password) {
        HashMap<String, String> result = new HashMap<>();
        // Aquí irá la lógica de login
                return result;
    }
        
    
    
    public HashMap<String, String> registro(String username, String password, String email, String nombre) {
        HashMap<String, String> result = new HashMap<>();
        // Aquí irá la lógica de registro
                return result;
            }
        }