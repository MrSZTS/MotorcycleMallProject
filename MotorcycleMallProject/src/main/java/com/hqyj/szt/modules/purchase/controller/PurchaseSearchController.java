package com.hqyj.szt.modules.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase")
public class PurchaseSearchController {

	/*
	 * http://127.0.0.1:8080/purchase/formsearch
	 */
	@RequestMapping("/formsearch")
	public String purchaseSearchPage() {
		return "index";
	}
	
}
