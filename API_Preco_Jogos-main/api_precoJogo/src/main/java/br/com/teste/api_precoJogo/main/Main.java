package br.com.teste.api_precoJogo.main;
import br.com.teste.api_precoJogo.model.GameInformations;
import br.com.teste.api_precoJogo.service.APIConsumption;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private final String ADDRESS = "https://www.cheapshark.com/api/1.0/games?title=";

    public void showMenu() {
        try {
            APIConsumption APIConsumption = new APIConsumption();
            System.out.print("Digite o nome do jogo:");
            String name = scanner.nextLine();

            // Evita erro com espaços
            String json = APIConsumption.getData(ADDRESS + name.replace(" ", "+"));

            ObjectMapper mapper = new ObjectMapper();
            List<GameInformations> games = mapper.readValue(json, new TypeReference<List<GameInformations>>() {});

            //Caso o usurio dizegite errado
            if (games.isEmpty()){
                System.out.println("Nenhum jogo encontrado, tente novamente");
                return;
            }

            //Ordena pelo menor preço
            games.sort(Comparator.comparingDouble(j -> Double.parseDouble(j.valor())));

            System.out.println("-----------------------------");
            System.out.println("Melhores preços do jogo: " + name);
            System.out.println("-----------------------------");

            for (GameInformations game : games) {
                System.out.println("Título: " + game.titulo());
                System.out.println("Preço em dolar: $" + game.valor());
                System.out.println("Foto do jogo: " + game.foto());
                System.out.println("Id do jogo: " + game.idJogo());
                System.out.println("Id da Steam: " + game.idSteam());
                System.out.println("-----------------------------");
            }
        }catch (Exception e) {
            System.out.println("Erro ao buscar ou processar dados da API:" + e.getMessage());
        }
    }
}

