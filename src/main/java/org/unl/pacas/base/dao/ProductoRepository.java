package org.unl.pacas.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unl.pacas.base.dao_models.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByActivoTrue();
    
    List<Producto> findByNombreContainingIgnoreCaseAndActivoTrue(String nombre);
    
    List<Producto> findByCategoriaAndActivoTrue(String categoria);
    
    @Query("SELECT p FROM Producto p WHERE p.stock <= p.stockMinimo AND p.activo = true")
    List<Producto> findProductosConStockBajo();
    
    @Query("SELECT p FROM Producto p WHERE p.stock = 0 AND p.activo = true")
    List<Producto> findProductosSinStock();
    
    @Query("SELECT DISTINCT p.categoria FROM Producto p WHERE p.activo = true ORDER BY p.categoria")
    List<String> findAllCategorias();
    
    @Query("SELECT COUNT(p) FROM Producto p WHERE p.activo = true")
    Long countProductosActivos();
    
    @Query("SELECT SUM(p.stock * p.precioCompra) FROM Producto p WHERE p.activo = true")
    Double calcularValorInventarioCompra();
    
    @Query("SELECT SUM(p.stock * p.precioVenta) FROM Producto p WHERE p.activo = true")
    Double calcularValorInventarioVenta();
}