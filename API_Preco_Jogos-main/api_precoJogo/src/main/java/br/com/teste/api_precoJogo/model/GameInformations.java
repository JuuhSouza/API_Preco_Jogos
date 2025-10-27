package br.com.teste.api_precoJogo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record GameInformations(@JsonAlias("external") String titulo,
                               @JsonAlias("cheapest") String valor,
                               @JsonAlias("thumb") String foto,
                               @JsonAlias("gameID") String idJogo,
                               @JsonAlias("steamAppID") String idSteam
                               ){

}
