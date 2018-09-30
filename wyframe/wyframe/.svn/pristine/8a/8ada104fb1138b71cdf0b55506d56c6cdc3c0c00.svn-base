package wy.addons.zcgl.prdBrand.dao;


import wy.addons.zcgl.prdBrand.model.Xgt_goods_prd_brand;
import wy.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品品牌Dao
 *
 * @author wyframe
 * @Date 2017-11-21 21:07:58
 */
public interface Xgt_goods_prd_brandDao {

	List<Map<String, Object>> list(@Param("condition") String condition,@Param("prd_brand_id") Integer prd_brand_id);

	List<Map<String, Object>> list2(@Param("condition") String condition,@Param("cpnId") Integer cpnId,@Param("prd_brand_id") Integer prd_brand_id);

	Xgt_goods_prd_brand queryById(@Param("xgt_goods_prd_brandId") Integer xgt_goods_prd_brandId);

	List<Map<String, Object>> queryBrands(@Param("cpnId") Integer cpnId);

	int queryCpnBrandId(@Param("userId") Integer userId);

	List<Map<String, Object>> brandList();

	int queryBrandSt(@Param("xgt_goods_prd_brandId") Integer xgt_goods_prd_brandId);

	void updateBrandById(@Param("xgt_goods_prd_brandId") Integer xgt_goods_prd_brandId);

	String queryBrandNm(@Param("parPrdBrandid") Integer parPrdBrandid);

	Map<String,String> iQueryById(@Param("id") Integer id);

	List<ZTreeNode> tree(@Param("cpnId") Integer cpnId);

	List<ZTreeNode> tree1();

	String selectBrandNm(@Param("brandId") Integer brandId);

	int queryCpnId(@Param("userId") Integer userId);
}
