package wy.addons.zcgl.orde.dao;


import wy.addons.zcgl.orde.model.Xyd_total;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 订单Dao
 *
 * @author wyframe
 * @Date 2017-08-24 15:49:09
 */
public interface Xyd_totalDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Xyd_total queryById(@Param("xyd_totalId") Integer xyd_totalId);
	
	List<Map<String, Object>> paramsList(@Param("condition") String condition);
	
	List<Map<String, Object>> param(@Param("list") List<Integer> list);
		
	List<Map<String, Object>> selectDetail(@Param("id") Integer id);
	
	int insertTotal(@Param("map") Map<String,Object> map);
	
	int insertDetail(@Param("map2") List<Map<String,Object>> map2);
	
	void deleteParam(@Param("xyd_totalId") Integer xyd_totalId);
	
	void deleteTotal(@Param("xyd_totalId") Integer xyd_totalId);
	
	void deleteDetl(@Param("id")Integer id);
	
	
}
