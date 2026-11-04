package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class YandexApiParser {
    private final ObjectMapper mapper = new ObjectMapper();


    public int extractCurrentTemp(String responseJson) throws Exception {
        JsonNode response = mapper.readTree(responseJson);
        JsonNode fact = response.path("fact");
        JsonNode temp = fact.path("temp");

        return temp.asInt();
    }

    public int averageForecastTemp(String responseJson) throws Exception {
        int sumTempAvg = 0;
        int tempAvg;

        JsonNode response = mapper.readTree(responseJson);
        JsonNode forecasts = response.path("forecasts");

        int size = forecasts.size();

        for (int index = 0; index < size; ++index) {
            sumTempAvg += forecasts.get(index)
                    .path("parts")
                    .path("day")
                    .path("temp_avg")
                    .asInt();
        }

        tempAvg = sumTempAvg / size;


        return tempAvg;
    }
}
