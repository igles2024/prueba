package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Producto;
import com.example.demo.servicio.ProductoService;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	 @Autowired
	    private ProductoService productoService;

	    @GetMapping
	    public List<Producto> getAllProductos() {
	        return productoService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
	        Producto producto = productoService.findById(id);
	        return ResponseEntity.ok(producto);
	    }

	    @PostMapping
	    public Producto createProducto(@RequestBody Producto producto) {
	        return productoService.save(producto);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
	        Producto producto = productoService.findById(id);
	        producto.setNombre(productoDetails.getNombre());
	        producto.setDescripcion(productoDetails.getDescripcion());
	        producto.setPrecio(productoDetails.getPrecio());
	        final Producto updatedProducto = productoService.save(producto);
	        return ResponseEntity.ok(updatedProducto);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
	        productoService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

}
