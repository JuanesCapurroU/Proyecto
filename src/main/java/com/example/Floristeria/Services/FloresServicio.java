package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Flores;

import java.util.List;
import java.util.Optional;

public interface FloresServicio {
    List<Flores> getAllFlores();
    Optional<Flores> getFlorById(Long id);
    Flores saveFlor(Flores flor);
    void deleteFlor(Long id);
    Flores updateFlor(Long id, Flores flor);
    List<Object[]> getTotalPrecioPorCategoria();
}
