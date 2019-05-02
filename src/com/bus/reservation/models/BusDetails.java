package com.bus.reservation.models;

public class BusDetails {
	private String busid;
	private String companyName;
	private String make;
	private String Type;
	private String baseFare;
	private String departingTime;
	private String totalDistance;
	private String routeId;
	private String arriveTime;
	private String active;
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BusDetails [companyName=" + companyName + ", make=" + make + ", Type=" + Type + ", baseFare=" + baseFare
				+ ", departingTime=" + departingTime + "]";
	}
	
	public String getArriveTime() {
		return arriveTime;
	}


	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}


	public String getRouteId() {
		return routeId;
	}


	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}


	public String getTotalDistance() {
		return totalDistance;
	}


	public void setTotalDistance(String totalDistance) {
		this.totalDistance = totalDistance;
	}


	


	public BusDetails(String companyName, String make, String type, String baseFare, String departingTime) {
		super();
		this.companyName = companyName;
		this.make = make;
		Type = type;
		this.baseFare = baseFare;
		this.departingTime = departingTime;
	}


	public BusDetails() {
		super();
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getBaseFare() {
		return baseFare;
	}


	public void setBaseFare(String baseFare) {
		this.baseFare = baseFare;
	}


	public String getDepartingTime() {
		return departingTime;
	}


	public void setDepartingTime(String departingTime) {
		this.departingTime = departingTime;
	}


	public String getBusid() {
		return busid;
	}


	public void setBusid(String busid) {
		this.busid = busid;
	}
	
	
	
}
