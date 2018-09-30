package wy.xydframe.system.dao;

import wy.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色相关的dao
 *
 * @author fengshuonan
 * @date 2017年2月12日 下午8:43:52
 */
public interface RoleDao {

    /**
     * 根据条件查询角色列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectRoles(@Param("condition") String condition);
    List<Map<String, Object>> showRoles(@Param("roleId") Integer roleId);
    /**
     * 删除某个角色的所有权限
     *
     * @param roleId 角色id
     * @return
     * @date 2017年2月13日 下午7:57:51
     */
    int deleteRolesById(@Param("roleId") Integer roleId);
    
    int getRolesPid(@Param("roleId") Integer roleId);
    
//    int getOnclickRolesId(@Param("roleid") String roleid);

    /**
     * 获取角色列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> tree(@Param("id") Integer id);

    List<ZTreeNode> roleTreeList();
    
    List<Integer> getRolesId(@Param("userRoleId") Integer userRoleId);
    
    List<ZTreeNode> roleSomeTreeList(List<Integer> nowRolesIds);
    
//    List<Integer> getOnclickRolesId(@Param("roleid") String roleid);

    /**
     * 获取角色列表树
     *
     * @return
     * @date 2017年2月18日 上午10:32:04
     */
    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);
    
    List<ZTreeNode> roleSomeTreeListByRoleId(@Param("array") String[] roleId,@Param("list")List<Integer> nowRolesIds);
    
    String getRoleName(@Param("roleid") String roleid);
    
    


}
