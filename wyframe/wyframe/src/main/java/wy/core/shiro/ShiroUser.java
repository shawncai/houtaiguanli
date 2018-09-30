package wy.core.shiro;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 * @author fengshuonan
 * @date 2016年12月5日 上午10:26:43
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public Integer deptId;      // 部门ID
    public List<Integer> roleList; // 角色集
    public String deptName;        // 部门名称
    public List<String> roleNames; // 角色名称集
    
	private Integer cpn_id;
	private Integer cpn_branch_id;

	private Integer prd_vendor_id;
	private Integer cpn_store_id;
	private String brok_user;

    public Integer getPrd_vendor_id() {
        return prd_vendor_id;
    }

    public void setPrd_vendor_id(Integer prd_vendor_id) {
        this.prd_vendor_id = prd_vendor_id;
    }

    public Integer getCpn_store_id() {
        return cpn_store_id;
    }

    public void setCpn_store_id(Integer cpn_store_id) {
        this.cpn_store_id = cpn_store_id;
    }

    public String getBrok_user() {
        return brok_user;
    }

    public void setBrok_user(String brok_user) {
        this.brok_user = brok_user;
    }

    public Integer getCpn_id() {
		return cpn_id;
	}

	public void setCpn_id(Integer cpn_id) {
		this.cpn_id = cpn_id;
	}

	public Integer getCpn_branch_id() {
		return cpn_branch_id;
	}

	public void setCpn_branch_id(Integer cpn_branch_id) {
		this.cpn_branch_id = cpn_branch_id;
	}
    
//    public Integer pId;         // 上级用户ID
//    
//    public Integer getpId() {
//		return pId;
//	}
//
//	public void setpId(Integer pId) {
//		this.pId = pId;
//	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

}
