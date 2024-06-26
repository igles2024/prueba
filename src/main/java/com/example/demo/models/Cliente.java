package com.example.demo.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
public class Cliente {
	 @Id
	 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String documento;
	    private String nombreCompleto;
	    private String email;

	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private List<Factura> facturas;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Factura> getFacturas() {
			return facturas;
		}

		public void setFacturas(List<Factura> facturas) {
			this.facturas = facturas;
		}
	    
	    

}
