package wy.addons.fxb.xgt_sub_task.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_sub_task.model.Xgt_sub_task;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 作业任务Dao
 *
 * @author wyFrame
 * @Date 2018-09-05 11:51:57
 */
public interface Xgt_sub_taskDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("st_id") Integer st_id);

	Xgt_sub_task queryById(@Param("xgt_sub_taskId") Integer xgt_sub_taskId);
    List<Map<String, Object>> getMap2();
    List<Map<String, Object>> getMap3();
    List<Map<String, Object>> getMap4();
    List<Map<String, Object>> getMap6();

    List<Map<String, Object>>FindClass();
    List<Map> ClassOne(@Param("cpn_dept_id")Integer cpn_dept_id);

    List<Map> ClassFive(@Param("cpn_dept_id")Integer cpn_dept_id);
      void deleteByIds(@Param("list")  List<Integer> list);

    int queryCpnId(@Param("userId") Integer userId);

}
