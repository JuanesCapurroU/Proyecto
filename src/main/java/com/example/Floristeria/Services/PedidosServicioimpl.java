package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Pedidos;
import com.example.Floristeria.Repository.PedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosServicioimpl implements PedidosServicio {

    @Autowired
    private PedidosRepositorio pedidosRepositorio;

    @Override
    public List<Pedidos> getAllPedidos() {
        return pedidosRepositorio.findAll();
    }

    @Override
    public Optional<Pedidos> getPedidoById(Long id) {
        return pedidosRepositorio.findById(id);
    }

    @Override
    public Pedidos savePedido(Pedidos pedido) {
        return pedidosRepositorio.save(pedido);
    }

    @Override
    public void deletePedido(Long id) {
        pedidosRepositorio.deleteById(id);
    }

    @Override
    public Pedidos updatePedido(Long id, Pedidos pedido) {
        pedido.setId(id);

        return pedidosRepositorio.save(pedido);
    }
    @Override

    public List<Pedidos> getAllPedidosOrderedByFecha() {
        return pedidosRepositorio.findAllOrderedByFecha();

    }
    @Override
    public List<Object[]> getAllInformationOrderedByFecha() {
        return pedidosRepositorio.findAllInformationOrderedByFecha();
    }
}
