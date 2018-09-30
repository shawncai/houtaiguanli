package wy.addons.zcgl.xydcpn.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import wy.addons.zcgl.xydcpn.model.Xyd_cpn;
import org.apache.ibatis.annotations.Param;

/**
 * 企业Dao
 *
 * @author wyframe
 * @Date 2017-09-08 17:08:38
 */
public interface Xyd_cpnDao {

	/**
	 * 获取全部企业信息
	 */
	List<Map<String, Object>> list(@Param("cpn_nm") String cpn_nm, @Param("cpn_cata_id") Integer cpn_cata_id);
	List<Map<String, Object>> spList();
	List<Map<String, Object>> nowList(@Param("cpnId") Integer cpnId);
	
	List<Map<String, Object>> cpnStlist(@Param("cpn_nm") String cpn_nm, @Param("cpn_st") Integer cpn_st);
//	List<Map<String, Object>> list(@Param("cpn_nm") String cpn_nm);

	List<Map<String, Object>> selectByCpnNm(@Param("cpnNm") String cpnNm);
	
	/**
	 * 通过企业信息Id查询企业信息
	 */
	Xyd_cpn queryById(@Param("xyd_cpnId") Integer xyd_cpnId);
	
	/**
	 * 通过企业信息Id查询企业信息名称
	 */
	String selectCpnCataNmByCpnId(@Param("xyd_cpnId") Integer xyd_cpnId);
	
	String queryCpnName(@Param("cpnId") Integer cpnId);
	
	/**
	 * 
	 */
	String selectCardUrl1Name(@Param("xyd_cpnId") Integer xyd_cpnId);
	
	/**
	 * 
	 */
	Map<String,String> iQueryById(@Param("id") Integer id);
	
	/**
	 * 查询所有企业信息
	 */
	List<Map<String, Object>> cpnList();
	
	/**
	 * 通过企业信息Id查询企业信息名称
	 */
	String selectCpnNm(@Param("cpnId") Integer cpnId);
	
    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 
     */
//	List<ZTreeNode> tree();
	
	/**
	 * 查询所有企业信息
	 */
	List<Map<String, Object>> selectCpnList();
	
	int updateCpnById(@Param("xyd_cpnId") Integer xyd_cpnId);
	
	int checkNotGoCpn(@Param("xyd_cpnId") Integer xyd_cpnId, @Param("approval_opinion") String approval_opinion);
	
	String selectCpnName(@Param("xyd_cpnId") Integer xyd_cpnId);
	String selectCpnWas(@Param("xyd_cpnId") Integer xyd_cpnId);
	int selectCpnWad(@Param("xyd_cpnId") Integer xyd_cpnId);
	int selectCpnSt(@Param("xyd_cpnId") Integer xyd_cpnId);
	Date selectCpnCrd(@Param("xyd_cpnId") Integer xyd_cpnId);
}
