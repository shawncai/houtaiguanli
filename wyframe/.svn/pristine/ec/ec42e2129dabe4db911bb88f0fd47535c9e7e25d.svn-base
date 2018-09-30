package wy.addons.zcgl.cpncata.dao;


import wy.addons.zcgl.cpncata.model.Xyd_cpn_cata;
import wy.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 入驻企业Dao
 *
 * @author wyframe
 * @Date 2017-09-06 18:41:54
 */
public interface Xyd_cpn_cataDao {

	/**
	 * 查询所有入驻企业
	 */
	List<Map<String, Object>> list(@Param("cpn_cata_nm") String cpn_cata_nm, @Param("cpn_cata_id") Integer cpn_cata_id);

	/**
	 * 根据入驻企业类型Id查询入驻企业信息
	 */
	Xyd_cpn_cata queryById(@Param("xyd_cpn_cataId") Integer xyd_cpn_cataId);
	
	/**
	 * 根据入驻企业类型Id查询入驻企业类型名称
	 */
	String selectPCpnCataNm(@Param("xyd_cpn_cataId") Integer xyd_cpn_cataId);
	
	/**
	 * 根据入驻企业类型名称查询入驻企业类型Id
	 */
	Integer selectCpnCataId(@Param("cpn_cata_id") String cpn_cata_id);
	
    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 
     */
	List<ZTreeNode> tree();
	
	/**
	 * 查询所有入驻企业
	 */
	List<Map<String, Object>> selectCpnCatas();
}
