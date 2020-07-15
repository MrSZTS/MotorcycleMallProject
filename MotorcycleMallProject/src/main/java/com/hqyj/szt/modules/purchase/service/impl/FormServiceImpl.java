package com.hqyj.szt.modules.purchase.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.szt.modules.common.vo.Result;
import com.hqyj.szt.modules.common.vo.Result.ResultStatus;
import com.hqyj.szt.modules.common.vo.SearchVo;
import com.hqyj.szt.modules.purchase.dao.FormDao;
import com.hqyj.szt.modules.purchase.entity.Purchase;
import com.hqyj.szt.modules.purchase.service.FormService;

@Service
public class FormServiceImpl implements FormService{

	@Autowired
	private FormDao formDao;

	//根据订单号获取订单信息
	@Override
	public Purchase getPurchaseFormByPurchaseId(String purchaseId) {
		return formDao.getPurchaseFormByPurchaseId(purchaseId);
	}
	
	//查询订单
	@Override
	public PageInfo<Purchase> getPurchaseFormBySearchVo(SearchVo serarchVo) {
		//当前页没有传当前页和pagesize过来，给它一个初始化值
		serarchVo.initSearchVo();
		PageHelper.startPage(serarchVo.getCurrentPage(),serarchVo.getPageSize());
		return new PageInfo<Purchase>(
				Optional.ofNullable(formDao.getPurchaseFormBySearchVo(serarchVo))
				.orElse(Collections.emptyList())); 
	}

	//插入新订单
	@Override
	public Result<Purchase> insertPurchaseForm(Purchase purchase) {
		Purchase purchaseTemp = getPurchaseFormByPurchaseId(purchase.getPurchaseId());
		if(purchaseTemp != null && purchaseTemp.getPurchaseId().equals(purchase.getPurchaseId()) || purchase.getPurchaseId().equals("")) {
			return new Result<Purchase>(ResultStatus.FAILED.status,"The Form is Exist or Error");
		}
		
		formDao.insertPurchaseForm(purchase);
		return new Result<Purchase>(ResultStatus.SUCCESS.status,"The Form Insert SUCCESS");
	}

	//删除订单
	@Override
	public Result<Object> deletePurchaseForm(String purchaseId) {
		formDao.deletePurchaseForm(purchaseId);
		return new Result<Object>(ResultStatus.SUCCESS.status,"DELETE SUCCESS");
	}

	//编辑订单
	@Override
	public Result<Purchase> updatePurchaseForm(Purchase purchase) {
		Purchase purchaseTemp = getPurchaseFormByPurchaseId(purchase.getPurchaseId());
		if(!purchaseTemp.getPurchaseId().equals(purchase.getPurchaseId())) {
			return new Result<Purchase>(ResultStatus.FAILED.status,"Purchase Form is repeat!");
		}
		formDao.updatePurchaseForm(purchase);
		return new Result<Purchase>(ResultStatus.SUCCESS.status,"update success",purchase);
	}

//	@Override
//	public Result<Purchase> editPurchaseForm(Purchase purchase) {
//		Purchase purchaseTemp = getPurchaseFormByPurchaseId(purchase.getPurchaseId());
//		if(purchaseTemp != null && !purchaseTemp.getPurchaseId().equals(purchase.getPurchaseId())) {
//			return new Result<Purchase>(ResultStatus.FAILED.status,"Purchase Form ID is repeate!");
//		}
//		//purchase.setApplyTime(new Date());
//		
//		return new Result<Purchase>(ResultStatus.SUCCESS.status,"Edit success",purchase);
//	}
	

	


	
}
