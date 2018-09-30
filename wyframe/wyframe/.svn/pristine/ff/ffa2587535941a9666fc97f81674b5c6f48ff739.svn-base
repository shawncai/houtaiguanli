package wy.addons.zcgl.topic.dao;


import wy.addons.zcgl.topic.model.Xgt_wy_topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 站点栏目Dao
 *
 * @author wyframe
 * @Date 2017-11-09 10:39:19
 */
public interface Xgt_wy_topicDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Xgt_wy_topic queryById(@Param("xgt_wy_topicId") Integer xgt_wy_topicId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
	
	void deletePar(@Param("id") Integer id);
	
}
