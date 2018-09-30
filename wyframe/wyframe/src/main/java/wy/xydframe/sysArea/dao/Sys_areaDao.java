package wy.xydframe.sysArea.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;
import wy.common.persistence.model.Page;
import wy.core.node.Node;
import wy.core.node.ZTreeNode;
import wy.xydframe.sysArea.model.Sys_area;

/**
 * 地区Dao
 *
 * @author wyznn
 * @Date 2017-09-04 15:53:52
 */
public interface Sys_areaDao {

	String selectAreaNm (@Param("areaId") Integer areaId);

	String queryAreaName(@Param("parAreaId") Integer parAreaId);
	List<Map<String, Object>> queryProvList();

	List<Map<String, Object>> queryCityList(@Param("prov_id") Integer prov_id);
	List<Map<String, Object>> queryRegionList(@Param("city_id") Integer city_id);

	List<Map<String, Object>> list(@Param("condition") String condition,@Param("area_id")Integer area_id);

	Sys_area queryById(@Param("sys_areaId") Integer sys_areaId);

	/**
	 * 获取ztree的节点列表
	 *
	 * @return
	 * @date
	 */
	List<ZTreeNode> tree();

	Sys_area queryPaid(@Param("pad") Integer pad);
	
	int selectAddId(@Param("sys_area") Sys_area sys_area);

	Sys_area selectByWorkAreaId(@Param("workAreaId") Integer workAreaId);

	Sys_area selectByAreaId(@Param("areaId") Integer areaId);

	Sys_area selectByCodeAreaId(@Param("codeAreaId") Integer codeAreaId);

	String selectByWorkAreaName(@Param("workAreaId") Integer workAreaId);

	String selectByCodeAreaName(@Param("codeAreaId") Integer codeAreaId);

	String selectByBranchAreaName(@Param("areaId") Integer areaId);

	List<Node> tree1();

	List<Map<String, Object>> list4(@Param("condition") String condition,@Param("id") Integer id);

	int selectPageCount(@Param("page") Page page, @Param("id") Integer id);

	List<Map> selectPageList(@Param("page") Page page,@Param("start") Integer start,@Param("rows") Integer rows,@Param("condition") String condition,@Param("id") Integer id);
}