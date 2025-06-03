package org.unl.pacas.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unl.pacas.base.dao.RolRepository;
import org.unl.pacas.base.models.Rol;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }
    
    public Optional<Rol> findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
    
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
    
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return rolRepository.existsByNombre(nombre);
    }
    
    public Rol createDefaultRoles() {
        if (!existsByNombre("ADMIN")) {
            Rol admin = new Rol("ADMIN", "Administrador del sistema");
            save(admin);
        }
        if (!existsByNombre("CLIENTE")) {
            Rol cliente = new Rol("CLIENTE", "Cliente del sistema");
            return save(cliente);
        }
        return findByNombre("CLIENTE").orElse(null);
    }
}