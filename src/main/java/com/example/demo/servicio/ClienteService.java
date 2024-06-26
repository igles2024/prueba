package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

/*
 * se realizo la implementacion de siguiente servicio para realiza 
 * el crud de cada operacon para clientes
 * 
 */


@Service
public class ClienteService {
	
	 @Autowired
	    private ClienteRepository clienteRepository;
         
	   @Transactional
	    public List<Cliente> findAll() {
	        return clienteRepository.findAll();
	    }

	   @Transactional
	    public Cliente save(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }
      
	   @Transactional
	    public void delete(Long id) {
	        clienteRepository.deleteById(id);
	    }

	   @Transactional
	    public Cliente findById(Long id) {
	        return clienteRepository.findById(id).orElse(null);
	    }
}
