package com.gestion.productos.repositories;

import com.gestion.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository  extends JpaRepository<Producto, Long> {
}
