package com.hqyj.szt.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	/**
	 * 127.0.0.1:8080/account/login
	 */
	@RequestMapping("/login")
	public String loginPage() {
		return "indexSimple";
	}
	
}
