package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YandexWeatherApi {
    private static final String API_URL_TEMPLATE = "https://api.weather.yandex.ru/v2/forecast?lat=%s&lon=%s";
    private static final String DEFAULT_LAT = "55.7558";
    private static final String DEFAULT_LON = "37.6173";

    private final HttpClient httpClient = HttpClient.newBuilder().build();

    private final String apiKey;
    private final String lat;
    private final String lon;

    public YandexWeatherApi(String apiKey) {
        this(apiKey, DEFAULT_LAT, DEFAULT_LON);
    }

    public YandexWeatherApi(String apiKey, String lat, String lon) {
        this.apiKey = apiKey;
        this.lat = lat;
        this.lon = lon;
    }

    private String buildUrl() {
        return String.format(API_URL_TEMPLATE, lat, lon);
    }

    public String makeRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buildUrl()))
                .GET()
                .header("X-Yandex-Weather-Key", this.apiKey)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException(String.format(
                    "API Error. HTTP: %d. Body: %s",
                    response.statusCode(),
                    response.body()
            ));
        }

        return response.body();
    }
}
