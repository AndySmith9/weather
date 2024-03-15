package com.andy.weather.api.demo.service;




import com.andy.weather.source.dto.WeatherDto;
import com.andy.weathersource.client.WeatherSourceClient;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
//@Slf4j
public class WeatherService {
    //请求连接地址
//    final static String SOJSON_WEATHER_URL = "http://t.weather.sojson.com/api/weather/city/{1}";
//private final static String SOJSON_WEATHER_URL = "http://t.weather.sojson.com/api/weather/city/";
private final static String SOJSON_WEATHER_URL = "http://localhost:8971/source/get/";
private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
private static final long TIME_OUT = 1800L; // 1800s
//@Autowired
//private RestTemplate restTemplate = new RestTemplateBuilder().build();

@Autowired
private WeatherSourceClient weatherSourceClient;

@Autowired
private StringRedisTemplate stringRedisTemplate;


    
    /**
     * 获取数据
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "weather_cache", key = "#id")// 从缓存获取，key为ID，缓存具体看 ehcache.xml 配置文件
    public WeatherDto getById(String id) {
        log.info("WeatherManager#getById: id={}", id);
		String strBody = null;
		WeatherDto dto = null;
		ObjectMapper mapper = new ObjectMapper();
		String key = SOJSON_WEATHER_URL + id;
//       String key = String.format(SOJSON_WEATHER_URL, id);
       System.out.println(key);
       ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
        try {
//            RestTemplate restTemplate = new RestTemplate();
//            WeatherDto dto = restTemplate.getForObject(SOJSON_WEATHER_URL , WeatherDto.class,id);
        	if (stringRedisTemplate.hasKey(key)) {
    			log.info("Redis has data");
    			strBody = ops.get(key);
        	}else {
    			log.info("Redis don't has data");
    			// 缓存没有，再调用服务接口来获取
//    			ResponseEntity<String> respString = restTemplate.getForEntity(key , String.class);
//    	 		if (respString.getStatusCodeValue() == 200) {
    	 			
    	 			WeatherDto weatherDto =	weatherSourceClient.getWeather(id);
    	 			if(weatherDto != null) {
//    				strBody = respString.getBody();
    	 				strBody = mapper.writeValueAsString(weatherDto);
        			// 数据写入缓存
        			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
    			}
        	}
        	
        	if(strBody != null) {
        		 dto = mapper.readValue(strBody, WeatherDto.class);
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
        return dto;
    }

}
