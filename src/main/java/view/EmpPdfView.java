package view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import dto.EmpDto;

public class EmpPdfView extends AbstractPdfView {
	private String fontPath = "c:\\windows\\Fonts\\malgun.ttf";

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                        Document document, 
			                        PdfWriter writer,
			                        HttpServletRequest request, 
			                        HttpServletResponse response) throws Exception 
	{
		// 문서의 제목 만들기
		document.addTitle("emp Table");
		
		BaseFont bfKorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfKorean, 30);
		
		// 문서의 내용 제목 만들기
		Paragraph title = new Paragraph("Emp Table", font);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(title);
		
		// 문서 테이블 만들기
		font = new Font(bfKorean, 15, Font.BOLD);
		List<EmpDto> empList = (List<EmpDto>) model.get("empList");
		Table table = new Table(8, empList.size() + 1);
		table.setWidth(100);
		//                            사번, 이름  직종, 상사, 입사, 연봉, 커미션,   부서 
		int[] columnWidths = new int[]{8,  12, 15,  8,   15,  11,   11,    20};
		table.setWidths(columnWidths);
		table.setPadding(4);
		
		Cell cell = new Cell(new Paragraph("사번", font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("이름", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("직종", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("상사", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("입사일", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("연봉", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("커미션", font));
		table.addCell(cell);
		cell = new Cell(new Paragraph("부서", font));
		table.addCell(cell);
		table.endHeaders();
		
		for(EmpDto emp : empList) {
			table.addCell(Integer.toString(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(emp.getMgr());
			table.addCell(emp.getHiredate().toString());
			table.addCell(Integer.toString(emp.getSal()));
			table.addCell(emp.getComm());
			table.addCell(emp.getDept());
		}
		document.add(table);
	}
	
	public void setFontPath(String fontPath) {
		this.fontPath = fontPath;
	}
}
