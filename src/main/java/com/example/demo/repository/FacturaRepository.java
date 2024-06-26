package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Factura;


/*
 * se realizo la implementacion 
 * de la siguentes interface para poder interactuar con la base de datos
 * 
 */

@Repository
public interface FacturaRepository   extends JpaRepository<Factura, Long> {}

