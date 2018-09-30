package wy.addons.fxb.xgt_subject.model;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 科目Model
 *
 * @author wyFrame
 * @Date 2018-09-05 10:03:14
 */
 public class Xgt_subject {

    private static final long serialVersionUID = 1L;

	@TableId(value="sub_id", type= IdType.AUTO)
	private Integer sub_id;
	private String sub_nm;
	private Integer cpn_id;
	private Integer xyd_st_id;
	private String xyd_cre_dt;
	private String xyd_up_dt;
	private Integer id;

	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_nm() {
		return sub_nm;
	}

	public void setSub_nm(String sub_nm) {
		this.sub_nm = sub_nm;
	}
	public Integer getCpn_id() {
		return cpn_id;
	}

	public void setCpn_id(Integer cpn_id) {
		this.cpn_id = cpn_id;
	}
	public Integer getXyd_st_id() {
		return xyd_st_id;
	}

	public void setXyd_st_id(Integer xyd_st_id) {
		this.xyd_st_id = xyd_st_id;
	}
	public String getXyd_cre_dt() {
		return xyd_cre_dt;
	}

	public void setXyd_cre_dt(String xyd_cre_dt) {
		this.xyd_cre_dt = xyd_cre_dt;
	}
	public String getXyd_up_dt() {
		return xyd_up_dt;
	}

	public void setXyd_up_dt(String xyd_up_dt) {
		this.xyd_up_dt = xyd_up_dt;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}