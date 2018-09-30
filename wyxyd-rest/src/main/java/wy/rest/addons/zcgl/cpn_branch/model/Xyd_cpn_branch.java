package wy.rest.addons.zcgl.cpn_branch.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 企业分支机构Model
 *
 * @author wyframe
 * @Date 2017-09-18 11:22:47
 */
 public class Xyd_cpn_branch {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="cpn_branch_id", type= IdType.AUTO)
	private Integer cpn_branch_id;
	private Integer cpn_id;
	private String cpn_branch_nm;
	private String cpn_branch_code;
	private String cpn_branch_phone;
	private Integer cpn_area_id;
	private String cpn_area_desc;
	private Integer user_id;
	private Integer st_id;
	private Date cre_dt;
	
	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

	public Integer getCpn_branch_id() {
		return cpn_branch_id;
	}

	public void setCpn_branch_id(Integer cpn_branch_id) {
		this.cpn_branch_id = cpn_branch_id;
	}
	public Integer getCpn_id() {
		return cpn_id;
	}

	public void setCpn_id(Integer cpn_id) {
		this.cpn_id = cpn_id;
	}
	public String getCpn_branch_nm() {
		return cpn_branch_nm;
	}

	public void setCpn_branch_nm(String cpn_branch_nm) {
		this.cpn_branch_nm = cpn_branch_nm;
	}
	public String getCpn_branch_code() {
		return cpn_branch_code;
	}

	public void setCpn_branch_code(String cpn_branch_code) {
		this.cpn_branch_code = cpn_branch_code;
	}
	public String getCpn_branch_phone() {
		return cpn_branch_phone;
	}

	public void setCpn_branch_phone(String cpn_branch_phone) {
		this.cpn_branch_phone = cpn_branch_phone;
	}
	public Integer getCpn_area_id() {
		return cpn_area_id;
	}

	public void setCpn_area_id(Integer cpn_area_id) {
		this.cpn_area_id = cpn_area_id;
	}
	public String getCpn_area_desc() {
		return cpn_area_desc;
	}

	public void setCpn_area_desc(String cpn_area_desc) {
		this.cpn_area_desc = cpn_area_desc;
	}
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getSt_id() {
		return st_id;
	}

	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}

	@Override
	public String toString() {
		return "Xyd_cpn_branch [cpn_branch_id=" + cpn_branch_id + ", cpn_id=" + cpn_id + ", cpn_branch_nm="
				+ cpn_branch_nm + ", cpn_branch_code=" + cpn_branch_code + ", cpn_branch_phone=" + cpn_branch_phone
				+ ", cpn_area_id=" + cpn_area_id + ", cpn_area_desc=" + cpn_area_desc + ", user_id=" + user_id
				+ ", st_id=" + st_id + ", cre_dt=" + cre_dt + "]";
	}
	

}