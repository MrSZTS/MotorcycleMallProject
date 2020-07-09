package com.hqyj.szt.modules.jobstate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobstate")
public class JobStateController {

	@RequestMapping("/state")
	public String jobStatePage() {
		return "index";
	}
	
}
