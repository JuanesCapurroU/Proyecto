package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Clientes;
import com.example.Floristeria.Repository.ClientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ClientesServicio {
    List<Clientes> getAllClientes();
    Optional<Clientes> getClienteById(Long id);
    Clientes saveCliente(Clientes cliente);
    void deleteCliente(Long id);
    Clientes updateCliente(Long id, Clientes cliente);
    List<Clientes> getClientesWithPedidosOrderedByFecha();

    List<Clientes> getClientesWithPedidosAndDetallesOrderedByPrecio();

    Long getCantidadComprasPorCliente(Long clienteId);
}
