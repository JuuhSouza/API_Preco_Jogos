package br.com.alura.screenmatch;

import br.com.alura.screenmatch.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    private Scanner leitura = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
        System.out.println("Digite o jogo");
        String nome = leitura.nextLine();
		var json = consumoApi.obterDados("https://www.cheapshark.com/api/1.0/games?title=" + nome);
		System.out.println(json);
	}
}
