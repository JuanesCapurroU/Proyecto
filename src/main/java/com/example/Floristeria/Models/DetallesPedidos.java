package com.example.Floristeria.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="detallesPedidos")
public class DetallesPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    @JsonIgnore
    private Pedidos pedidos;

    @ManyToOne
    @JoinColumn(name = "flores_id")
    @JsonIgnore
    private Flores flores;

    public DetallesPedidos() {
    }

    public DetallesPedidos(Long id, int cantidad, double precioUnitario, Pedidos pedidos, Flores flores) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.pedidos = pedidos;
        this.flores = flores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Flores getFlores() {
        return flores;
    }

    public void setFlores(Flores flores) {
        this.flores = flores;
    }

    @Override
    public String toString() {
        return "DetallesPedidos{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", pedidos=" + pedidos +
                ", flores=" + flores +
                '}';
    }
}
