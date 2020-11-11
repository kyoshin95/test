package com.koreait.apart;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private HomeMapper mapper;

	@RequestMapping
	public String home(Locale locale, Model model) {
		model.addAttribute("locationList", mapper.selLocationCodeList());
		return "index";
	}
	
}
