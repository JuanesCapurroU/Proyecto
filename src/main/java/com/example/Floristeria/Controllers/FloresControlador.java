package com.example.Floristeria.Controllers;

import com.example.Floristeria.Models.Flores;
import com.example.Floristeria.Services.FloresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flores")
public class FloresControlador {

    @Autowired
    private FloresServicio floresServicio;

    // Obtener una Flor por su ID
    @GetMapping("/{id}")
    public Optional<Flores> getFlorById(@PathVariable Long id) {
        return floresServicio.getFlorById(id);
    }

    // Obtener todas las Flores
    @GetMapping("/todas")
    public List<Flores> getAllFlores() {
        return floresServicio.getAllFlores();
    }

    // Crear una Flor
    @PostMapping("/guardar")
    public ResponseEntity<String> saveFlor(@RequestBody Flores flor) {
        Flores savedFlor = floresServicio.saveFlor(flor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Flor registrada con éxito. ID: " + savedFlor.getId());
    }


    // Eliminar Flor por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteFlor(@PathVariable Long id) {
        floresServicio.deleteFlor(id);
    }

    // Obtener flores con categorías, organizadas por el total del precio por categoría
    @GetMapping("/flores/categorias/precioTotal")
    public List<Object[]> getTotalPrecioPorCategoria() {
        return floresServicio.getTotalPrecioPorCategoria();

    }
}
