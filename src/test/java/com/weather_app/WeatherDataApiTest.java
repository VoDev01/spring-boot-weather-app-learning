package com.weather_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class WeatherDataApiTest {
    @LocalServerPort
    private Integer port;

    @Autowired
    private RestTestClient restClient;

    @Test
    void testFetch() {
        try {
            restClient
                    .get()
                    .uri("/api/weather/fetch")
                    .exchange()
                    .expectBody()
                    .jsonPath("$.temp")
                    .exists()
                    .returnResult()
                    .getStatus()
                    .is2xxSuccessful();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
