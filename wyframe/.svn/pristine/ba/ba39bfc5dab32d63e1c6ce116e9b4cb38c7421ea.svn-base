package wy.addons.zcgl.image.dao;


import wy.addons.zcgl.image.model.Xyd_image_file;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 图片Dao
 *
 * @author wyframe
 * @Date 2017-11-09 16:30:08
 */
public interface Xyd_image_fileDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Xyd_image_file queryById(@Param("xyd_image_fileId") Integer xyd_image_fileId);
	
	
	Map<String,String> iQueryById(@Param("id") Integer id);
}
