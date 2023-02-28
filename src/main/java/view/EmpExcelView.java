package view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import dto.EmpDto;

public class EmpExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
									  Workbook workbook, 
									  HttpServletRequest request,
			                          HttpServletResponse response) throws Exception 
	{
		// 웹 브라우저가 엑셀 파일을 다운로드할 때, 사용할 이름을 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"emp_table.xls\";");
		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);
		List<EmpDto> empList = (List<EmpDto>) model.get("empList");
		int lowNum = 1;
		for(EmpDto emp : empList) {
			createEmpRow(sheet, emp, lowNum++);
		}
	}
	
	private void createEmpRow(Sheet sheet, EmpDto emp, int lowNum) {
		Row row = sheet.createRow(lowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(emp.getEmpno());
		
		cell = row.createCell(1);
		cell.setCellValue(emp.getEname());
		
		cell = row.createCell(2);
		cell.setCellValue(emp.getJob());

		cell = row.createCell(3);
		cell.setCellValue(emp.getMgr());
		
		cell = row.createCell(4);
		cell.setCellValue(emp.getHiredate());
		
		cell = row.createCell(5);
		cell.setCellValue(emp.getSal());
		
		cell = row.createCell(6);
		cell.setCellValue(emp.getComm());
		
		cell = row.createCell(7);
		cell.setCellValue(emp.getDept());
	}

	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Emp_Table");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}
	
	private void createColumnLabel(Sheet sheet) {
		String[] rowContent = {"사번", "이름", "직종", "상사", "입사일", "연봉", "커미션", "부서"};
		Row firstRow = sheet.createRow(0);
		Cell cell = null;
		int len = rowContent.length;
		for(int i = 0; i < len; ++i) {
			cell = firstRow.createCell(i);
			cell.setCellValue(rowContent[i]);
		}
	}
}
