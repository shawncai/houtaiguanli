package wy.addons.fxb.xgt_subject.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_subject.model.Xgt_subject;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 科目Dao
 *
 * @author wyFrame
 * @Date 2018-09-05 10:03:14
 */
public interface Xgt_subjectDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("xyd_st_id") Integer xyd_st_id);

	Xgt_subject queryById(@Param("xgt_subjectId") Integer xgt_subjectId);
    List<Map<String, Object>> getMap2();
    List<Map<String, Object>> getMap6();

      void deleteByIds(@Param("list")  List<Integer> list);

    int queryCpnId(@Param("userId") Integer userId);

}
