package com.Sistema_Libreria;

import com.Sistema_Libreria.servicio.ILibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaLibreriaApplication {

	@Autowired
	private ILibroServicio libroServicio;

	

	public static void main(String[] args) {
		SpringApplication.run(SistemaLibreriaApplication.class, args);
	}

}
