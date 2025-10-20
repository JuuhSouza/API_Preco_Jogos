package br.com.api.precos_games;

import br.com.api.precos_games.service.ApiConsumption;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrecosGamesApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(PrecosGamesApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        ApiConsumption apiConsumption = new ApiConsumption();
        String json = apiConsumption.getData("https://www.cheapshark.com/api/1.0/games?title=lego");
        System.out.println(json);


    }
}


