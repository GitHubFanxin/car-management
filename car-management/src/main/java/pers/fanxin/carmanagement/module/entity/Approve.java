package pers.fanxin.carmanagement.module.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Approve {
	@Id
	@Column(name="approve_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long approveId;
	private Date approveDate;
	private String approverName;
	private Long approverId;
	private Long driverId;
	private String driverName;
	@OneToOne(targetEntity=Application.class,mappedBy="approve")
	private Application application;
	public Long getApproveId() {
		return approveId;
	}
	public void setApproveId(Long approveId) {
		this.approveId = approveId;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public Long getApproverId() {
		return approverId;
	}
	public void setApproverId(Long approverId) {
		this.approverId = approverId;
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
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}
