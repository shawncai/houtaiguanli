package wy.addons.zcgl.prdCls.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 产品分类Model
 *
 * @author wyframe
 * @Date 2017-11-21 21:10:33
 */
 public class Xgt_goods_prd_cls {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="prd_cls_id", type= IdType.AUTO)
	private Integer prd_cls_id;
	private String prd_cls_nm;
	private String prd_cls_alias;
	private Integer par_prd_cls_id;
	private Integer cpn_id;
	private Integer cpn_branch_id;
	private Integer st_id;
	private String oper_user;
	private Date cre_dt;
	private Integer sn_flg;
	private  String cls_code;

	public Integer getPrd_cls_id() {
		return prd_cls_id;
	}

	public void setPrd_cls_id(Integer prd_cls_id) {
		this.prd_cls_id = prd_cls_id;
	}

	public String getPrd_cls_nm() {
		return prd_cls_nm;
	}

	public void setPrd_cls_nm(String prd_cls_nm) {
		this.prd_cls_nm = prd_cls_nm;
	}

	public String getPrd_cls_alias() {
		return prd_cls_alias;
	}

	public void setPrd_cls_alias(String prd_cls_alias) {
		this.prd_cls_alias = prd_cls_alias;
	}

	public Integer getPar_prd_cls_id() {
		return par_prd_cls_id;
	}

	public void setPar_prd_cls_id(Integer par_prd_cls_id) {
		this.par_prd_cls_id = par_prd_cls_id;
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

	public Integer getSt_id() {
		return st_id;
	}

	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}

	public String getOper_user() {
		return oper_user;
	}

	public void setOper_user(String oper_user) {
		this.oper_user = oper_user;
	}

	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

	public Integer getSn_flg() {
		return sn_flg;
	}

	public void setSn_flg(Integer sn_flg) {
		this.sn_flg = sn_flg;
	}

	public String getCls_code() {
		return cls_code;
	}

	public void setCls_code(String cls_code) {
		this.cls_code = cls_code;
	}
}