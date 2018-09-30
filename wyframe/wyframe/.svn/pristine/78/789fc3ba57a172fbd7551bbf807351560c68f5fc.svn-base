package wy.addons.fxb.xgt_sub_qp.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_sub_qp.model.Xgt_sub_qp;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 题目Dao
 *
 * @author wyFrame
 * @Date 2018-09-12 16:19:48
 */
public interface Xgt_sub_qpDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("st_id") Integer st_id);

	Xgt_sub_qp queryById(@Param("xgt_sub_qpId") Integer xgt_sub_qpId);
    List<Map<String, Object>> getMap2();
    List<Map<String, Object>> getMap3();
    List<Map<String, Object>> getMap18();
    int queryCpnId(@Param("userId") Integer userId);
      void deleteByIds(@Param("list")  List<Integer> list);
}
