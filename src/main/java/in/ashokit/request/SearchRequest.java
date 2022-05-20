package in.ashokit.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
private String PlanName;
private String PlanStatus;
private LocalDate StartDate;
private LocalDate EndDate;
}
