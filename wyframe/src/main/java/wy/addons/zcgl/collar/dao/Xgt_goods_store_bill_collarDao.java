package wy.addons.zcgl.collar.dao;


import wy.addons.zcgl.collar.model.Xgt_goods_store_bill_collar;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 入库单Dao
 *
 * @author wyframe
 * @Date 2017-11-21 16:29:33
 */
public interface Xgt_goods_store_bill_collarDao {

	List<Map<String, Object>> list(@Param("condition") String condition);


	Xgt_goods_store_bill_collar queryById(@Param("xgt_goods_store_billId") Integer xgt_goods_store_billId);
	
	List<Map<String, Object>> paramsList(@Param("condition") String condition);
	
	List<Map<String, Object>> param(@Param("list") List<Integer> list);
		
	List<Map<String, Object>> selectDetail(@Param("id") Integer id);
	
	int insertTotal(@Param("map") Map<String, Object> map);
	
	int insertDetail(@Param("map2") List<Map<String, Object>> map2);
	
	//审核通过，添加到仓库cpn_goods_store
	void addGoodsStore(@Param("billDtl") List<Map<String, Object>> billDtl);
	
	
	void deleteParam(@Param("xgt_goods_store_billId") Integer xgt_goods_store_billId);
	
	void deleteTotal(@Param("xgt_goods_store_billId") Integer xgt_goods_store_billId);
	
	void deleteDetl(@Param("id") Integer id);

	List<Map<String, Object>> showDetail(@Param("id") Integer id);

	void updateInState(@Param("id") Integer id, @Param("userId") Integer userId);
	void deleteState(@Param("id") Integer id, @Param("userId") Integer userId);
	Map<String,String> iQueryById(@Param("id") Integer id);
	void updateState(@Param("bill_id") Integer bill_id, @Param("st_id") Integer st_id);
	List<Map<String,Object>> quertyMatDistributors();
	List<Map<String,Object>> selectBillDtl(@Param("bill_id") Integer bill_id); 
	Map<String,Object>  selectStoreId(@Param("bill_id") Integer bill_id); 

	String getCreateTimeCount(@Param("startTime") String startTime);
	void updateTotal(@Param("shop_num") Integer shop_num,@Param("bill_out_id") Integer bill_out_id);
	void deleteDetail(@Param("bill_out_id") Integer bill_out_id);
	void updateSubmit(@Param("bill_out_id") Integer bill_out_id);
	List<Map<String, Object>>selectOrders(@Param("name") String name,@Param("st_id")Integer st_id,@Param("aud_st_id")Integer aud_st_id);
	List<Map<String, Object>>selectOtherOrders(@Param("name") String name,@Param("st_id")Integer st_id,@Param("aud_st_id")Integer aud_st_id,@Param("userId") Integer userId);
}
