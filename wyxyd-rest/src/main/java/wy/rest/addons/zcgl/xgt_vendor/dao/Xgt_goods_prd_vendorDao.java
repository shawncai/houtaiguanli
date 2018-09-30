package wy.rest.addons.zcgl.xgt_vendor.dao;


import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.xgt_vendor.model.Xgt_goods_prd_vendor;

import java.util.List;
import java.util.Map;
/**
 * 合作伙伴Dao
 *
 * @author wyframe
 * @Date 2017-11-27 14:46:23
 */
public interface Xgt_goods_prd_vendorDao {


	Xgt_goods_prd_vendor queryById(@Param("xgt_goods_prd_vendorId") Integer xgt_goods_prd_vendorId);
	
	List<Map<String, Object>> queryVendors(@Param("cpnId") Integer cpnId);
	
	String queryVendorNm(@Param("vendorId") Integer vendorId);
	
	void updateVendorById(@Param("xgt_goods_prd_vendorId") Integer xgt_goods_prd_vendorId);
	
	List<Map<String, Object>> vendorList();

	List<Map<String, Object>> venDorList();
	
	Map<String,String> iQueryById(@Param("id") Integer id);

	List<Map<String,Object>> findByNameOrNo(@Param("prd_vendor_nm") String prd_vendor_nm, @Param("cpnId") Integer cpnId);

	void detail(int i);

    void addVendor(Map<String, Object> map);
	List<ZTreeNode> tree(@Param("cpnId") Integer cpnId);

	List<ZTreeNode> tree1();

	List<Xgt_goods_prd_vendor> list();
	/*List<Map<String, Object>> list(@Param("cpnId") Integer cpnId, @Param("prd_brand_nm") String prd_brand_nm);*/
	List<Map<String, Object>> list2(@Param("condition") String condition, @Param("cpnId") Integer cpnId, @Param("prd_vendor_id") Integer prd_vendor_id);

	String selectVendorNm(@Param("vendorId") Integer vendorId);
}
