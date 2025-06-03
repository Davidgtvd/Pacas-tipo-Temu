package org.unl.pacas.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unl.pacas.base.dao.TransaccionRepository;
import org.unl.pacas.base.dao_models.Transaccion;
import org.unl.pacas.base.dao_models.TipoTransaccion;
import org.unl.pacas.base.dao_models.MetodoPago;
import org.unl.pacas.base.dao_models.Producto;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private ProductoService productoService;

    public List<Transaccion> findAll() {
        return transaccionRepository.findAll();
    }

    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    public List<Transaccion> findByProductoId(Long productoId) {
        return transaccionRepository.findByProductoIdOrderByFechaDesc(productoId);
    }

    public List<Transaccion> findByTipo(TipoTransaccion tipo) {
        return transaccionRepository.findByTipoOrderByFechaDesc(tipo);
    }

    public List<Transaccion> findByMetodoPago(MetodoPago metodoPago) {
        return transaccionRepository.findByMetodoPagoOrderByFechaDesc(metodoPago);
    }

    public List<Transaccion> findByFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return transaccionRepository.findByFechaBetweenOrderByFechaDesc(fechaInicio, fechaFin);
    }

    public Transaccion save(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion registrarCompra(Long productoId, Integer cantidad, Double precioUnitario, 
                                      MetodoPago metodoPago, String observaciones) {
        Optional<Producto> productoOpt = productoService.findById(productoId);
        if (productoOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado");
        }

        Producto producto = productoOpt.get();
        
        // Crear transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setTipo(TipoTransaccion.COMPRA);
        transaccion.setCantidad(cantidad);
        transaccion.setPrecioUnitario(precioUnitario);
        transaccion.setTotal(cantidad * precioUnitario);
        transaccion.setMetodoPago(metodoPago);
        transaccion.setObservaciones(observaciones);
        transaccion.setFecha(LocalDateTime.now());

        // Actualizar stock
        productoService.incrementarStock(productoId, cantidad);

        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion registrarVenta(Long productoId, Integer cantidad, Double precioUnitario, 
                                     MetodoPago metodoPago, String observaciones) {
        Optional<Producto> productoOpt = productoService.findById(productoId);
        if (productoOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado");
        }

        Producto producto = productoOpt.get();
        
        // Verificar stock disponible
        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente. Disponible: " + producto.getStock());
        }

        // Crear transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setTipo(TipoTransaccion.VENTA);
        transaccion.setCantidad(cantidad);
        transaccion.setPrecioUnitario(precioUnitario);
        transaccion.setTotal(cantidad * precioUnitario);
        transaccion.setMetodoPago(metodoPago);
        transaccion.setObservaciones(observaciones);
        transaccion.setFecha(LocalDateTime.now());

        // Actualizar stock
        productoService.decrementarStock(productoId, cantidad);

        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion registrarAjuste(Long productoId, Integer cantidad, TipoTransaccion tipoAjuste, 
                                      String observaciones) {
        if (tipoAjuste != TipoTransaccion.AJUSTE_ENTRADA && tipoAjuste != TipoTransaccion.AJUSTE_SALIDA) {
            throw new RuntimeException("Tipo de ajuste inválido");
        }

        Optional<Producto> productoOpt = productoService.findById(productoId);
        if (productoOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado");
        }

        Producto producto = productoOpt.get();

        // Crear transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setTipo(tipoAjuste);
        transaccion.setCantidad(cantidad);
        transaccion.setPrecioUnitario(0.0);
        transaccion.setTotal(0.0);
        transaccion.setMetodoPago(MetodoPago.EFECTIVO); // Por defecto para ajustes
        transaccion.setObservaciones(observaciones);
        transaccion.setFecha(LocalDateTime.now());

        // Actualizar stock
        if (tipoAjuste == TipoTransaccion.AJUSTE_ENTRADA) {
            productoService.incrementarStock(productoId, cantidad);
        } else {
            productoService.decrementarStock(productoId, cantidad);
        }

        return transaccionRepository.save(transaccion);
    }

    // Métodos de reportes
    public Double calcularVentasHoy() {
        Double ventas = transaccionRepository.calcularVentasHoy();
        return ventas != null ? ventas : 0.0;
    }

    public Long contarVentasHoy() {
        return transaccionRepository.contarVentasHoy();
    }

    public Double calcularVentasEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDateTime inicio = fechaInicio.atStartOfDay();
        LocalDateTime fin = fechaFin.atTime(23, 59, 59);
        Double ventas = transaccionRepository.calcularTotalPorTipoYFecha(TipoTransaccion.VENTA, inicio, fin);
        return ventas != null ? ventas : 0.0;
    }

    public Double calcularComprasEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        LocalDateTime inicio = fechaInicio.atStartOfDay();
        LocalDateTime fin = fechaFin.atTime(23, 59, 59);
        Double compras = transaccionRepository.calcularTotalPorTipoYFecha(TipoTransaccion.COMPRA, inicio, fin);
        return compras != null ? compras : 0.0;
    }

    public void deleteById(Long id) {
        transaccionRepository.deleteById(id);
    }
}