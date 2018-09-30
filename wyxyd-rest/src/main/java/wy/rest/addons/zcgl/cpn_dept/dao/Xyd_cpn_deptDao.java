package wy.rest.addons.zcgl.cpn_dept.dao;


import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.cpn_dept.model.Xyd_cpn_dept;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 企业组织Dao
 *
 * @author wyframe
 * @Date 2017-09-18 11:38:46
 */
public interface Xyd_cpn_deptDao {

	/**
	 * 获取企业组织管理列表
	 */
	List<Map<String, Object>> list();
	/**
	 * 获取当前分支部门列表
	 */
	List<Map<String, Object>> nowBranchDeptList(@Param("cpnBranchId") Integer cpnBranchId);

	/**
	 * 根据Id获取企业组织信息
	 */
	Xyd_cpn_dept queryById(@Param("xyd_cpn_deptId") Integer xyd_cpn_deptId);

	/**
	 *
	 */
	Map<String,String> iQueryById(@Param("id") Integer id);

	/**
	 * 根据Id获取企业组织名称
	 */
	String selectPCpnDeptNm(@Param("xyd_cpn_deptId") Integer xyd_cpn_deptId);

	/**
	 * 根据Id获取企业信息Id
	 */
	int selectCpnId(@Param("xyd_cpn_deptId") Integer xyd_cpn_deptId);

	/**
	 * 通过企业信息Id查询企业信息名称
	 */
	String selectCpnNm(@Param("cpnId") Integer cpnId);

	List<Map<String, Object>> nowList(@Param("cpnId") Integer cpnId);

	/**
	 * 获取全部企业分支机构
	 */
	List<Map<String, Object>> selectCpns();
	List<Map<String, Object>> selectCpnBranchs();
	int queryCpnId(@Param("userId") Integer userId);

	int queryCpnBrandId(@Param("userId") Integer userId);

	String selectDeptNm(@Param("deptId") Integer deptId);

	/**
	 * 获取当前用户分支机构
	 */
	List<Map<String, Object>> userCpnBranchList(@Param("cpnId") Integer cpnId);

	List<Map<String, Object>> userCpnList(@Param("cpnId") Integer cpnId);

	String queryDeptNm(@Param("Parcpndeptid") Integer Parcpndeptid);

	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date
	 */
	List<ZTreeNode> tree(@Param("cpn_id") Integer cpn_id, @Param("parId") Integer parId, @Param("deptId") Integer deptId);

	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date
	 */
	List<ZTreeNode> depttree();
	Integer isParent(@Param("userDeptId") Integer userDeptId);
	Integer isVeryParent(@Param("userDeptId") Integer userDeptId);
	/**
	 * 获取所有企业组织
	 */
	List<Map<String, Object>> selectCpnDepts(@Param("cpn_dept_id") Integer cpn_dept_id, @Param("condition") String condition);

	void insertCdt(@Param("xyd_cpnId") Integer xyd_cpnId, @Param("cpn_branch_id") Integer cpn_branch_id, @Param("cpn_branch_nm") String cpn_branch_nm, @Param("par_cpn_dept_id") Integer par_cpn_dept_id, @Param("cre_dt") Date cre_dt, @Param("st_id") Integer st_id);
}
