package br.com.teste.api_precoJogo.main;
import br.com.teste.api_precoJogo.model.GameInformations;
import br.com.teste.api_precoJogo.service.APIConsumption;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private final String ADDRESS = "https://www.cheapshark.com/api/1.0/games?title=";
    private final double realQuote = 5.75;

    public void showMenu() {
        while (true) {
        try {
            APIConsumption APIConsumption = new APIConsumption();
            System.out.println("      -------------------------------------------------------");
            System.out.print("      Digite um nome de jogo para procurar os melhores preços:");
            System.out.println("\n      Digite sair para encerra a pesquisa");
            System.out.println("      -------------------------------------------------------");
            String name = scanner.nextLine();

            // Evita erro com espaços
            String json = APIConsumption.getData(ADDRESS + name.replace(" ", "+"));

            ObjectMapper mapper = new ObjectMapper();
            List<GameInformations> games = mapper.readValue(json, new TypeReference<List<GameInformations>>() {});

            //Caso o usurio dizegite errado
            if (games.isEmpty()){
                System.out.println("****** Nenhum jogo encontrado, tente novamente ******");
                return;
            }

            //opção de saida
            if (name.equalsIgnoreCase("sair")){
                System.out.println("Programa encerrado com sucesso!");
                break;
            }

            //Ordena pelo menor preço
            games.sort(Comparator.comparingDouble(j -> Double.parseDouble(j.valor())));

            System.out.println("-----------------------------");
            System.out.println("Melhores preços de: " + name);
            System.out.println("-----------------------------");

            for (GameInformations game : games) {
                //CONVERSOR DOLAR PARA O REAL
                double dollarPrice = Double.parseDouble(game.valor()); // mudar a variavel string da api para double
                double realPrice = dollarPrice * realQuote;
                String formattedPrice = String.format("R$%.2f", realPrice); // formatar o preço para virgula e só aparecer as 2 primeiras casas depois da virgula

                System.out.println("Título: " + game.titulo());
                System.out.println("Preço em dolar: $" + game.valor());
                System.out.println("Preço em reais: " + formattedPrice);
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
}

