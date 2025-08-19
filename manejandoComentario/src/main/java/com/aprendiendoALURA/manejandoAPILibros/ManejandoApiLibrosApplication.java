package com.aprendiendoALURA.manejandoAPILibros;

import com.aprendiendoALURA.manejandoAPILibros.principal.Principal;
import com.aprendiendoALURA.manejandoAPILibros.repository.AutorRepository;
import com.aprendiendoALURA.manejandoAPILibros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManejandoApiLibrosApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repository;

	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManejandoApiLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal menu = new Principal(repository,autorRepository);
		menu.
				muestraElMenu();

	}
}
