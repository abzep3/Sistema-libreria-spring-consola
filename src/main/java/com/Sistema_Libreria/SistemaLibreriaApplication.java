package com.Sistema_Libreria;

import com.Sistema_Libreria.modelo.Libro;
import com.Sistema_Libreria.modelo.Prestamo;
import com.Sistema_Libreria.modelo.Usuario;
import com.Sistema_Libreria.servicio.ILibroServicio;
import com.Sistema_Libreria.servicio.IPrestamoServicio;
import com.Sistema_Libreria.servicio.IUsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SistemaLibreriaApplication implements CommandLineRunner {

	Scanner scanner = new Scanner(System.in);

	@Autowired
	private IUsuarioServicio usuarioServicio;

	@Autowired
	private ILibroServicio libroServicio; //inyección de dependencias, no olvidar

	@Autowired
	private IPrestamoServicio prestamoServicio;

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
				1. Listar Usuarios
				2. Nuevo Usuario
				3. Modificar Usuario
				4. Eliminar Usuario
				5. Listar Libros
				6. Nuevo Libro
				7. Modificar Libro por Id
				Elige una opción:\s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){

			case 1 -> {
				logger.info(nl + "--- Listado de Usuarios" + nl);
				List<Usuario> usuarios = usuarioServicio.listarUsuarios();
				usuarios.forEach(usuario -> logger.info(usuario.toString() + nl));
			}

			case 2 -> {
				logger.info(nl + "--- Nuevo Usuario" + nl);
				logger.info("Ingresar nombre: ");
				var nombre = consola.nextLine();
				logger.info("Ingresar email: ");
				var email = consola.nextLine();
				logger.info("Ingresar telefono: ");
				var telefono = consola.nextLine();
				logger.info("Ingresar direccion: ");
				var direccion = consola.nextLine();
				var usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				usuario.setTelefono(telefono);
				usuario.setDireccion(direccion);
				usuarioServicio.guardarUsuario(usuario);
				logger.info("Usuario agregado: "+ usuario + nl);
			}

			case 3 -> {
				logger.info(nl + "--- Modificar usuario" + nl);
				logger.info("Id usuario:");
				var idUsuario = Integer.parseInt(consola.nextLine());
				Usuario usuario = usuarioServicio.buscarUsuarioPorId(idUsuario);
				if(usuario != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Direccion: ");
					var direccion = consola.nextLine();
					var Usuario = new Usuario();
					usuario.setNombre(nombre);
					usuario.setEmail(email);
					usuario.setTelefono(telefono);
					usuario.setEmail(email);
					usuarioServicio.guardarUsuario(usuario);
					logger.info("Usuario agregado: " + usuario + nl);
				}
			}

			case 4 -> {
				logger.info(nl + "--- Eliminar usuario" + nl);
				System.out.println("--- id Usuario");
				var carnet = Integer.parseInt(consola.nextLine());
				var usuario = usuarioServicio.buscarUsuarioPorId(carnet);
				if(usuario!=null){
					usuarioServicio.eliminarUsuario(usuario);
					logger.info("Usuario eliminado: "+ usuario + nl);
				}
				else {
					logger.info("Usuario No encontrado: " + usuario + nl);
				}
			}

			case 5 -> {
				logger.info(nl + "--- Listado de Libros" + nl);
				List<Libro> libros = libroServicio.listarLibros();
				libros.forEach(libro -> logger.info(libro.toString() + nl));
			}

			case 6 -> {
				logger.info(nl + "---- Ingresar Nuevo Libro ----" + nl);
				logger.info("Ingresar Nombre de libro: ");
				var nombre = consola.nextLine();
				logger.info("Ingresar Autor del libro: ");
				var autor = consola.nextLine();
				logger.info("Ingresar ISBN: ");
				var isbn = consola.nextLine();
				var libro = new Libro();
				libro.setNombre(nombre);
				libro.setAutor(autor);
				libro.setIsbn(isbn);
				libroServicio.guardarLibro(libro);
				logger.info("Libro agregado: " + libro + nl);

			}

			case 7 -> {
				logger.info(nl + "--- Modificar Libro Por Id ---");
				logger.info("Id Libro: ");
				var idLibro = Integer.parseInt(consola.nextLine());
				Libro libro = libroServicio.buscarLibroPorId(idLibro);
				if(libro != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Autor: ");
					var autor = consola.nextLine();
					logger.info("Isbn: ");
					var isbn = consola.nextLine();
					var Libro = new Libro();
					libro.setNombre(nombre);
					libro.setAutor(autor);
					libro.setIsbn(isbn);
					libroServicio.guardarLibro(libro);
					logger.info("Libro Modificado: " + libro + nl);
				}
			}


//			logger.info(nl + "--- Modificar usuario" + nl);
//			logger.info("Id usuario:");
//			var idUsuario = Integer.parseInt(consola.nextLine());
//			Usuario usuario = usuarioServicio.buscarUsuarioPorId(idUsuario);
//			if(usuario != null){
//				logger.info("Nombre: ");
//				var nombre = consola.nextLine();
//				logger.info("Email: ");
//				var email = consola.nextLine();
//				logger.info("Telefono: ");
//				var telefono = consola.nextLine();
//				logger.info("Direccion: ");
//				var direccion = consola.nextLine();
//				var Usuario = new Usuario();
//				usuario.setNombre(nombre);
//				usuario.setEmail(email);
//				usuario.setTelefono(telefono);
//				usuario.setEmail(email);
//				usuarioServicio.guardarUsuario(usuario);
//				logger.info("Usuario agregado: " + usuario + nl);
//			}
//



//			case 6 ->{
//				logger.info(nl + "--- Listado de Prestamos" + nl);
//				List<Prestamo> prestamos = prestamoServicio.listarPrestamos();
//				prestamos.forEach(prestamo -> logger.info(prestamo.toString() + nl));
//			}
//			case 7 -> {
//
//				logger.info(nl + "Ingresar Nuevo Prestamo" + nl);
//				logger.info(nl + "-- Listado de Usuarios" + nl);
//				List<Usuario> usuarios = usuarioServicio.listarUsuarios();
//				usuarios.forEach(usuario -> logger.info(usuario.toString() + nl));
//
//				logger.info("Seleccionar Usuario Id: ");
//				int idUsuario = scanner.nextInt();
//				logger.info(nl + "-- Listado de Libros");
//				List<Libro> libros = libroServicio.listarLibros();
//				libros.forEach(libro -> logger.info(libro.toString() + nl));
//
//				logger.info("Seleccionar Libro por Id: ");
//				int idLibro = scanner.nextInt();
//
//				Usuario usuario = usuarioServicio.buscarUsuarioPorId(idUsuario);
//				Libro libro = libroServicio.buscarLibroPorId(idLibro); //
//
//				if(usuario == null || libro == null){
//					logger.warn("Usuario o Libro no encontrado. No se puede registrar el prestamo");
//					break;
//				}
//				Prestamo prestamo = new Prestamo();
//				prestamo.setUsuario(usuario);
//				prestamo.setLibro(libro);
//				prestamo.setFechaPrestamo(LocalDate.now());
//				prestamo.setFechaDevolucion(null);
//
//				prestamoServicio.guardarPrestamo(prestamo);
//
//				logger.info("Prestamo registrado exitosamente. ");
//			}
//
//			case 8 -> {
//
//				logger.info(nl + "--- Listado de Prestamos" + nl);
//				List<Prestamo> prestamos = prestamoServicio.listarPrestamos();
//				prestamos.forEach(prestamo -> logger.info(prestamo.toString() + nl));
//
//				logger.info(nl + "--- Devolver prestamo");
//				logger.info(nl + "Ingresar id de prestamo: ");
//				int idPrestamo = scanner.nextInt();
//				scanner.nextLine();
//
//				try {
//					prestamoServicio.devolverPrestamo(idPrestamo);
//					logger.info("Prestamo devuelto");
//				} catch (RuntimeException e) {
//					logger.warn("Error" + e.getMessage());
//				} catch (Exception e) {
//					logger.warn("Error inesperado");
//				}
//
//			}





		}
		return salir;
	}

}
