package org.unl.pacas.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.unl.pacas.base.dao_models.Transaccion;
import org.unl.pacas.base.dao_models.TipoTransaccion;
import org.unl.pacas.base.dao_models.MetodoPago;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    
    List<Transaccion> findByProductoIdOrderByFechaDesc(Long productoId);
    
    List<Transaccion> findByTipoOrderByFechaDesc(TipoTransaccion tipo);
    
    List<Transaccion> findByMetodoPagoOrderByFechaDesc(MetodoPago metodoPago);
    
    List<Transaccion> findByFechaBetweenOrderByFechaDesc(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    @Query("SELECT t FROM Transaccion t WHERE t.fecha >= :fechaInicio AND t.fecha <= :fechaFin AND t.tipo = :tipo ORDER BY t.fecha DESC")
    List<Transaccion> findByFechaAndTipo(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                        @Param("fechaFin") LocalDateTime fechaFin, 
                                        @Param("tipo") TipoTransaccion tipo);
    
    @Query("SELECT SUM(t.total) FROM Transaccion t WHERE t.tipo = :tipo AND t.fecha >= :fechaInicio AND t.fecha <= :fechaFin")
    Double calcularTotalPorTipoYFecha(@Param("tipo") TipoTransaccion tipo, 
                                     @Param("fechaInicio") LocalDateTime fechaInicio, 
                                     @Param("fechaFin") LocalDateTime fechaFin);
    
    @Query("SELECT SUM(t.total) FROM Transaccion t WHERE t.tipo = 'VENTA' AND t.fecha >= :fechaInicio AND t.fecha <= :fechaFin")
    Double calcularVentasEnPeriodo(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                  @Param("fechaFin") LocalDateTime fechaFin);
    
    @Query("SELECT SUM(t.total) FROM Transaccion t WHERE t.tipo = 'COMPRA' AND t.fecha >= :fechaInicio AND t.fecha <= :fechaFin")
    Double calcularComprasEnPeriodo(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                   @Param("fechaFin") LocalDateTime fechaFin);
    
    @Query("SELECT COUNT(t) FROM Transaccion t WHERE t.tipo = 'VENTA' AND DATE(t.fecha) = CURRENT_DATE")
    Long contarVentasHoy();
    
    @Query("SELECT SUM(t.total) FROM Transaccion t WHERE t.tipo = 'VENTA' AND DATE(t.fecha) = CURRENT_DATE")
    Double calcularVentasHoy();
}