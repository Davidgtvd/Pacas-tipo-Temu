package org.unl.pacas.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unl.pacas.base.dao.CuentaRepository;
import org.unl.pacas.base.models.Cuenta;
import org.unl.pacas.base.models.Rol;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }
    
    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }
    
    public Optional<Cuenta> findByUsuario(String usuario) {
        return cuentaRepository.findByUsuario(usuario);
    }
    
    public Optional<Cuenta> findByPersonaId(Long personaId) {
        return cuentaRepository.findByPersonaId(personaId);
    }
    
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
    
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
    
    public boolean existsByUsuario(String usuario) {
        return cuentaRepository.existsByUsuario(usuario);
    }
    
    public List<Cuenta> findByActivo(Boolean activo) {
        return cuentaRepository.findByActivo(activo);
    }
    
    public List<Cuenta> findByRol(Rol rol) {
        return cuentaRepository.findByRol(rol);
    }
    
    public Optional<Cuenta> login(String usuario, String contrasena) {
        return cuentaRepository.findByUsuarioAndContrasenaAndActivoTrue(usuario, contrasena);
    }
    
    public void actualizarUltimoAcceso(Long cuentaId) {
        Optional<Cuenta> cuenta = findById(cuentaId);
        if (cuenta.isPresent()) {
            cuenta.get().setUltimoAcceso(LocalDateTime.now());
            save(cuenta.get());
        }
    }
    
    public List<Cuenta> buscarPorNombrePersona(String nombre) {
        return cuentaRepository.findByPersonaNombre(nombre);
    }
}