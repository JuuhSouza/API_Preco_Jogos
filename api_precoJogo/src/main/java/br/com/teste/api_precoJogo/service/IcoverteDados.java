package br.com.teste.api_precoJogo.service;

public interface IcoverteDados {
    <T> T obterDados(String json, Class<T> tClass);
}
