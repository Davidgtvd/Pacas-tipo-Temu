package org.unl.pacas.base.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unl.pacas.base.models.Rol;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    
    Optional<Rol> findByNombre(String nombre);
    
    boolean existsByNombre(String nombre);
    
    @Query("SELECT r FROM Rol r WHERE LOWER(r.nombre) = LOWER(:nombre)")
    Optional<Rol> findByNombreIgnoreCase(@Param("nombre") String nombre);
}