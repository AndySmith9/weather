package com.andy.weather.city.dto;

import java.io.Serializable;

public class CitycodeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int pid;
	private String city_code;
	private String city_name;
	private String post_code;
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	private String area_code;
	private String ctime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "CitycodeDto [id=" + id + ", pid=" + pid + ", city_code=" + city_code + ", city_name=" + city_name
				+ ", post_code=" + post_code + ", area_code=" + area_code + ", ctime=" + ctime + "]";
	}
	
	
	
	
	
	
}
