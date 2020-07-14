package com.hqyj.szt.modules.jobstate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobstate")
public class JobStateController {

	/**
	 * 127.0.0.1:8080/jobstate/state
	 */
	@RequestMapping("/state")
	public String jobStatePage() {
		return "index";
	}
	
}
