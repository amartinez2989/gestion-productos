package com.gestion.productos.repositories;

import com.gestion.productos.entity.Marca;
import com.gestion.productos.entity.Modelo;
import com.gestion.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByMarca(Marca marca);

    @Query("SELECT m FROM Modelo m WHERE" +
            " m.marca LIKE %?1%")
    List<Modelo> findByMarcaIdIn(Long marcaIds);
}
