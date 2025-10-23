package br.com.teste.api_precoJogo.main;

import br.com.teste.api_precoJogo.conversor.ConversorDolar;
import br.com.teste.api_precoJogo.model.GameInformations;
import br.com.teste.api_precoJogo.service.ConsumoApi;
import br.com.teste.api_precoJogo.service.ConverterDados;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "https://www.cheapshark.com/api/1.0/games?title=";

    public void exibirMenu() {
        try {
            var consumoApi = new ConsumoApi();
            System.out.print("Digite o nome do jogo: ");
            String nome = scanner.nextLine();

            // Evita erro com espaços
            String json = consumoApi.obterDados(ENDERECO + nome.replace(" ", "+"));

            ObjectMapper mapper = new ObjectMapper();
            List<GameInformations> jogos = mapper.readValue(json, new TypeReference<List<GameInformations>>() {});

            //Ordena pelo menor preço
            jogos.sort(Comparator.comparingDouble(j -> Double.parseDouble(j.valor())));

            System.out.println("Jogos com preços mais em conta no mercado:");
            for (GameInformations jogo : jogos) {
                System.out.println("Título: " + jogo.titulo());
                System.out.println("Preço em dolar: $" + jogo.valor());
//                System.out.println("Preço em reais: $" + jogo);
                System.out.println("Foto do jogo: " + jogo.foto());
                System.out.println("Id do jogo: " + jogo.idJogo());
                System.out.println("Id da Steam: " + jogo.idSteam());
                System.out.println("-----------------------------");
            }

        } catch (Exception e) {
            System.err.println("Erro ao buscar dados da API: " + e.getMessage());
        }
    }
}
