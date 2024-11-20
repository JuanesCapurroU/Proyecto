package com.example.Floristeria.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="flores")
public class Flores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    @JsonIgnore
    private Categorias categorias;

    @OneToMany(mappedBy = "flores", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetallesPedidos> detallesPedidos;

    public Flores() {
    }

    public Flores(Long id, String nombre, Double precio, int stock, Categorias categorias, List<DetallesPedidos> detallesPedidos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categorias = categorias;
        this.detallesPedidos = detallesPedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public List<DetallesPedidos> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallesPedidos> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }

    @Override
    public String toString() {
        return "Flores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categorias=" + categorias +
                ", detallesPedidos=" + detallesPedidos +
                '}';
    }
}
