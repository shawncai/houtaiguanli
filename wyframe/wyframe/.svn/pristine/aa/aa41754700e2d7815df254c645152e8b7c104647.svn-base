package wy.addons.zcgl.prdUnit.dao;


import wy.addons.zcgl.prdUnit.model.Xgt_goods_prd_unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 产品单位Dao
 *
 * @author wyframe
 * @Date 2017-11-21 21:15:14
 */
public interface Xgt_goods_prd_unitDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Xgt_goods_prd_unit queryById(@Param("xgt_goods_prd_unitId") Integer xgt_goods_prd_unitId);
	
	List<Map<String, Object>> prdUnitList();
	
	String queryUnitName(@Param("unitId") Integer unitId);
	
	Map<String,String> iQueryById(@Param("id") Integer id);

	List<Map<String, Object>> findByName(@Param("condition") String condition);
}
