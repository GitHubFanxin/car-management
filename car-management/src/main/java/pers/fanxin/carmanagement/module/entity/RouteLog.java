package pers.fanxin.carmanagement.module.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_uselog")
public class RouteLog {
	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long logId;
	private Date startDate;
	private Date endDate;
	private float cost;
	private Long driverId;
	private String driverName;
	@ManyToOne(targetEntity=Car.class)
	@JoinColumn(name="car_id",nullable=false)
	private Car car;
	@OneToOne(targetEntity=Application.class,mappedBy="routeLog")
	private Application application;
	public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}
