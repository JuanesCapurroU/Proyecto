package com.example.Floristeria.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaPedido;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    @JsonIgnore
    private Clientes clientes;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetallesPedidos> detallesPedidos;

    public Pedidos() {
    }

    public Pedidos(Long id, Date fechaPedido, Double total, Clientes clientes, List<DetallesPedidos> detallesPedidos) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.clientes = clientes;
        this.detallesPedidos = detallesPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<DetallesPedidos> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallesPedidos> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", fechaPedido=" + fechaPedido +
                ", total=" + total +
                ", clientes=" + clientes +
                ", detallesPedidos=" + detallesPedidos +
                '}';
    }
}
