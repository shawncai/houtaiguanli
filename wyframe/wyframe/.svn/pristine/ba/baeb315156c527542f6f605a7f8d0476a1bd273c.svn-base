package wy.addons.zcgl.auto_reply.dao;


import org.apache.ibatis.annotations.Param;
import wy.addons.zcgl.auto_reply.model.Wx_auto_reply;

import java.util.List;
import java.util.Map;
/**
 * 自动回复Dao
 *
 * @author wyframe
 * @Date 2017-10-23 17:20:43
 */
public interface Wx_auto_replyDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Wx_auto_reply queryById(@Param("wx_auto_replyId") Integer wx_auto_replyId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
}
