package com.example.Floristeria.Repository;

import com.example.Floristeria.Models.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloresRepositorio extends JpaRepository<Flores, Long> {

    // Consulta 3: Flores con categorías, organizadas por total de precio por categoría
    @Query("SELECT c.nombreCategoria, SUM(f.precio) FROM Flores f JOIN f.categorias c GROUP BY c.id")
    List<Object[]> findTotalPrecioPorCategoria();

}