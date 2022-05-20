 package in.ashokit.reports;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import in.ashokit.response.SearchResponse;

public class ExcelGeneration {
	public void generateexcel(List<SearchResponse> response, HttpServletResponse httpresponse) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet createSheet = workbook.createSheet("Plans");
		HSSFRow HeaderRow = createSheet.createRow(0);
		HeaderRow.createCell(0).setCellValue("s.no");
		HeaderRow.createCell(1).setCellValue("HolderName");
		HeaderRow.createCell(2).setCellValue("HolderSSN");
		HeaderRow.createCell(3).setCellValue("PlanName");
		HeaderRow.createCell(4).setCellValue("PlanStatus");
		HeaderRow.createCell(5).setCellValue("StartDate");
		HeaderRow.createCell(6).setCellValue("EndDate");
		HeaderRow.createCell(7).setCellValue("Benefit Amount");
		HeaderRow.createCell(8).setCellValue("Denial Reason");

		for (int i = 0; i<response.size(); i++) {
			HSSFRow DataRow = createSheet.createRow(i + 1);
			SearchResponse searchResponse = response.get(i);
			DataRow.createCell(0).setCellValue(i + 1);
			if(searchResponse.getHolderName()!= null)
			DataRow.createCell(1).setCellValue(searchResponse.getHolderName());
			if(searchResponse.getHolderSSN()!= null)
			DataRow.createCell(2).setCellValue(searchResponse.getHolderSSN());
			if(searchResponse.getPlanName()!= null)
			DataRow.createCell(3).setCellValue(searchResponse.getPlanName());
			if(searchResponse.getPlanStatus()!= null)
			DataRow.createCell(4).setCellValue(searchResponse.getPlanStatus());
			if(searchResponse.getStartDate()!= null)
			DataRow.createCell(5).setCellValue(String.valueOf(searchResponse.getStartDate()));
			if(searchResponse.getEndDate()!= null)
			DataRow.createCell(6).setCellValue(String.valueOf(searchResponse.getEndDate()));
			if(searchResponse.getBenefitAmount()!= null)
			DataRow.createCell(7).setCellValue(String.valueOf(searchResponse.getBenefitAmount()));
			if(searchResponse.getDenialReason()!= null)
			DataRow.createCell(8).setCellValue(searchResponse.getDenialReason());
		}
		workbook.write(httpresponse.getOutputStream());
		workbook.close();
	}
}
