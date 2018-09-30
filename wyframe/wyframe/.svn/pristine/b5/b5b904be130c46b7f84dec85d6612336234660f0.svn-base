package wy.addons.zcgl.cpn_room.dao;


import wy.addons.zcgl.cpn_room.model.Xgt_cpn_room;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 房间Dao
 *
 * @author wyframe
 * @Date 2018-01-03 15:02:19
 */
public interface Xgt_cpn_roomDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	List<Map<String, Object>> list2(@Param("condition") String condition);

	Xgt_cpn_room queryById(@Param("xgt_cpn_roomId") Integer xgt_cpn_roomId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
}
