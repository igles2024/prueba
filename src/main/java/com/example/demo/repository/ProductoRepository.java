package com.example.demo.repository;


/*
 * se realizo la implementacion 
 * de la siguentes interface para poder interactuar con la base de datos
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Producto;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
