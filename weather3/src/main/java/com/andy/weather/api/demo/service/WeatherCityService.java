package com.andy.weather.api.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.andy.weather.city.dto.CitycodeDto;
import com.andy.weathercity.client.WeatherCityClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherCityService {
	
	@Autowired
	private RestTemplate restTemplate;
	
private static final String WEATHER_CITY_URL = "http://localhost:8972/city/get/";
private static final Logger log = LoggerFactory.getLogger(WeatherCityService.class);

@Autowired
private WeatherCityClient weatherCityClient;


	public String getByName(String name) {
		String strBody = null;
		String cityCode = null;
		ObjectMapper mapper = new ObjectMapper();
		String url = String.format(WEATHER_CITY_URL+"%s", name);
//		ResponseEntity<String> respString = restTemplate.getForEntity(url , String.class);
//		if (respString.getStatusCodeValue() == 200) {
		CitycodeDto citycodeDto = weatherCityClient.getCitycodeByName(name);
		if(citycodeDto != null) {
			try {
				strBody = mapper.writeValueAsString(citycodeDto);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		log.info("strBody:"+strBody);
    	if(strBody != null) {
   		 try {
   			 CitycodeDto dto = mapper.readValue(strBody, CitycodeDto.class);
   			 cityCode = dto.getCity_code();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	}
    	log.info("name:"+name+".cityCode:"+cityCode);
		return cityCode;
	}
	
}
