package wy.addons.zcgl.wyitem.dao;


import wy.addons.zcgl.wyitem.model.Xgt_wy_item;
import wy.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 栏目Dao
 *
 * @author wyframe
 * @Date 2017-11-08 10:21:13
 */
public interface Xgt_wy_itemDao {

	List<Map<String, Object>> list(@Param("item_nm") String item_nm, @Param("par_item_id") Integer par_item_id);
	List<Map<String, Object>> list2(@Param("condition") String condition,@Param("itemId") Integer itemId);
	Xgt_wy_item queryById(@Param("xgt_wy_itemId") Integer xgt_wy_itemId);
	String selectWyItemNm(@Param("ItemId") Integer ItemId);
	/**
     * 获取ztree的节点列表
     *
     * @return
     * @date 
     */
	List<ZTreeNode> tree();
	
	/**
     * 获取ztree的节点列表
     *
     * @return
     * @date 
     */
	List<ZTreeNode> itemTree();
	
	/**
	 * 查询所有栏目
	 */
	List<Map<String, Object>> selectItems();
	
    /**
    * 根据Id获取栏目名称
    */
	String selectPItemNm(@Param("xgt_wy_itemId") Integer xgt_wy_itemId);
	
	Map<String,String> iQueryById(@Param("id") Integer id);
	
	List<Map<String, Object>> topicList();
}
