package com.koreait.apart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private HomeMapper mapper;

	@RequestMapping
	public String home(Model model) {
		model.addAttribute("locationList", mapper.selLocationCodeList());
		return "index";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String result(Model model, SearchPARAM param) {
		List<ApartInfoVO> data = mapper.selApartmentInfoList(param);
		if(data.size() > 0) {
			model.addAttribute("data", data);
			return "result";
		}
		//String lawd_cd = param.getLocationCd();
		//String deal_ym = String.format("%s%02d", param.getYear());
		return "result";
	}
	
}
