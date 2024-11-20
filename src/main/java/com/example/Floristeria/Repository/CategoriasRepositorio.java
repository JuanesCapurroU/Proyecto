package com.example.Floristeria.Repository;

import com.example.Floristeria.Models.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categorias, Long> {
}
