package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.reports.ExcelGeneration;
import in.ashokit.reports.PdfGeneration;
import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
import in.ashokit.service.ReportsDetlsService;

@RestController
public class ReportrestController {
@Autowired
private ReportsDetlsService service;

@GetMapping("/planname")
public List<String> getplanname(){
	return service.getPlanNames();
}

@GetMapping("/planstatus")
public List<String> getplanstatus(){
	return service.getPlanStatuses();
}
@PostMapping("/searchplan")
	public List<SearchResponse> search(@RequestBody SearchRequest request){
		return service.searchplans(request);
	}

@GetMapping("/excel")
public void excels(HttpServletResponse response) throws Exception {
	response.setContentType("application/octet-stream");
	String headerKey="Content-Disposition";
	String headerValue="attachment;filename=Plans.xls";
	response.setHeader(headerKey, headerValue);
	List<SearchResponse> record=service.searchplans(null);
	ExcelGeneration excel=new ExcelGeneration();
	excel.generateexcel(record, response);
	
}

@GetMapping("/pdf")
public void pdfs(HttpServletResponse httpresponse) throws Exception {
	httpresponse.setContentType("application/pdf");
	String headerKey="Content-Disposition";
	String headerValue="attachment;filename=Plans.pdf";
	httpresponse.setHeader(headerKey, headerValue);
	List<SearchResponse> record=service.searchplans(null);
	PdfGeneration pdf=new PdfGeneration();
	pdf.generatepdf(record, httpresponse);
}
}
