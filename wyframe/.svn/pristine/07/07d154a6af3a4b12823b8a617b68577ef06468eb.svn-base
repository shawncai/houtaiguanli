package wy.addons.zcgl.menu.dao;


import wy.addons.zcgl.menu.model.Wx_menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 自定义菜单Dao
 *
 * @author wyframe
 * @Date 2017-11-10 10:05:28
 */
public interface Wx_menuDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Wx_menu queryById(@Param("wx_menuId") Integer wx_menuId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
}
