package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.EligDetlsEntity;

@Repository
public interface ReportsDetlsRepository extends JpaRepository<EligDetlsEntity, Integer> {
	@Query("Select distinct(PlanName) from EligDetlsEntity")
	List<String> getUniquePlanNames();
	
	@Query("Select distinct(PlanStatus) from EligDetlsEntity")
	List<String> getUniquePlanStatuses();
	
}
