package com.hqyj.szt.modules.purchase.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.szt.modules.common.vo.Result;
import com.hqyj.szt.modules.common.vo.SearchVo;
import com.hqyj.szt.modules.purchase.entity.Purchase;

public interface FormService {
	
	//查询订单根据订单号
	Purchase getPurchaseFormByPurchaseId(String purchaseId);
	
	//查询所有订单信息
	PageInfo<Purchase> getPurchaseFormBySearchVo(SearchVo serarchVo);

	//添加订单
	Result<Purchase> insertPurchaseForm(Purchase purchase);
	
	//删除订单根据订单号
	Result<Object> deletePurchaseForm(String purchaseId);
	
}
