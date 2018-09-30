package wy.addons.zcgl.gongzhonghao.dao;


import wy.addons.zcgl.gongzhonghao.model.Wx_main;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 微信公众号Dao
 *
 * @author wyframe
 * @Date 2017-11-10 10:46:11
 */
public interface Wx_mainDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Wx_main queryById(@Param("wx_mainId") Integer wx_mainId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
}
