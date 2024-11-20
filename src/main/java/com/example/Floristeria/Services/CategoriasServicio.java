package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Categorias;

import java.util.List;
import java.util.Optional;

public interface CategoriasServicio {

    List<Categorias> getAllCategorias();
    Optional<Categorias> getCategoriaById(Long id);
    Categorias saveCategoria(Categorias categoria);
    void deleteCategoria(Long id);
    Categorias updateCategoria(Long id, Categorias categoria);

}
