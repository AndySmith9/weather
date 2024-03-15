package com.andy.weathercity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.weather.city.dto.CitycodeDto;

@RequestMapping("city")
@FeignClient(name="WeatherCity")
public interface WeatherCityClient {
	@GetMapping("get/{cityName}")
	public CitycodeDto getCitycodeByName (@PathVariable("cityName") String cityName);
}
