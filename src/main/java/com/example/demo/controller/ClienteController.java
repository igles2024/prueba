package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cliente;
import com.example.demo.servicio.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	 @Autowired
	    private ClienteService clienteService;

	    @GetMapping
	    public List<Cliente> getAllClientes() {
	        return clienteService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
	        Cliente cliente = clienteService.findById(id);
	        return ResponseEntity.ok(cliente);
	    }

	    @PostMapping
	    public Cliente createCliente(@RequestBody Cliente cliente) {
	        return clienteService.save(cliente);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
	        Cliente cliente = clienteService.findById(id);
	        cliente.setDocumento(clienteDetails.getDocumento());
	        cliente.setNombreCompleto(clienteDetails.getNombreCompleto());
	        cliente.setEmail(clienteDetails.getEmail());
	        final Cliente updatedCliente = clienteService.save(cliente);
	        return ResponseEntity.ok(updatedCliente);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
	        clienteService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

}
