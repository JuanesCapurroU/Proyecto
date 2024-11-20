package com.example.Floristeria.Repository;
import com.example.Floristeria.Models.DetallesPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesPedidosRepositorio extends JpaRepository<DetallesPedidos, Long> {

}

