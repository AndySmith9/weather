package com.andy.weather.source.dto;

import java.io.Serializable;



public class Forecast implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//日期
    private String date;
    //最高温度，最低温度
    private String high;
    private String low;
    private String ymd;
    private String week;
    //日出 & 日落
    private String sunrise;
    private String sunset;
    //空气质量
    private Integer aqi;

    //风向
    private String fx;
    //风力
    private String fl;
    //天气类型
    private String type;
    private String notice;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public Integer getAqi() {
		return aqi;
	}
	public void setAqi(Integer aqi) {
		this.aqi = aqi;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}

    
    
    
}
