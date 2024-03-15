package com.andy.weathersource.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.weather.source.dto.WeatherDto;



@FeignClient(name="WeatherSource")
@RequestMapping("source")
public interface WeatherSourceClient {
	@GetMapping("get/{id}")
	public WeatherDto getWeather(@PathVariable("id") String id);
}
