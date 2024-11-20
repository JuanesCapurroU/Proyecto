package com.example.Floristeria.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCategoria;


    @OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Flores> flores;

    public Categorias() {
    }

    public Categorias(Long id, String nombreCategoria, List<Flores> flores) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.flores = flores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Flores> getFlores() {
        return flores;
    }

    public void setFlores(List<Flores> flores) {
        this.flores = flores;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", flores=" + flores +
                '}';
    }
}
