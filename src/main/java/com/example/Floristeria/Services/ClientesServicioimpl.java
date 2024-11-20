package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Clientes;
import com.example.Floristeria.Repository.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServicioimpl implements ClientesServicio {

    @Autowired
    private ClientesRepositorio clientesRepositorio;

    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepositorio.findAll();
    }

    @Override
    public Optional<Clientes> getClienteById(Long id) {
        return clientesRepositorio.findById(id);
    }

    @Override
    public Clientes saveCliente(Clientes cliente) {
        return clientesRepositorio.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clientesRepositorio.deleteById(id);
    }

    @Override
    public Clientes updateCliente(Long id, Clientes cliente) {
        cliente.setId(id);
        return clientesRepositorio.save(cliente);
    }
    @Override

    public List<Clientes> getClientesWithPedidosOrderedByFecha() {

        return clientesRepositorio.findAllClientesWithPedidosOrderedByFecha();

    }


    @Override

    public List<Clientes> getClientesWithPedidosAndDetallesOrderedByPrecio() {

        return clientesRepositorio.findAllClientesWithPedidosAndDetallesOrderedByPrecio();

    }


    @Override

    public Long getCantidadComprasPorCliente(Long clienteId) {

        return clientesRepositorio.countPedidosByClienteId(clienteId);

    }
}
