package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	 @GetMapping("/public")
	    public String publicEndpoint() {
	        return "Este es un endpoint público.";
	    }

	    @GetMapping("/protected")
	    public String protectedEndpoint() {
	        return "Este es un endpoint protegido.";
	    }

}
