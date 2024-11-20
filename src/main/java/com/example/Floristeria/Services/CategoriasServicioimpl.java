package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Categorias;
import com.example.Floristeria.Repository.CategoriasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasServicioimpl implements CategoriasServicio {

    @Autowired
    private CategoriasRepositorio categoriasRepositorio;

    @Override
    public List<Categorias> getAllCategorias() {
        return categoriasRepositorio.findAll();
    }

    @Override
    public Optional<Categorias> getCategoriaById(Long id) {
        return categoriasRepositorio.findById(id);
    }

    @Override
    public Categorias saveCategoria(Categorias categoria) {
        return categoriasRepositorio.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriasRepositorio.deleteById(id);
    }

    @Override
    public Categorias updateCategoria(Long id, Categorias categoria) {
        categoria.setId(id);
        return categoriasRepositorio.save(categoria);
    }

}
