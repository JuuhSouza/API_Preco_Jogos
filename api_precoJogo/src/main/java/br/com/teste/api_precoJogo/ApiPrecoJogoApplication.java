package br.com.teste.api_precoJogo;

import br.com.teste.api_precoJogo.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ApiPrecoJogoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiPrecoJogoApplication.class, args);
	}

	private final Scanner leitura = new Scanner(System.in);

	@Override
	public void run(String... args) {
        Main informations = new Main();
        informations.exibirMenu();

}
}

