package com.weather_app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.jayway.jsonpath.JsonPath;
import com.weather_app.responses.IpData;
import com.weather_app.responses.WeatherData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/weather")
@RestController
public class WeatherDataApiController {

    private final String apiKey;
    private final RestClient.Builder restClientBuilder;

    public WeatherDataApiController(
            @Value("${yandex.weather.api-key}") String apiKey, 
            RestClient.Builder restClientBuilder) {
        this.apiKey = apiKey;
        this.restClientBuilder = restClientBuilder;
    }

    @GetMapping("fetch")
    public WeatherWithCity fetch(@RequestHeader(name = "Remote-Address", required = false, defaultValue = "0.0.0.0") String ip) {
        RestClient restClient = restClientBuilder.baseUrl("http://ip-api.com").build();
        IpData ipData = restClient.get().uri("/json", ip)
        .retrieve()
        .body(IpData.class);

        restClient =  restClientBuilder
        .baseUrl("https://api.weather.yandex.ru/")
        .defaultHeader("X-Yandex-Weather-Key", apiKey)
        .build();

        WeatherData weatherData = restClient
        .get()
        .uri(uriBuilder -> uriBuilder
            .path("/v2/forecast")
            .queryParam("lat", ipData.lat())
            .queryParam("lon", ipData.lon())
            .queryParam("lang", "ru_RU")
            .queryParam("limit", 1)
            .build()
        )
        .retrieve()
        .body(WeatherResponse.class).fact();

        return new WeatherWithCity(weatherData, ipData.city());
    }
    
    public record WeatherResponse(WeatherData fact) {}

    public record WeatherWithCity(WeatherData weather, String city){}
}
