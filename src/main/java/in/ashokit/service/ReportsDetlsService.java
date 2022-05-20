package in.ashokit.service;

import java.util.List;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
 
public interface ReportsDetlsService {
	
	public List<String> getPlanNames();

	public List<String> getPlanStatuses();

	public List<SearchResponse> searchplans(SearchRequest request);
	
}
