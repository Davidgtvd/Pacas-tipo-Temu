package org.unl.pacas.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unl.pacas.base.models.Persona;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    Optional<Persona> findByEmail(String email);
    
    Optional<Persona> findByIdentificacion(String identificacion);
    
    boolean existsByEmail(String email);
    
    boolean existsByIdentificacion(String identificacion);
    
    @Query("SELECT p FROM Persona p WHERE LOWER(p.nombres) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Persona> findByNombresOrApellidosContainingIgnoreCase(@Param("nombre") String nombre);
    
    @Query("SELECT p FROM Persona p WHERE p.cuenta IS NULL")
    List<Persona> findPersonasSinCuenta();
}