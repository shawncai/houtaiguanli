package wy.addons.fxb.xgt_sub_exam.model;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.models.auth.In;

/**
 * 试卷Model
 *
 * @author wyFrame
 * @Date 2018-09-04 11:49:20
 */
 public class Xgt_sub_exam {

    private static final long serialVersionUID = 1L;

	@TableId(value="sub_exam_id", type= IdType.AUTO)
	private Integer sub_exam_id;
	private String sub_exam_nm;
	private Integer par_sub_exam_id;
	private Integer sub_id;
	private Integer id;
	private String sub_exam_no;
	private Integer one_sel_sum;
	private Integer more_sel_sum;
	private Integer yes_no_sum;
	private Integer insert_sum;
	private Integer spec_qp_sum;
	private String mdi_dt;
	private Date cre_dt;
	private Integer st_id;
	private Integer cpn_id;

	public Integer getCpn_id() {
		return cpn_id;
	}

	public void setCpn_id(Integer cpn_id) {
		this.cpn_id = cpn_id;
	}

	public Integer getSub_exam_id() {
		return sub_exam_id;
	}

	public void setSub_exam_id(Integer sub_exam_id) {
		this.sub_exam_id = sub_exam_id;
	}
	public String getSub_exam_nm() {
		return sub_exam_nm;
	}

	public void setSub_exam_nm(String sub_exam_nm) {
		this.sub_exam_nm = sub_exam_nm;
	}
	public Integer getPar_sub_exam_id() {
		return par_sub_exam_id;
	}

	public void setPar_sub_exam_id(Integer par_sub_exam_id) {
		this.par_sub_exam_id = par_sub_exam_id;
	}
	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getSub_exam_no() {
		return sub_exam_no;
	}

	public void setSub_exam_no(String sub_exam_no) {
		this.sub_exam_no = sub_exam_no;
	}
	public Integer getOne_sel_sum() {
		return one_sel_sum;
	}

	public void setOne_sel_sum(Integer one_sel_sum) {
		this.one_sel_sum = one_sel_sum;
	}
	public Integer getMore_sel_sum() {
		return more_sel_sum;
	}

	public void setMore_sel_sum(Integer more_sel_sum) {
		this.more_sel_sum = more_sel_sum;
	}
	public Integer getYes_no_sum() {
		return yes_no_sum;
	}

	public void setYes_no_sum(Integer yes_no_sum) {
		this.yes_no_sum = yes_no_sum;
	}
	public Integer getInsert_sum() {
		return insert_sum;
	}

	public void setInsert_sum(Integer insert_sum) {
		this.insert_sum = insert_sum;
	}
	public Integer getSpec_qp_sum() {
		return spec_qp_sum;
	}

	public void setSpec_qp_sum(Integer spec_qp_sum) {
		this.spec_qp_sum = spec_qp_sum;
	}
	public String getMdi_dt() {
		return mdi_dt;
	}

	public void setMdi_dt(String mdi_dt) {
		this.mdi_dt = mdi_dt;
	}

	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

	public Integer getSt_id() {
		return st_id;
	}

	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}
}