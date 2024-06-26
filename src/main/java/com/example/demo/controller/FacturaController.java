package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Factura;
import com.example.demo.servicio.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	
	  @Autowired
	    private FacturaService facturaService;

	    @GetMapping
	    public List<Factura> getAllFacturas() {
	        return facturaService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) {
	        Factura factura = facturaService.findById(id);
	        return ResponseEntity.ok(factura);
	    }

	    @PostMapping
	    public Factura createFactura(@RequestBody Factura factura) {
	        return facturaService.save(factura);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Factura> updateFactura(@PathVariable Long id, @RequestBody Factura facturaDetails) {
	        Factura factura = facturaService.findById(id);
	        factura.setDescripcion(facturaDetails.getDescripcion());
	        factura.setNit(facturaDetails.getNit());
	        factura.setCodigo(facturaDetails.getCodigo());
	        final Factura updatedFactura = facturaService.save(factura);
	        return ResponseEntity.ok(updatedFactura);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
	        facturaService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

}
