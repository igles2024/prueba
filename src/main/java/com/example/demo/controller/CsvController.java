package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Cliente;
import com.example.demo.servicio.CsvService;
import com.example.demo.utilidades.CsvUtils;

import java.util.List;

/*
 *  el siguiente controlador lo utlizamos para cargar y descarga archivos CVS
 * 
 */

@RestController
@RequestMapping("/api/csv")
public class CsvController {
	 @Autowired
	    private CsvService csvService;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadCsvFile(@RequestParam("file") MultipartFile file) {
	        if (CsvUtils.isCsvFile(file)) {
	            try {
	                csvService.saveClientesFromCsv(file);
	                return ResponseEntity.status(HttpStatus.OK).body("Archivo CSV subido correctamente.");
	            } catch (Exception e) {
	                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("No se pudo subir el archivo CSV: " + e.getMessage());
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, sube un archivo CSV.");
	        }
	    }

	    @GetMapping("/download")
	    public ResponseEntity<byte[]> downloadCsv() {
	        try {
	            List<Cliente> clientes = csvService.getAllClientes();
	            byte[] csvBytes = CsvUtils.clientesToCsvBytes(clientes);
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	            headers.setContentDispositionFormData("attachment", "clientes.csv");
	            return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }

}
