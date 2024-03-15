package com.andy.weather.source.dto;

import java.io.Serializable;

public class CityInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//城市name 如 茶陵
    private String city;
    //城市id
    private String citykey;
    //父级城市，比如市级，省级
    private String parent;
    //更新时间
    private String updateTime;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCitykey() {
		return citykey;
	}
	public void setCitykey(String citykey) {
		this.citykey = citykey;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "CityInfo [city=" + city + ", citykey=" + citykey + ", parent=" + parent + ", updateTime=" + updateTime
				+ "]";
	}
	
    
    
	
}
