package wy.rest.addons.zcgl.cpn_store.dao;

import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.cpn_store.model.Xyd_cpn_store;

import java.util.List;
import java.util.Map;

/**
 * 企业仓库Dao
 *
 * @author wyframe
 * @Date 2017-09-18 11:41:05
 */
public interface Xyd_cpn_storeDao {
	List<Map<String, Object>> userCpnBranchList(@Param("cpnId") Integer cpnId);
	String selectCpnBranchNm(@Param("cpnBranchId") Integer cpnBranchId);
	int queryCpnId(@Param("userId") Integer userId);
	List<Map<String, Object>> selectCpnBranchs();
	int queryCpnBrandId(@Param("userId") Integer userId);
	List<Map<String, Object>> listBranch(@Param("cpn_id") Integer cpn_id);
	String selectCpnNm(@Param("cpnId") Integer cpnId);
	/**
	 * 获取企业仓库列表
	 */
	List<Map<String, Object>> list(@Param("cpnId") Integer cpnId, @Param("condition") String condition);

	/**
	 * 根据企业仓库Id查询企业仓库信息
	 */
	Xyd_cpn_store queryById(@Param("xyd_cpn_storeId") Integer xyd_cpn_storeId);


	/**
	 * 根据企业仓库Id查询企业仓库名称
	 */
	String selectPCpnStoreNm(@Param("xyd_cpn_storeId") Integer xyd_cpn_storeId);

	/**
	 *
	 */
	Map<String, String> iQueryById(@Param("id") Integer id);

	/**
	 * 根据企业仓库Id查询企业信息Id
	 */
	int selectCpnId(@Param("xyd_cpn_storeId") Integer xyd_cpn_storeId);

	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date
	 */
	List<ZTreeNode> tree();

	/**
	 * 查询所有企业仓库
	 */
	List<Map<String, Object>> selectCpnStores();

	List<Map<String,Object>> findByNameOrNo(@Param("cpn_store_nm") String cpn_store_nm);
}
