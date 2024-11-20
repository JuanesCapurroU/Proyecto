package com.example.Floristeria.Repository;

import com.example.Floristeria.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepositorio extends JpaRepository<Clientes, Long> {
    // Consulta 1: Clientes con pedidos, ordenados por fecha de pedido
    @Query("SELECT c FROM Clientes c JOIN c.pedidos p ORDER BY p.fechaPedido")
    List<Clientes> findAllClientesWithPedidosOrderedByFecha();

    // Consulta 2: Clientes con pedido y con el detalle, ordenados por precio de menor a mayor
    @Query("SELECT c FROM Clientes c JOIN c.pedidos p JOIN p.detallesPedidos dp ORDER BY dp.precioUnitario")
    List<Clientes> findAllClientesWithPedidosAndDetallesOrderedByPrecio();

    // Consulta 5: Cantidad de veces que un cliente ha realizado compras
    @Query("SELECT COUNT(p) FROM Pedidos p WHERE p.clientes.id = ?1")
    Long countPedidosByClienteId(Long clienteId);
}
