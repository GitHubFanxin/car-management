package pers.fanxin.carmanagement.module.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Approve {
	@Id
	@Column(name="approve_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long approveId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date approveDate;
	private String approverName;
	private Long approverId;
	
}
