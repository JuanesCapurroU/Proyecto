package com.example.Floristeria.Services;

import com.example.Floristeria.Models.DetallesPedidos;

import java.util.List;
import java.util.Optional;

public interface DetallesPedidosServicio {
    List<DetallesPedidos> getAllDetallesPedidos();
    Optional<DetallesPedidos> getDetallePedidoById(Long id);
    DetallesPedidos saveDetallePedido(DetallesPedidos detallePedido);
    void deleteDetallePedido(Long id);
    DetallesPedidos updateDetallePedido(Long id, DetallesPedidos detallePedido);
}
