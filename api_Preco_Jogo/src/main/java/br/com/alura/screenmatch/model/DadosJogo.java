package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosJogo(@JsonAlias("internalName") String titulo,
                        @JsonAlias("cheapest") Integer valor,
                        @JsonAlias("thumb") String foto){
}
