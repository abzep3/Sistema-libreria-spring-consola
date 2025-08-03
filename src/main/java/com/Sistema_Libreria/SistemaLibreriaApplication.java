package com.Sistema_Libreria;

import com.Sistema_Libreria.modelo.Libro;
import com.Sistema_Libreria.servicio.ILibroServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SistemaLibreriaApplication implements CommandLineRunner {

	
	@Autowired
	private ILibroServicio libroServicio; //inyección de dependencias, no olvidar

	private static final Logger logger = LoggerFactory.getLogger(SistemaLibreriaApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		SpringApplication.run(SistemaLibreriaApplication.class, args);
		logger.info("Aplicación finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("*** Aplicación de Libreria ***");
		libreriaApp();
	}

	private void libreriaApp(){
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
				1. Listar Contactos
				Elige una opción:\s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(nl + "--- Listado de Libros" + nl);
				List<Libro> libros = libroServicio.listarLibros();
				libros.forEach(libro -> logger.info(libro.toString() + nl));
			}

		}
		return salir;
	}

}
