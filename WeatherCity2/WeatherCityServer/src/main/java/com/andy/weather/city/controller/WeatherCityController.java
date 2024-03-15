package com.andy.weather.city.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andy.weather.city.dto.CitycodeDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("city")
public class WeatherCityController {

	@GetMapping("get/{cityName}")
	public CitycodeDto getCitycodeByName (@PathVariable("cityName") String cityName) {
		
		System.out.println(cityName);
		ObjectMapper mapper = new ObjectMapper();
		CitycodeDto citycodeDto = null;
	
	TypeReference<List<CitycodeDto>> citycodeTypeReference = new TypeReference<List<CitycodeDto>>() {};
	List<CitycodeDto> citycodeList;
	try {
		citycodeList = mapper.readValue(new File("src\\main\\resources\\citycode-2019-08-23.json"),citycodeTypeReference);
		for(CitycodeDto citycode:citycodeList) {
			if(citycode.getCity_name().equals(cityName)) {
				citycodeDto = citycode;
				System.out.println(citycode);
			}
			
		}
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return citycodeDto;
	}



}
	
