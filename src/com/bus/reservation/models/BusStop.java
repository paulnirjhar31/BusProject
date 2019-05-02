package com.bus.reservation.models;

public class BusStop {
	String cityName;
	String cityId;
	String fareToReachNextstation;
	String timeintervalToNextStation;
	
	
	@Override
	public String toString() {
		return "BusStop [cityName=" + cityName + ", cityId=" + cityId + ", fareToReachNextstation="
				+ fareToReachNextstation + ", timeintervalToNextStation=" + timeintervalToNextStation + "]";
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getFareToReachNextstation() {
		return fareToReachNextstation;
	}
	public void setFareToReachNextstation(String fareToReachNextstation) {
		this.fareToReachNextstation = fareToReachNextstation;
	}
	public String getTimeintervalToNextStation() {
		return timeintervalToNextStation;
	}
	public void setTimeintervalToNextStation(String timeintervalToNextStation) {
		this.timeintervalToNextStation = timeintervalToNextStation;
	}
	
	
}
