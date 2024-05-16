package com.sistema.SistemaWebAuxiliatura;


import com.sistema.SistemaWebAuxiliatura.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


import static java.time.LocalTime.now;

@SpringBootApplication
public class SistemaWebAuxiliaturaApplication implements CommandLineRunner {
		public static void main(String[] args) {

		SpringApplication.run(SistemaWebAuxiliaturaApplication.class, args);
	}
	@Autowired


	private PagoRepositorio pagoRepositorio;

	@Override
	public void run(String... args) throws Exception {


	}
}

