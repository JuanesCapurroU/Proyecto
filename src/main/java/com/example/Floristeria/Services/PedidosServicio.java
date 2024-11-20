package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Pedidos;

import java.util.List;
import java.util.Optional;

public interface PedidosServicio {

    List<Pedidos> getAllPedidos();
    Optional<Pedidos> getPedidoById(Long id);
    Pedidos savePedido(Pedidos pedido);
    void deletePedido(Long id);
    Pedidos updatePedido(Long id, Pedidos pedido);
    List<Pedidos> getAllPedidosOrderedByFecha();
    ;
    public List<Object[]> getAllInformationOrderedByFecha();
}
