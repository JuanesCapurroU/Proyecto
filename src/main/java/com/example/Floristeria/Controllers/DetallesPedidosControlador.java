package com.example.Floristeria.Controllers;


import com.example.Floristeria.Models.DetallesPedidos;
import com.example.Floristeria.Services.DetallesPedidosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detallespedidos")
public class DetallesPedidosControlador {

    @Autowired
    private DetallesPedidosServicio detallesPedidosServicio;

    // Obtener un DetallePedido por su ID
    @GetMapping("/{id}")
    public Optional<DetallesPedidos> getDetallePedidoById(@PathVariable Long id) {
        return detallesPedidosServicio.getDetallePedidoById(id);
    }

    // Obtener todos los DetallesPedidos
    @GetMapping("/todos")
    public List<DetallesPedidos> getAllDetallesPedidos() {
        return detallesPedidosServicio.getAllDetallesPedidos();
    }

    // Crear un DetallePedido
    @PostMapping("/guardar")
    public ResponseEntity<String> saveDetallePedido(@RequestBody DetallesPedidos detallePedido) {
        DetallesPedidos savedDetalle = detallesPedidosServicio.saveDetallePedido(detallePedido);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Detalle del Pedido registrado con éxito. ID: " + savedDetalle.getId());
    }


    // Eliminar DetallePedido por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteDetallePedido(@PathVariable Long id) {
        detallesPedidosServicio.deleteDetallePedido(id);
    }
}
