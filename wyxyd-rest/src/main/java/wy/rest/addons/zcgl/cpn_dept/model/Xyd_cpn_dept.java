package wy.rest.addons.zcgl.cpn_dept.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 企业员工Model
 *
 * @author wyframe
 * @Date 2017-09-18 11:38:46
 */
 public class Xyd_cpn_dept {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="cpn_dept_id", type= IdType.AUTO)
	private Integer cpn_dept_id;
	private Integer cpn_id;
	private Integer cpn_branch_id;
	private String cpn_dept_nm;
	private String cpn_dept_code;
	private Integer par_cpn_dept_id;
	private Integer st_id;
	private Date cre_dt;
	
	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

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
	public String getCpn_dept_nm() {
		return cpn_dept_nm;
	}

	public void setCpn_dept_nm(String cpn_dept_nm) {
		this.cpn_dept_nm = cpn_dept_nm;
	}
	public String getCpn_dept_code() {
		return cpn_dept_code;
	}

	public void setCpn_dept_code(String cpn_dept_code) {
		this.cpn_dept_code = cpn_dept_code;
	}
	public Integer getPar_cpn_dept_id() {
		return par_cpn_dept_id;
	}

	public void setPar_cpn_dept_id(Integer par_cpn_dept_id) {
		this.par_cpn_dept_id = par_cpn_dept_id;
	}
	public Integer getSt_id() {
		return st_id;
	}

	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}


}