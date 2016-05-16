package pers.fanxin.carmanagement.module.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import pers.fanxin.carmanagement.module.entity.RouteLog;

public class RouteLogVO {
	private Long logId;
	private String startDate;
	private String endDate;
	private boolean roundtrip;
	private Double cost;
	private Long driverId;
	private String driverName;
	private Long passengerId;
	private String passengerName;
	private String startpoint;
	private String destination;
	private String state;
	
	public RouteLogVO(RouteLog routeLog){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.logId=routeLog.getLogId();
		if(routeLog.getStartDate()!=null&&routeLog.getEndDate()!=null){
			this.startDate=sdf.format(routeLog.getStartDate());
			this.endDate=sdf.format(routeLog.getEndDate());
		}
		this.roundtrip=routeLog.isRoundtrip();
		this.cost=routeLog.getCost();
		this.driverId=routeLog.getDriverId();
		this.driverName=routeLog.getDriverName();
		this.passengerId=routeLog.getPassengerId();
		this.passengerName=routeLog.getPassengerName();
		this.startpoint=routeLog.getStartpoint();
		this.destination=routeLog.getDestination();
		this.state=routeLog.getState();
	}
	
	public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean isRoundtrip() {
		return roundtrip;
	}
	public void setRoundtrip(boolean roundtrip) {
		this.roundtrip = roundtrip;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
