package br.com.teste.api_precoJogo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe); //readValue : ler algo, neste caso é o json.
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);

        }
    }
}
