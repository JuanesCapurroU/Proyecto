package com.example.Floristeria.Controllers;

import com.example.Floristeria.Models.Clientes;
import com.example.Floristeria.Services.ClientesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesControlador {

    @Autowired
    private ClientesServicio clientesServicio;

    // Obtener un Cliente por su ID
    @GetMapping("/{id}")
    public Optional<Clientes> getClienteById(@PathVariable Long id) {
        return clientesServicio.getClienteById(id);
    }

    // Obtener todos los Clientes
    @GetMapping("/todos")
    public List<Clientes> getAllClientes() {
        return clientesServicio.getAllClientes();
    }

    // Crear un Cliente
    @PostMapping("/guardar")
    public ResponseEntity<String> saveCliente(@RequestBody Clientes cliente) {
        Clientes savedCliente = clientesServicio.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente registrado con éxito. ID: " + savedCliente.getId());
    }

    // Eliminar Cliente por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clientesServicio.deleteCliente(id);
    }

    // Obtener clientes con pedidos, ordenados por fecha de pedido
    @GetMapping("/pedidos/ordenadosPorFecha")
    public List<Clientes> getClientesWithPedidosOrderedByFecha() {
        return clientesServicio.getClientesWithPedidosOrderedByFecha();
    }

    // Obtener clientes con pedidos y detalles, ordenados por precio de menor a mayor
    @GetMapping("/pedidosDetalles/ordenadosPorPrecio")
    public List<Clientes> getClientesWithPedidosAndDetallesOrderedByPrecio() {
        return clientesServicio.getClientesWithPedidosAndDetallesOrderedByPrecio();
    }

    // Obtener cantidad de compras realizadas por cada cliente
    @GetMapping("/clientes/{clienteId}/compras")
    public Long getCantidadComprasPorCliente(@PathVariable Long clienteId) {
        return clientesServicio.getCantidadComprasPorCliente(clienteId);
    }
}
