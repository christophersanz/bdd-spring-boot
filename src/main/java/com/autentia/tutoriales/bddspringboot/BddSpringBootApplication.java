package com.autentia.tutoriales.bddspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class BddSpringBootApplication implements CommandLineRunner {

	@Autowired
	private RepositorioPerfilCliente repositorio;

	public static void main(String[] args) {
		SpringApplication.run(BddSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UUID id = UUID.randomUUID();
		PerfilCliente perfil = new PerfilCliente.Builder()
				.withId(id)
				.withNombre("Gustavo")
				.withFechaNacimiento(LocalDate.of(1974, 2, 2))
				.withEmail("gustavo@cerati.com")
				.withTelefono("+51 123456789")
				.build();

		Thread.sleep(20000);
		repositorio.save(perfil);
	}
}
