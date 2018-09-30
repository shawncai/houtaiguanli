package wy.xydframe.system.dao;

import org.apache.ibatis.annotations.Param;

import wy.common.persistence.model.Page;
import wy.core.node.Node;
import wy.core.node.ZTreeNode;

import java.util.List;
import java.util.Map;

/**
 * 部门dao
 *
 * @author fengshuonan
 * @date 2017年2月17日20:28:58
 */
public interface DeptDao {

    /**
     * 获取ztree的节点列表
     *
     * @return
     * @date 2017年2月17日 下午8:28:43
     */
    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);

    List<Node> tree1();

    List<Node> tree2(@Param("cpnId")Integer cpnId);

    List<Map<String, Object>> list(@Param("condition") String condition,@Param("cpn_dept_id")Integer cpn_dept_id);

    List<Map<String, Object>> list4(@Param("condition") String condition,@Param("id") Integer id);

    int selectPageCount(@Param("page") Page page, @Param("id") Integer id);

    List<Map> selectPageList(@Param("page") Page page,@Param("start") Integer start,@Param("rows") Integer rows,@Param("condition") String condition,@Param("id") Integer id);

    List<Map> selectPageList2(@Param("cpnId")Integer cpnId,@Param("page") Page page,@Param("start") Integer start,@Param("rows") Integer rows,@Param("condition") String condition,@Param("id") Integer id);

    List<Map<String, Object>> list5(@Param("cpnId")Integer cpnId,@Param("condition") String condition,@Param("id") Integer id);

}
