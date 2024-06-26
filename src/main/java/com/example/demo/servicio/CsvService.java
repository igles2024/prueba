package com.example.demo.servicio;




import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/*
 * Se implementa este servicio para carga y descarga de cvs
 * 
 * 
 * 
 */


@Service

public class CsvService {
	
	 @Autowired
	    private ClienteRepository clienteRepository;

	   @Transactional
	    public void saveClientesFromCsv(MultipartFile file) throws Exception {
	        // Lee el archivo CSV
	        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	            Cliente cliente = new Cliente();
	            cliente.setDocumento(data[0]);
	            cliente.setNombreCompleto(data[1]);
	            cliente.setEmail(data[2]);
	            clienteRepository.save(cliente);
	        }
	        br.close();
	    }
       
	    @Transactional
	    public List<Cliente> getAllClientes() {
	        return clienteRepository.findAll();
	    }

}
