package com.hqyj.szt.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

	/**
	 * 127.0.0.1:8080/common/dashboard
	 */
	@RequestMapping("/dashboard")
	public String dashboardPage() {
		return "index";
	}
	
}
