package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name= "REPORTS")
public class EligDetlsEntity {
	@Id
	@GeneratedValue
	@Column(name= "PLAN_ID")
	private Integer PlanId;
	
	@Column(name= "PLAN_NAME")
	private String PlanName;
	
	@Column(name= "PLAN_STATUS")
	private String PlanStatus;
	
	@Column(name= "HOLDER_NAME")
	private String HolderName;
	
	@Column(name= "HOLDER_SSN")
	private Long HolderSSN;
	
	@Column(name= "BENEFIT_AMT")
	private Double BenefitAmount;
	  
	@Column(name= "START_DATE")
	@CreationTimestamp
	private LocalDate StartDate;
	
	@Column(name= "END_DATE")
	@CreationTimestamp
	private LocalDate EndDate;
	
	@Column(name= "DENIAL_REASON")
	private String DenialReason;
}
