package wy.xydframe.system.transfer;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户传输bean
 * 
 * @author wy
 * @Date 2017/5/5 22:40
 */
public class UserDto{

	private Integer id;
	private String account;
	private String password;
	private String salt;
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Integer sex;
	private String email;
	private String phone;
	private String roleid;
	private Integer deptid;
	private Integer status;
	private Date createtime;
	private Integer version;
	private String avatar;

	private Integer cpn_id;
	private Integer cpn_branch_id;
	private Integer par_cpn_dept_id;
	private Integer cpn_dept_id;

	public Integer getCpn_dept_id() {
		return cpn_dept_id;
	}

	public void setCpn_dept_id(Integer cpn_dept_id) {
		this.cpn_dept_id = cpn_dept_id;
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

	public Integer getPar_cpn_dept_id() {
		return par_cpn_dept_id;
	}

	public void setPar_cpn_dept_id(Integer par_cpn_dept_id) {
		this.par_cpn_dept_id = par_cpn_dept_id;
	}

	private Integer parentid;

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roleid='" + roleid + '\'' +
                ", deptid=" + deptid +
                ", status=" + status +
                ", createtime=" + createtime +
                ", version=" + version +
                ", avatar='" + avatar + '\'' +
                ", cpn_id=" + cpn_id +
                ", cpn_branch_id=" + cpn_branch_id +
                ", par_cpn_dept_id=" + par_cpn_dept_id +
                ", parentid=" + parentid +
                '}';
    }
}
