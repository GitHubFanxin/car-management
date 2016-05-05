package pers.fanxin.carmanagement.module.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="t_application")
public class Application {
	@Id
	@Column(name="application_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long applicationId;
	private String destination;
	private String startpoint;
	private boolean Roundtrip;
	private Date applyDate;
	private Long applicantId;
	private String applicantName;//申请人
	private String remark;
	private String state;
	@OneToOne(targetEntity=RouteLog.class)
	@JoinColumn(name="log_id", referencedColumnName="log_id",unique=true)
	@Cascade(CascadeType.ALL)
	private RouteLog routeLog;
	@OneToOne(targetEntity=Approve.class)
	@JoinColumn(name="approve_id", referencedColumnName="approve_id",unique=true)
	@Cascade(CascadeType.ALL)
	private Approve approve;
	
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isRoundtrip() {
		return Roundtrip;
	}
	public void setRoundtrip(boolean roundtrip) {
		Roundtrip = roundtrip;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public RouteLog getRouteLog() {
		return routeLog;
	}
	public void setRouteLog(RouteLog routeLog) {
		this.routeLog = routeLog;
	}
	public Approve getApprove() {
		return approve;
	}
	public void setApprove(Approve approve) {
		this.approve = approve;
	}
}
