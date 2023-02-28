package controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.EmpService;
import service.FileService;

@Controller
public class HomeController {
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	private FileService fileService;
	
	// GetMapping이 왜 자동완성 되지 않을까?
	// pom.xml에서 스프링의 버전을 높인다! 스프링 4.3부터 지원!
	@GetMapping("/")
	public String landing(Model model) {
		model.addAttribute("empList", empService.findAll());
		return "home";
	}
	
	@GetMapping("/fileView")
	public String getFileView(Model model, HttpServletRequest request) {
		model.addAttribute("fileInfoList", fileService.findAllFileInfo(request));
		return "home2";
	}
}
