package pers.fanxin.carmanagement.module.vo;

import java.text.SimpleDateFormat;

import pers.fanxin.carmanagement.module.entity.Application;

public class ApplicationVO {
	private Long applicationId;
	private String destination;
	private String startpoint;
	private boolean roundtrip;
	private String applyDate;
	private Long applicantId;
	private String applicantName;// 申请人
	private String remark;
	private String state;

	public ApplicationVO(Application application) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.applicationId = application.getApplicationId();
		this.destination = application.getDestination();
		this.startpoint = application.getStartpoint();
		this.roundtrip = application.isRoundtrip();
		this.applyDate = sdf.format(application.getApplyDate());
		this.applicantId = application.getApplicantId();
		this.applicantName = application.getApplicantName();
		this.remark = application.getRemark();
		this.state = application.getState();
	}

	public ApplicationVO() {
	};

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

	public boolean isRoundtrip() {
		return roundtrip;
	}

	public void setRoundtrip(boolean roundtrip) {
		this.roundtrip = roundtrip;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
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

}
