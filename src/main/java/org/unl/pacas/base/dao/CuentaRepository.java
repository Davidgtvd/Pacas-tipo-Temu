package org.unl.pacas.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unl.pacas.base.models.Cuenta;
import org.unl.pacas.base.models.Rol;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    
    Optional<Cuenta> findByUsuario(String usuario);
    
    Optional<Cuenta> findByPersonaId(Long personaId);
    
    boolean existsByUsuario(String usuario);
    
    List<Cuenta> findByActivo(Boolean activo);
    
    List<Cuenta> findByRol(Rol rol);
    
    @Query("SELECT c FROM Cuenta c WHERE c.usuario = :usuario AND c.contrasena = :contrasena AND c.activo = true")
    Optional<Cuenta> findByUsuarioAndContrasenaAndActivoTrue(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
    
    @Query("SELECT c FROM Cuenta c JOIN c.persona p WHERE LOWER(p.nombres) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Cuenta> findByPersonaNombre(@Param("nombre") String nombre);
}