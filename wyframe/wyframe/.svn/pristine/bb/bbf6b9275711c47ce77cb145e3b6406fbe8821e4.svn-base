package wy.addons.fxb.xgt_sub_task_dtl.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_sub_task_dtl.model.Xgt_sub_task_dtl;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 任务详情Dao
 *
 * @author wyFrame
 * @Date 2018-09-05 15:20:52
 */
public interface Xgt_sub_task_dtlDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("st_id") Integer st_id);

	Xgt_sub_task_dtl queryById(@Param("xgt_sub_task_dtlId") Integer xgt_sub_task_dtlId);
    List<Map<String, Object>> getMap1();
    List<Map<String, Object>> getMap9();

      void deleteByIds(@Param("list")  List<Integer> list);
}
