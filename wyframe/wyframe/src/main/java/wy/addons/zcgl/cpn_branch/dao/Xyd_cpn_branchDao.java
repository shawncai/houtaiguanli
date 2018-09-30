package wy.addons.zcgl.cpn_branch.dao;


import org.apache.ibatis.annotations.Param;
import wy.addons.zcgl.cpn_branch.model.Xyd_cpn_branch;
import wy.xydframe.sysArea.model.Sys_area;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 企业分支机构Dao
 *
 * @author wyframe
 * @Date 2017-09-18 11:22:47
 */
public interface Xyd_cpn_branchDao {

	/**
	 * 获取企业分支机构列表
	 */
	List<Map<String, Object>> list(@Param("cpn_id") Integer cpn_id);
	/**
	 * /**
	 * 获取企业分支机构列表
	 */
	List<Map<String, Object>> list2(@Param("cpn_id") Integer cpn_id,@Param("condition") String condition);
	/**
	 * 获取当前企业分支机构列表
	 */
	List<Map<String, Object>> nowCpnBranchList(@Param("cpnId") Integer cpnId);
	/**
	 * 获取当前用户分支机构
	 */
	List<Map<String, Object>> userCpnBranchList(@Param("branchId") Integer branchId);

	/**
	 * 根据ID查询企业分支机构
	 */
	Xyd_cpn_branch queryById(@Param("xyd_cpn_branchId") Integer xyd_cpn_branchId);

	/**
	 *
	 */
	Map<String,String> iQueryById(@Param("id") Integer id);

	/**
	 * 根据ID查询企业信息ID
	 */
	int selectCpnId(@Param("xyd_cpn_branchId") Integer xyd_cpn_branchId);

	int selectCpnBranchId(@Param("xyd_cpnId") Integer xyd_cpnId);

	String queryCpnBranchName(@Param("cpnBranchId") Integer cpnBranchId);

	/**
	 * 根据ID查询企业分支机构的名称
	 */
	String selectCpnBranchNm(@Param("cpnBranchId") Integer cpnBranchId);

	/**
	 * 获取全部企业分支机构
	 */
	List<Map<String, Object>> selectCpnBranch();

	/**
	 * 获取全部企业分支机构
	 */
	List<Map<String, Object>> selectCpnBranchs();

	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date 2017年2月17日 下午8:28:43
	 */
	List<Map<String, Object>> tree();

	void insertCbh(@Param("xyd_cpnId") Integer xyd_cpnId,@Param("cpn_branch_nm") String cpn_branch_nm,@Param("cpn_area_id") Integer cpn_area_id,@Param("cpn_area_desc") String cpn_area_desc,@Param("cre_dt") Date cre_dt,@Param("st_id") Integer st_id);

	List<Integer>queryCpndeptId(@Param("xyd_cpnId") Integer xyd_cpnId);

	String selectByBranchAreaName(@Param("areaId") Integer areaId);

	Sys_area selectByAreaId(@Param("areaId") Integer areaId);

	void insertCdt(@Param("xyd_cpnId") Integer xyd_cpnId,@Param("cpn_branch_id") Integer cpn_branch_id,@Param("cpn_branch_nm") String cpn_branch_nm,@Param("par_cpn_dept_id") Integer par_cpn_dept_id,@Param("cre_dt") Date cre_dt,@Param("st_id") Integer st_id);

	int queryCpnId(@Param("userId") Integer userId);

	int queryCpnBrandId(@Param("userId") Integer userId);

	String selectCpnNm(@Param("cpnId") Integer cpnId);

	List<Map<String, Object>> userCpnList(@Param("cpnId") Integer cpnId);
}
