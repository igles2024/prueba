package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Producto;
import com.example.demo.repository.ProductoRepository;

/*
 * se realizo la implementacion de siguiente servicio para realiza 
 * el crud de cada operacon para productos
 * 
 */

@Service
public class ProductoService {
	
	@Autowired
    private ProductoRepository productoRepository;

	@Transactional
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Transactional
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

}
