package com.bus.reservation.models;

import java.util.List;

public class RoutesDetails {
	String routeid;
	List<BusStop> busStops;
	
	
	@Override
	public String toString() {
		return "RoutesDetails [routeid=" + routeid + ", busStops=" + busStops + "]";
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public List<BusStop> getBusStops() {
		return busStops;
	}
	public void setBusStops(List<BusStop> busStops) {
		this.busStops = busStops;
	}
	
	
}
