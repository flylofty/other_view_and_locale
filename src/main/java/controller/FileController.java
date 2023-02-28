package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import service.EmpService;
import service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam CommonsMultipartFile file, 
			                               HttpServletRequest request) 
	{
		fileService.saveOne(file, request);
		return "redirect:/fileView";
	}
	
	@GetMapping("/excel/emp")
	public String getEmpExcel(Model model) {
		model.addAttribute("empList", empService.findAll());
		return "empExcelView";
	}
	
	@GetMapping("/pdf/emp")
	public String getEmpPdf(Model model) {
		model.addAttribute("empList", empService.findAll());
		return "empPdfView";
	}
	
	@GetMapping("/file")
	public String downloadFile(String name,
							   Model model,
							   HttpServletRequest request)
	{
		model.addAttribute("file", fileService.findOne(name, request));
		return "downloadView";
	}
}
