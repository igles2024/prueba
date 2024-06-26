package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Factura;
import com.example.demo.repository.FacturaRepository;

import jakarta.transaction.Transactional;

/*
 * se realizo la implementacion de siguiente servicio para realiza 
 * el crud de cada operacon para facturas
 * 
 */

@Service
public class FacturaService {
	
	@Autowired
    private FacturaRepository facturaRepository;

	   @Transactional
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }
	   @Transactional
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }
	   @Transactional
    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }
	   @Transactional
    public Factura findById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

}
