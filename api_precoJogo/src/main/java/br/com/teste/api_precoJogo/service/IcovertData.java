package br.com.teste.api_precoJogo.service;

public interface IcovertData {
    <T> T getData(String json, Class<T> tClass);
}
