package pers.fanxin.carmanagement.module.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_uselog")
public class RouteLog {
	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long logId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private float cost;
	
}
