package wy.addons.fxb.xgt_sub_exam.dao;
import java.util.List;
import java.util.Map;
import wy.addons.fxb.xgt_sub_exam.model.Xgt_sub_exam;
import org.apache.ibatis.annotations.Param;
import wy.core.node.Node;
import wy.common.persistence.model.Page;
/**
 * 试卷Dao
 *
 * @author wyFrame
 * @Date 2018-09-04 11:49:19
 */
public interface Xgt_sub_examDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("st_id") Integer st_id);

	Xgt_sub_exam queryById(@Param("xgt_sub_examId") Integer xgt_sub_examId);
    List<Map<String, Object>> getMap2();
    List<Map<String, Object>> getMap3();
    List<Map<String, Object>> getMap4();

      void deleteByIds(@Param("list")  List<Integer> list);

       List<Map<String, Object>> getMapByPar();

       List<Node> tree1();

          List<Map<String, Object>> list4(@Param("condition") String condition,@Param("id") Integer id);

          int selectPageCount(@Param("page") Page page, @Param("id") Integer id);

          List<Map> selectPageList(@Param("page") Page page,@Param("start") Integer start,@Param("rows") Integer rows,@Param("id") Integer id,@Param("condition") String condition);

    int queryCpnId(@Param("userId") Integer userId);
}
