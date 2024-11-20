package com.example.Floristeria.Controllers;

import com.example.Floristeria.Models.Categorias;
import com.example.Floristeria.Services.CategoriasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasControlador {

    @Autowired
    private CategoriasServicio categoriasServicio;

    // Obtener una Categoría por su ID
    @GetMapping("/{id}")
    public Optional<Categorias> getCategoriaById(@PathVariable Long id) {
        return categoriasServicio.getCategoriaById(id);
    }

    // Obtener todas las Categorías
    @GetMapping("/todas")
    public List<Categorias> getAllCategorias() {
        return categoriasServicio.getAllCategorias();
    }

    // Crear una Categoría
    @PostMapping("/guardar")
    public ResponseEntity<String> saveCategoria(@RequestBody Categorias categoria) {
        Categorias savedCategoria = categoriasServicio.saveCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Categoría registrada con éxito. ID: " + savedCategoria.getId());
    }



    // Eliminar Categoría por ID
    @DeleteMapping("/eliminar/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriasServicio.deleteCategoria(id);
    }
}
