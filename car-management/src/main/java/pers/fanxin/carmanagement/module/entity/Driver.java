package pers.fanxin.carmanagement.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_driver")
public class Driver {
	/**
	 * 不同于userId仅作为本表的主键
	 */
	@Id
	@Column(name="driver_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long driverId;
	@Column(name="user_id")
	/**
	 * 对应用户id
	 */
	private long userId;
	private String workNum;
	private String realname;
	private String state="disable";

	public long getDriverId() {
		return driverId;
	}
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
	
}
