package org.example;

import org.example.YandexWeatherApi;

public class Main {
    public static void main(String[] args) {
        YandexWeatherApi weatherApi = new YandexWeatherApi("your_key");
        try {
            String json = weatherApi.makeRequest();
            System.out.println(json);
        } catch (Exception error) {
            System.err.println("Ошибка при запросе: " + error.getMessage());
            error.printStackTrace();
        }
    }
}