package com.andy.weather.api.demo.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andy.weather.api.demo.service.WeatherDataSyncJob;

@Configuration
public class QuartzConfig {
	private static final int TIME = 1800; // 更新频率
	
	// JobDetail
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
//		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
//		.storeDurably().build();
		return JobBuilder.newJob(WeatherDataSyncJob.class).storeDurably()
				.withIdentity("weatherDataSyncJob").build();
	}
	
	// Trigger
	@Bean
	public Trigger weatherDataSyncTrigger() {
		
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();
		
//		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
//				.withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withSchedule(schedBuilder)
				.withIdentity("weatherDataSyncTrigger").build();
	}
	
	
}
