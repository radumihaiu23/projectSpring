package com.itschool.project.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.project.models.Weather;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service

public class WeatherServiceImpl implements WeatherService {

    private final String apiValue = "http://api.weatherapi.com/v1/current.json?";
    private final String key = "020ac53a8b254519b36172002241908";

    @Override
    public Weather getWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiValue + "key=" + key + "&q=" + city).build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(responseBody);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(jsonNode.get("current").get("last_updated").asText(), formatter);

        Weather weatherResponse = new Weather();
        weatherResponse.setCity(jsonNode.get("location").get("name").asText());
        weatherResponse.setDescription(jsonNode.get("current").get("current").get("condition").asText());
        weatherResponse.setLastUpdated(localDateTime);

        log.info(weatherResponse.toString());

        return weatherResponse;
    }
}