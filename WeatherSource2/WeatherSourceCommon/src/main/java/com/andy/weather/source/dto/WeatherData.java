package com.andy.weather.source.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class WeatherData implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//兼容字段
    private String shidu;
    private Double pm25;
    private Double pm10;
    private String quality;
    private String wendu;
    private String ganmao;

    //限号的城市
    private List<Forecast> forecast = new ArrayList<>();
    //昨天，从forecast取一条放到 yesterday
    private Forecast yesterday;

	public String getShidu() {
		return shidu;
	}
	public void setShidu(String shidu) {
		this.shidu = shidu;
	}
	public Double getPm25() {
		return pm25;
	}
	public void setPm25(Double pm25) {
		this.pm25 = pm25;
	}
	public Double getPm10() {
		return pm10;
	}
	public void setPm10(Double pm10) {
		this.pm10 = pm10;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public List<Forecast> getForecast() {
		return forecast;
	}
	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}
	public Forecast getYesterday() {
		return yesterday;
	}
	public void setYesterday(Forecast yesterday) {
		this.yesterday = yesterday;
	}

    
	
	
}
