package com.hqyj.szt.modules.purchase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hqyj.szt.modules.common.vo.SearchVo;
import com.hqyj.szt.modules.purchase.entity.Purchase;

@Mapper
public interface FormDao {
	
	//查询订单是否存在
	@Select("select * from purchase where purchase_id = #{purchaseId}")
	Purchase getPurchaseFormByPurchaseId(String purchaseId);
	
	//多条件查询
	@Select("<script>" + 
			"select * from purchase "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ " and (product_name like '%${keyWord}%') "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ " order by ${orderBy} ${sort}"
			+ "</when>"
			+ "<otherwise>"
			+ " order by purchase_id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<Purchase> getPurchaseFormBySearchVo(SearchVo serarchVo);
	
	//订单添加
	@Insert("insert into purchase (purchase_id,product_name,type,purchase_num,product_price,purchase_price,user_name,apply_time,received_condition,finish_time)"
			+" values (#{purchaseId},#{productName},#{type},#{purchaseNum},#{productPrice},#{purchasePrice},#{userName},#{applyTime},#{receivedCondition},#{finishTime})")
	void insertPurchaseForm(Purchase purchase);
	
	//订单删除
	//删除
	@Delete("delete from purchase where purchase_id = #{purchaseId}")
	void deletePurchaseForm(String purchaseId);
	
}
