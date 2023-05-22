package com.gestion.productos.repositories;

import com.gestion.productos.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
