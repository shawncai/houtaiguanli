package wy.addons.zcgl.prdCls.dao;


import wy.core.node.ZTreeNode;
import wy.addons.zcgl.prdCls.model.Xgt_goods_prd_cls;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 产品分类Dao
 *
 * @author wyframe
 * @Date 2017-11-21 21:10:33
 */
public interface Xgt_goods_prd_clsDao {
	List<Map<String, Object>> list3(@Param("condition") String condition,@Param("prd_cls_id") Integer prd_cls_id);
	List<Map<String, Object>> list1(@Param("condition") String condition,@Param("prd_cls_id") Integer prd_cls_id);
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("cpnId") Integer cpnId,@Param("prd_cls_id") Integer prd_cls_id);

	Xgt_goods_prd_cls queryById(@Param("xgt_goods_prd_clsId") Integer xgt_goods_prd_clsId);

	String queryClsName(@Param("parPrdClsId") Integer parPrdClsId);

	String selectClsNm(@Param("clsId") Integer clsId);

	void updateClsById(@Param("xgt_goods_prd_clsId") Integer xgt_goods_prd_clsId);

	String queryClsNm(@Param("clsId") Integer clsId);

	int queryCpnId(@Param("userId") Integer userId);

	int queryCpnBrandId(@Param("userId") Integer userId);
	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date
	 */
	List<ZTreeNode> tree(@Param("cpnId") Integer cpnId);

	List<ZTreeNode> tree1();

	List<Map<String, Object>> clsList();

	Map<String,String> iQueryById(@Param("id") Integer id);
}
