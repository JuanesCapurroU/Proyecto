package com.example.Floristeria.Controllers;


import com.example.Floristeria.Models.Pedidos;
import com.example.Floristeria.Services.PedidosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidosControlador {

    @Autowired
    private PedidosServicio pedidosServicio;

    // Obtener un Pedido por su ID
    @GetMapping("/{id}")
    public Optional<Pedidos> getPedidoById(@PathVariable Long id) {
        return pedidosServicio.getPedidoById(id);
    }

    // Obtener todos los Pedidos
    @GetMapping("/todos")
    public List<Pedidos> getAllPedidos() {
        return pedidosServicio.getAllPedidos();
    }

    // Crear un Pedido
    @PostMapping("/guardar")
    public ResponseEntity<String> savePedido(@RequestBody Pedidos pedido) {
        Pedidos savedPedido = pedidosServicio.savePedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pedido registrado con éxito. ID: " + savedPedido.getId());
    }

    // Eliminar Pedido por ID
    @DeleteMapping("/eliminar/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidosServicio.deletePedido(id);
    }

    // Obtener toda la información de las tablas, organizada por fecha del pedido
    @GetMapping("/pedidos/ordenadosPorFecha")
    public List<Pedidos> getAllPedidosOrderedByFecha() {
        return pedidosServicio.getAllPedidosOrderedByFecha();

    }

    // Obtener toda la información de las tablas, ordenada por fecha del pedido
    @GetMapping("/todaLaInformacion")
    public ResponseEntity<List<Object[]>> getAllInformation() {
        List<Object[]> result = pedidosServicio.getAllInformationOrderedByFecha();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}