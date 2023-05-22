package com.gestion.productos.repositories;

import com.gestion.productos.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
