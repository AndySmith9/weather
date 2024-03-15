package com.andy.weather.api.demo.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataSyncJob extends QuartzJobBean {
	private static final Logger log = LoggerFactory.getLogger(WeatherDataSyncJob.class);

	@Autowired
	private WeatherService weatherService;

	@Value("${city.code}")
	private String cityCode;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.info("Weather data sync job.Start!");
//		System.out.println("cityCode:"+cityCode);
		String[] cityCodeArray = cityCode.split(",");
		System.out.println(cityCodeArray.length);

//		System.out.println(cityCodeArray[0]);
//		System.out.println(cityCodeArray[1]);
//		System.out.println(cityCodeArray[cityCodeArray.length - 1]);

		for (int i = 1; i < cityCodeArray.length; i++) {
			System.out.println(cityCodeArray[i]);
			weatherService.getById(cityCodeArray[i]);
			System.out.println("i:"+i);
		}

		log.info("Weather data sync job.End!");
	}

}
