package in.ashokit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.EligDetlsEntity;
import in.ashokit.repository.ReportsDetlsRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

@Service
public class ReportsDetlsServiceImpl implements ReportsDetlsService {

	@Autowired
	private ReportsDetlsRepository repository;

	@Override
	public List<String> getPlanNames() {
		return repository.getUniquePlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return repository.getUniquePlanStatuses();
	}

	@Override
	public List<SearchResponse> searchplans(SearchRequest request) {
		List<EligDetlsEntity> recorder = null;
		
		if (isSearchempty(request)) {
			recorder = repository.findAll();
		} else {
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();

			EligDetlsEntity entity = new EligDetlsEntity();
			
			if(planName != null && !planName.equals(" ")) {
				entity.setPlanName(planName);
			}
			if(planStatus != null && !planStatus.equals(" ")) {
				entity.setPlanStatus(planStatus);
			}
			if(startDate != null && endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}
			Example<EligDetlsEntity> of = Example.of(entity);
			recorder = repository.findAll(of);
		}	
		List<SearchResponse> response = new ArrayList<>();
		for (EligDetlsEntity elig : recorder) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(elig, sr);
			response.add(sr);
		}
		return response;
	}
	private boolean isSearchempty(SearchRequest request) {
		if(request==null) {
			return true;
		}
		if (request.getPlanName() != null && !request.getPlanName().equals(" ")) {
			return false;
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals(" ")) {
			return false;
		}
		if (request.getStartDate() != null && !request.getStartDate().equals(" ")) {
			return false;
		}
		if (request.getEndDate() != null && !request.getEndDate().equals(" ")) {
			return false;
		}
		return true;
	}

}
