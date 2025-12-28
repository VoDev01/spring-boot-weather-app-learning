package com.weather_app.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherData(Integer temp, 
    @JsonProperty("feels_like") Integer feelsLike, 
    String icon, 
    String condition, 
    @JsonProperty("wind_speed") Integer windSpeed,
    @JsonProperty("wind_dir") String windDir, 
    @JsonProperty("prec_type") Integer precType, 
    @JsonProperty("prec_strength") Float precStrength,
    Float cloudness, 
    @JsonProperty("phenom_icon") String phenomIcon, 
    @JsonProperty("phenom_condition") String phenomCondition) {
}
