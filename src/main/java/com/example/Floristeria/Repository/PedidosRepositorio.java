package com.example.Floristeria.Repository;

import com.example.Floristeria.Models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepositorio extends JpaRepository<Pedidos, Long> {


    //Consulta 4
    @Query(value = "SELECT c.nombre AS nombre_cliente, p.fecha_pedido, " +
            "(dp.cantidad * dp.precio_unitario) AS precio_total, " +
            "f.nombre AS nombre_flor, cat.nombre_categoria AS nombre_categoria " +
            "FROM clientes c " +
            "INNER JOIN pedidos p ON c.id = p.clientes_id " +
            "INNER JOIN detalles_pedidos dp ON p.id = dp.pedidos_id " +
            "INNER JOIN flores f ON dp.flores_id = f.id " +
            "INNER JOIN categorias cat ON f.categorias_id = cat.id " +
            "ORDER BY p.fecha_pedido DESC", nativeQuery = true)
    List<Object[]> findAllInformationOrderedByFecha();



}
