package com.hqyj.szt.modules.purchase.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hqyj.szt.modules.common.vo.Result;
import com.hqyj.szt.modules.common.vo.SearchVo;
import com.hqyj.szt.modules.purchase.entity.Purchase;
import com.hqyj.szt.modules.purchase.service.FormService;

@RestController
@RequestMapping("/purchases")
public class PurchaseFormController {

	@Autowired
	private FormService formservice;
		
	/**
	 * 查询所有订单
	 * 127.0.0.1:8080/purchases/forms
	 */
	@PostMapping(value = "/forms",consumes = "application/json")
	public PageInfo<Purchase> getPurchaseFormBySearchVo(@RequestBody SearchVo serarchVo) {
		return formservice.getPurchaseFormBySearchVo(serarchVo);
	}
	
	/**
	 * 生成新订单
	 * 127.0.0.1:8080/purchases/form
	 */
	@PostMapping(value = "/form",consumes = "application/json")
	public Result<Purchase> insertCity(@RequestBody Purchase purchase) {
		return formservice.insertPurchaseForm(purchase);
		//return userService.editUser(user);
	}
	
	/**
	 * 删除订单
	 * 127.0.0.1/purchases/form/8
	 */
	@DeleteMapping(value = "/form/{purchaseId}")
	//@RequiresPermissions(value = {"/purchases/form"},logical = Logical.OR)//or表示满足其中一个条件即可，还有AND
	public Result<Object> deletePurchaseForm(@PathVariable String purchaseId) {
		return formservice.deletePurchaseForm(purchaseId);
	}
	
	
	
}
