package com.weather_app.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IpData(String city, Float lat, Float lon, String timezone) {

}
