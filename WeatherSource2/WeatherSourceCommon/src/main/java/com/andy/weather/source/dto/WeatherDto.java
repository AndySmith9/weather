package com.andy.weather.source.dto;




import java.io.Serializable;



public class WeatherDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int status;
	// 第一天时间
	private String date;
	private String time;
	// 当前主题信息
	private CityInfo cityInfo;
	private WeatherData data;

	/*
	 * public boolean isSuccess() { return this.status == 200; }
	 */

	public static WeatherDtoBuilder builder() {
		return new WeatherDtoBuilder();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public CityInfo getCityInfo() {
		return cityInfo;
	}

	public void setCityInfo(CityInfo cityInfo) {
		this.cityInfo = cityInfo;
	}

	public WeatherData getData() {
		return data;
	}

	public void setData(WeatherData data) {
		this.data = data;
	}

	public WeatherDto(String message, int status, String date, String time, CityInfo cityInfo, WeatherData data) {
		super();
		this.message = message;
		this.status = status;
		this.date = date;
		this.time = time;
		this.cityInfo = cityInfo;
		this.data = data;
	}

	public WeatherDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WeatherDto [message=" + message + ", status=" + status + ", date=" + date + ", time=" + time
				+ ", cityInfo=" + cityInfo + ", data=" + data + "]";
	}

	public static class WeatherDtoBuilder {
		private String message;
		private int status;
		// 第一天时间
		private String date;
		private String time;
		// 当前主题信息
		private CityInfo cityInfo;
		private WeatherData data;

		public WeatherDtoBuilder() {
			super();
			// TODO Auto-generated constructor stub
		}

		public WeatherDtoBuilder message(String message) {
			this.message = message;
			return this;
		}

		public WeatherDtoBuilder status(int status) {
			this.status = status;
			return this;
		}

		public WeatherDtoBuilder date(String date) {
			this.date = date;
			return this;
		}

		public WeatherDtoBuilder time(String time) {
			this.time = time;
			return this;
		}

		public WeatherDtoBuilder cityInfo(CityInfo cityInfo) {
			this.cityInfo = cityInfo;
			return this;
		}

		public WeatherDtoBuilder data(WeatherData data) {
			this.data = data;
			return this;
		}

		public WeatherDto build() {
			return new WeatherDto(message, status, date, time, cityInfo, data);
		}

		@Override
		public String toString() {
			return "WeatherDto.WeatherDtoBuilder [message=" + message + ", status=" + status + ", date=" + date
					+ ", time=" + time + ", cityInfo=" + cityInfo + ", data=" + data + "]";
		}

	}

}
