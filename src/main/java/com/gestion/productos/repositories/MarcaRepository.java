package com.gestion.productos.repositories;

import com.gestion.productos.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca,Long> {

}
