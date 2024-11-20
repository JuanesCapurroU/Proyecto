package com.example.Floristeria.Services;

import com.example.Floristeria.Models.DetallesPedidos;
import com.example.Floristeria.Repository.DetallesPedidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesPedidosServicioimpl implements DetallesPedidosServicio {

    @Autowired
    private DetallesPedidosRepositorio detallesPedidosRepositorio;

    @Override
    public List<DetallesPedidos> getAllDetallesPedidos() {
        return detallesPedidosRepositorio.findAll();
    }

    @Override
    public Optional<DetallesPedidos> getDetallePedidoById(Long id) {
        return detallesPedidosRepositorio.findById(id);
    }

    @Override
    public DetallesPedidos saveDetallePedido(DetallesPedidos detallePedido) {
        return detallesPedidosRepositorio.save(detallePedido);
    }

    @Override
    public void deleteDetallePedido(Long id) {
        detallesPedidosRepositorio.deleteById(id);
    }

    @Override
    public DetallesPedidos updateDetallePedido(Long id, DetallesPedidos detallePedido) {
        detallePedido.setId(id);
        return detallesPedidosRepositorio.save(detallePedido);
    }
}
