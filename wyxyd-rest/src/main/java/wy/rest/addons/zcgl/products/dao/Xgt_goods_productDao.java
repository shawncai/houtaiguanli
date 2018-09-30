package wy.rest.addons.zcgl.products.dao;


import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.products.model.Xgt_goods_product;

import java.util.List;
import java.util.Map;
/**
 * 商品管理Dao
 *
 * @author wyframe
 * @Date 2018-05-08 16:35:29
 */
public interface Xgt_goods_productDao {
	int queryCpnId(@Param("userId") Integer userId);
	List<Map<String, Object>> list(@Param("cpnId") Integer cpnId);
	List<Map<String, Object>> list2(@Param("cpnId") Integer cpnId, @Param("condition") String condition, @Param("st_id") Integer st_id, @Param("prd_id") Integer prd_id);
	List<Map<String, Object>> listBystore(@Param("prd_id") Integer prd_id, @Param("storeId") Integer storeId);
	List<Map<String, Object>> listBystores(@Param("cpnId") Integer cpnId, @Param("storeId") Integer storeId);

	Xgt_goods_product queryById(@Param("xgt_goods_productId") Integer xgt_goods_productId);
	
	
	Map<String,Object> iQueryById(@Param("id") Integer id);

	List<Map<String, Object>>prdClsList(@Param("cpnId") Integer cpnId);

	List<Map<String, Object>>prdUnitList();

	List<ZTreeNode> tree(@Param("cpnId") Integer cpnId);

	List<ZTreeNode> tree1();
}
