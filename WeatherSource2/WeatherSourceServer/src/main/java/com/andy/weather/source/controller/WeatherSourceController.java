package com.andy.weather.source.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.andy.weather.source.dto.WeatherDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("source")
public class WeatherSourceController {

	@GetMapping("get/{id}")
	public WeatherDto getWeather(@PathVariable("id") String id) {
		
	long start = System.currentTimeMillis();
WeatherDto waetherDto = null;
ObjectMapper mapper = new ObjectMapper();
TypeReference<List<WeatherDto>> typeReference = new TypeReference<List<WeatherDto>>() {};

try {
	InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("weather.json");
	List<WeatherDto> objectList = mapper.readValue(is, typeReference);
//	List<WeatherDto> objectList = mapper.readValue(new File("src\\main\\resources\\weather.json"), typeReference);
	for(WeatherDto w:objectList) {


	if(w.getCityInfo().getCitykey().equals(id)) {
		waetherDto = w;
		System.out.println(w);	
		System.out.println(w.getCityInfo().getCitykey());
		break;
	}
	}

	
} catch (IOException e) {
	e.printStackTrace();
}
long end = System.currentTimeMillis();
long timeElapsed = end - start;
System.out.println(timeElapsed);
		return waetherDto;
	}
	
	
	
}
