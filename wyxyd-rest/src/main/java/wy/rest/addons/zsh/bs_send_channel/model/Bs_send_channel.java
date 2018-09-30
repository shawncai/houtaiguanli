package wy.rest.addons.zsh.bs_send_channel.model;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 配送商Model
 *
 * @author wyFrame
 * @Date 2018-07-25 14:28:36
 */
 public class Bs_send_channel {

    private static final long serialVersionUID = 1L;

	@TableId(value="send_chnl_id", type= IdType.AUTO)
	private Integer send_chnl_id;
	private String send_chnl_no;
	private String send_chnl_nm;
	private String send_chnl_desc;
	private String send_chnl_phoe;
	private Integer send_chnl_num;
	private Integer send_chnl_flg;
	private Integer xyd_st_id;
	private String xyd_cre_dt;
	private String xyd_up_dt;
	private Integer id;

	public Integer getSend_chnl_id() {
		return send_chnl_id;
	}

	public void setSend_chnl_id(Integer send_chnl_id) {
		this.send_chnl_id = send_chnl_id;
	}
	public String getSend_chnl_no() {
		return send_chnl_no;
	}

	public void setSend_chnl_no(String send_chnl_no) {
		this.send_chnl_no = send_chnl_no;
	}
	public String getSend_chnl_nm() {
		return send_chnl_nm;
	}

	public void setSend_chnl_nm(String send_chnl_nm) {
		this.send_chnl_nm = send_chnl_nm;
	}
	public String getSend_chnl_desc() {
		return send_chnl_desc;
	}

	public void setSend_chnl_desc(String send_chnl_desc) {
		this.send_chnl_desc = send_chnl_desc;
	}
	public String getSend_chnl_phoe() {
		return send_chnl_phoe;
	}

	public void setSend_chnl_phoe(String send_chnl_phoe) {
		this.send_chnl_phoe = send_chnl_phoe;
	}
	public Integer getSend_chnl_num() {
		return send_chnl_num;
	}

	public void setSend_chnl_num(Integer send_chnl_num) {
		this.send_chnl_num = send_chnl_num;
	}
	public Integer getSend_chnl_flg() {
		return send_chnl_flg;
	}

	public void setSend_chnl_flg(Integer send_chnl_flg) {
		this.send_chnl_flg = send_chnl_flg;
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