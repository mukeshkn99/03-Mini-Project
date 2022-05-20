package in.ashokit.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	private String PlanName;

	private String PlanStatus;

	private String HolderName;

	private Long HolderSSN;

	private Double BenefitAmount;

	private LocalDate StartDate;

	private LocalDate EndDate;

	
	private String DenialReason;

}
