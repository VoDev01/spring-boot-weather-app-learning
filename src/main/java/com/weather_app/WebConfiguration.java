package com.weather_app;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/user/**")
				.addResourceLocations("classpath:/resources/", "classpath:/resources/static/", "classpath:/public/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
	}
}
