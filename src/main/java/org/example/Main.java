package org.example;

public class Main {
    public static void main() {
        int limit = 1;

        YandexWeatherApi weatherApi = new YandexWeatherApi("yourApiKey", limit);
        try {
            String json = weatherApi.sendRequest();
            System.out.println(json);

            YandexApiParser parser = new YandexApiParser();
            int currentTemp = parser.extractCurrentTemp(json);
            int tempAvg = parser.averageForecastTemp(json);

            System.out.printf("Текущая температура: %d°C%n", currentTemp);
            System.out.printf("Средняя температура: %d°C за %d суток%n", tempAvg, limit);

        } catch (Exception error) {
            System.err.println("Ошибка при запросе: " + error.getMessage());
            error.printStackTrace();
        }
    }
}