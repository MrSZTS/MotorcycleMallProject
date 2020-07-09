package com.hqyj.szt.modules.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase")
public class PurchaseFormController {

	/**
	 * 127.0.0.1:8080/purchase/form
	 */
	@RequestMapping("/form")
	public String purchaseForm() {
		return "index";
	}
	
}
