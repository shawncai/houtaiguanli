package wy.addons.zcgl.wyitem.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 栏目Model
 *
 * @author wyframe
 * @Date 2017-11-08 10:21:13
 */
 public class Xgt_wy_item {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="item_id", type= IdType.AUTO)
	private Integer item_id;
	private String item_nm;
	private String item_nm_alias;
	private String item_dsc;
	private Integer item_cls;
	private Integer par_item_id;
	private Integer seq_no;
	private Integer st_id;
	private String oper_user;
	private Date cre_dt;
	
	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_nm() {
		return item_nm;
	}

	public void setItem_nm(String item_nm) {
		this.item_nm = item_nm;
	}
	public String getItem_nm_alias() {
		return item_nm_alias;
	}

	public void setItem_nm_alias(String item_nm_alias) {
		this.item_nm_alias = item_nm_alias;
	}
	public String getItem_dsc() {
		return item_dsc;
	}

	public void setItem_dsc(String item_dsc) {
		this.item_dsc = item_dsc;
	}
	public Integer getItem_cls() {
		return item_cls;
	}

	public void setItem_cls(Integer item_cls) {
		this.item_cls = item_cls;
	}
	public Integer getPar_item_id() {
		return par_item_id;
	}

	public void setPar_item_id(Integer par_item_id) {
		this.par_item_id = par_item_id;
	}
	public Integer getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
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


}