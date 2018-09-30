package wy.addons.fxb.xgt_sub_task.model;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.models.auth.In;

/**
 * 作业任务Model
 *
 * @author wyFrame
 * @Date 2018-09-05 11:51:57
 */
 public class Xgt_sub_task {

    private static final long serialVersionUID = 1L;

	@TableId(value="task_id", type= IdType.AUTO)
	private Integer task_id;
	private String task_nm;
	private Integer id;
	private Integer sub_exam_id;
	private Integer sub_id;
	private String task_ask;
	private String over_dt;
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

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public String getTask_nm() {
		return task_nm;
	}

	public void setTask_nm(String task_nm) {
		this.task_nm = task_nm;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSub_exam_id() {
		return sub_exam_id;
	}

	public void setSub_exam_id(Integer sub_exam_id) {
		this.sub_exam_id = sub_exam_id;
	}
	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}
	public String getTask_ask() {
		return task_ask;
	}

	public void setTask_ask(String task_ask) {
		this.task_ask = task_ask;
	}
	public String getOver_dt() {
		return over_dt;
	}

	public void setOver_dt(String over_dt) {
		this.over_dt = over_dt;
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