package com.example.Floristeria.Services;

import com.example.Floristeria.Models.Flores;
import com.example.Floristeria.Repository.FloresRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloresServicioimpl implements FloresServicio {

    @Autowired
    private FloresRepositorio floresRepositorio;

    @Override
    public List<Flores> getAllFlores() {
        return floresRepositorio.findAll();
    }

    @Override
    public Optional<Flores> getFlorById(Long id) {
        return floresRepositorio.findById(id);
    }

    @Override
    public Flores saveFlor(Flores flor) {
        return floresRepositorio.save(flor);
    }

    @Override
    public void deleteFlor(Long id) {
        floresRepositorio.deleteById(id);
    }

    @Override
    public Flores updateFlor(Long id, Flores flor) {
        flor.setId(id);
        return floresRepositorio.save(flor);
    }
    @Override

    public List<Object[]> getTotalPrecioPorCategoria() {

        return floresRepositorio.findTotalPrecioPorCategoria();

    }
}
