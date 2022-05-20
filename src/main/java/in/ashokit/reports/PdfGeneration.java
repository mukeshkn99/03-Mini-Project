package in.ashokit.reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.response.SearchResponse;

public class PdfGeneration {
	public void generatepdf(List<SearchResponse> records, HttpServletResponse httpresponse) throws Exception {
		Document document = new Document();
		PdfWriter pdfwriter = PdfWriter.getInstance(document, httpresponse.getOutputStream());
		document.open();
		Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.RED);
		Paragraph paragraph = new Paragraph("Eligibility Details", font);
		document.add(paragraph);
		PdfPTable table = new PdfPTable(9);
		table.addCell("s.no");
		table.addCell("HolderName");
		table.addCell("HolderSSN");
		table.addCell("PlanName");
		table.addCell("PlanStatus");
		table.addCell("StartDate");
		table.addCell("EndDate");
		table.addCell("BenefitAmount");
		table.addCell("DenialReason");
		int sno = 1;
		for (SearchResponse record : records) {
			table.addCell(String.valueOf(sno));
			table.addCell(record.getHolderName());
			table.addCell(String.valueOf(record.getHolderSSN()));
			table.addCell(record.getPlanName());
			table.addCell(record.getPlanStatus());
			table.addCell(String.valueOf(record.getStartDate()));
			table.addCell(String.valueOf(record.getEndDate()));
			table.addCell(String.valueOf(record.getBenefitAmount()));
			table.addCell(record.getDenialReason());
			sno++;
		}
		document.add(table);
		document.close();
		pdfwriter.close();
	}
}
