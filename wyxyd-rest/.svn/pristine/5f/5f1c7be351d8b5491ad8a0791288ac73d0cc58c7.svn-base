package wy.rest.common.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.common.persistence.model.User;

import java.util.List;
import java.util.Map;

/**
 * 管理员的dao
 *
 * @author wyxyd
 * @date 2017年2月12日 下午8:43:52
 */
public interface UserMgrDao {

    /**
     * 修改用户状态
     *
     * @date 2017年2月12日 下午8:42:31
     */
    int setStatus(@Param("userId") Integer userId, @Param("status") int status);

    /**
     * 删除用户
     *
     * @param 
     * @date 
     */
    void deleteUser(@Param("userId") Integer userId);
    
    int queryCpnId(@Param("userId") Integer userId);
    
    int queryCpnBrandId(@Param("userId") Integer userId);

    int selectCpnId(@Param("deptId") Integer deptId);

    int selectCpnBrandId(@Param("deptId") Integer deptId);
    
//    int selectUserRoleId(@Param("userNowId") Integer userNowId);
    
    /**
     * 修改密码
     *
     * @param userId
     * @param pwd
     * @date 2017年2月12日 下午8:54:19
     */
    int changePwd(@Param("userId") Integer userId, @Param("pwd") String pwd);

    /**
     * 根据条件查询用户列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectUsers(@Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("deptid") Integer deptid);

    /**
     * 根据条件查询用户列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    List<Map<String, Object>> selectSomeUsers(@Param("cpnId") Integer cpnId, @Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("deptid") Integer deptid);

    /**
     * 设置用户的角色
     *
     * @return
     * @date 2017年2月13日 下午7:31:30
     */
    int setRoles(@Param("userId") Integer userId, @Param("roleIds") String roleIds);

    /**
     * 设置用户的角色
     *
     * @return
     * @date 2018年8月1日 下午5:12:08
     */
    int setDepts(@Param("userId") Integer userId, @Param("deptIds") String deptIds);

    int setCpnAndCpnBranch(@Param("deptid") Integer deptid, @Param("cpnBranchId") Integer cpnBranchId, @Param("cpnId") Integer cpnId);
    /**
     * 通过账号获取用户
     *
     * @param account
     * @return
     * @date 2017年2月17日 下午11:07:46
     */
    User getByAccount(@Param("account") String account);

    /**
     * 通过ID获取角色ID
     *
     * @param userId
     * @return
     * @date 2017年2月17日 下午11:07:46
     */
    String getRoles(@Param("userId") Integer userId);

    /**
     * 根据部门ID查询部门名称
     *
     * @param
     * @date
     */
    String selectUserDeptName(@Param("userDeptId") Integer userDeptId);

    /**
     * 根据用户ID删除当前已分配地区
     *
     * @param
     * @date
     */
    void deleteArea(@Param("userId") Integer userId);


    /**
     * 根据用户ID获取该用户已分配的地区
     *
     * @param
     * @date
     */
    List<Integer> selectAreaIdById(@Param("userId") Integer userId);

    List<Integer> selectDeptIdById(@Param("userId") Integer userId);

    List<Integer> selectAreaIdByNowId(@Param("userNowId") Integer userNowId);

    /**
     * 获取全部地区列表
     *
     * @param
     * @date
     */
    List<ZTreeNode> areaTreeList();

    /**
     * 根据当前登录用户ID获取当前登录用户已分配地区
     *
     * @param
     * @date
     */
    List<ZTreeNode> areaSomeTreeList(@Param("userNowId") Integer userNowId);

    /**
     * 根据当前用户ID，回显已分配的地区
     *
     * @param
     * @date
     */
    List<ZTreeNode> areaTreeListById(@Param("array") String[] strArray, @Param("userId") Integer userId);

    /**
     * 根据当前用户ID，回显已分配的地区
     *
     * @param
     * @date
     */
    List<ZTreeNode> areaSomeTreeListById(@Param("array") String[] strArray, @Param("userNowId") Integer userNowId, @Param("userId") Integer userId);

    List<Map<String, Object>> findByNameOrNo(@Param("condition") String condition);

    List<ZTreeNode> deptTreeList();

    List<ZTreeNode> deptSomeTreeList(@Param("userNowId") Integer userNowId);

    List<ZTreeNode> deptTreeListById(@Param("array") String[] strArray, @Param("userId") Integer userId);

    List<ZTreeNode> deptSomeTreeListById(@Param("array") String[] strArray, @Param("userNowId") Integer userNowId, @Param("userId") Integer userId);

    int selectdeptId(@Param("userId") Integer userId);

    int selectCpn(@Param("deptid") Integer deptid);

    int selectCpnBrand(@Param("deptid") Integer deptid);

    int setUserDept(@Param("userId") Integer userId, @Param("deptIds") String deptIds);

    int setUserCpnAndCpnBranch(@Param("deptid") Integer deptid, @Param("cpnBranchId") Integer cpnBranchId, @Param("cpnId") Integer cpnId);

    List<Map<String, Object>> list4(@Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("id") Integer id);

    int selectPageCount(@Param("page") Page page, @Param("id") Integer id);

    List<Map> selectPageList(@Param("page") Page page, @Param("start") Integer start, @Param("rows") Integer rows, @Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("id") Integer id);
}
