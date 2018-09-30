package wy.addons.fxb.xgt_sub_task_obj.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_sub_task_obj.model.Xgt_sub_task_obj;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 作业对象Dao
 *
 * @author wyFrame
 * @Date 2018-09-05 15:45:21
 */
public interface Xgt_sub_task_objDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("over_st_id") Integer over_st_id,@Param("st_id") Integer st_id);

	Xgt_sub_task_obj queryById(@Param("xgt_sub_task_objId") Integer xgt_sub_task_objId);
    List<Map<String, Object>> getMap1();
    List<Map<String, Object>> getMap10();

      void deleteByIds(@Param("list")  List<Integer> list);

    int queryCpnId(@Param("userId") Integer userId);

}
