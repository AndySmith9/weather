package com.andy.weather.api.demo.web;


import com.andy.weather.api.demo.service.WeatherCityService;
import com.andy.weather.api.demo.service.WeatherService;
import com.andy.weather.source.dto.WeatherDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class WeatherAPIContoller {

	@Autowired
	WeatherService weatherManager;
	@Autowired
	CacheManager cacheManager;
	@Autowired
	WeatherCityService weatherCityService;

	// 用来校验传参是否正确
	@Value("${city.code}")
	private String cityCode;

	/**
	 * 天气数据
	 * 
	 * @param id
	 * @return
	 */
//    @RequestMapping(value = "city/{id:1[0-9]{8}}", method = RequestMethod.GET)
	@RequestMapping(value = "city/code/{id}", method = RequestMethod.GET)
	public WeatherDto loadApi(@PathVariable("id") String id) {
		String vliCode = String.format(",%s,", id);
		if (!cityCode.contains(vliCode)) {
			throw new RuntimeException("no_city_id");
		}
		System.out.println(cacheManager.getClass().getName());//
		System.out.println(cacheManager.toString());
		return weatherManager.getById(id);

	}

	@GetMapping("get/{name}")
	public String get(@PathVariable("name") String name1) {
		return weatherCityService.getByName(name1);
	}

	@RequestMapping(value = "city/{name}", method = RequestMethod.GET)
	public WeatherDto getWeatherData(@PathVariable("name") String name) {
		String id = weatherCityService.getByName(name);
		String vliCode = String.format(",%s,", id);
		if (!cityCode.contains(vliCode)) {
			throw new RuntimeException("no_city_id");
		}
		System.out.println(cacheManager.getClass().getName());//org.springframework.data.redis.cache.RedisCacheManager
		System.out.println(cacheManager.toString());
		return weatherManager.getById(id);

	}

}
