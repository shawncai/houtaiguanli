package wy.addons.zcgl.xydcpn.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 企业Model
 *
 * @author wyframe
 * @Date 2017-09-08 17:08:38
 */
 public class Xyd_cpn extends Model<Xyd_cpn> {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="cpn_id", type= IdType.AUTO)
	private Integer cpn_id;
	private Integer cpn_cata_id;
	private String cpn_code;
	private String cpn_nm;
	private String cpn_main_nm;
	private String cpn_main_phone;
	private String cpn_main_mail;
	private Integer work_area_id;
	private String work_address;
	private Integer code_area_id;
	private String code_address;
	private String cpn_acc_nm;
	private String cpn_acc_phone;
	private String cpn_acc_mail;
	private String cpn_acc_card_no;
	private String cpn_acc_card_url1;
	private String cpn_acc_card_url2;
	private String cpn_code_url;
	private Integer cpn_st;
	private Integer cp_sp_st;
	private Integer sp_user_id;
	private String sale_user_id;
	private Date cre_dt;

	public Date getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(Date cre_dt) {
		this.cre_dt = cre_dt;
	}

	public Integer getCpn_id() {
		return cpn_id;
	}

	public void setCpn_id(Integer cpn_id) {
		this.cpn_id = cpn_id;
	}
	public Integer getCpn_cata_id() {
		return cpn_cata_id;
	}

	public void setCpn_cata_id(Integer cpn_cata_id) {
		this.cpn_cata_id = cpn_cata_id;
	}
	public String getCpn_code() {
		return cpn_code;
	}

	public void setCpn_code(String cpn_code) {
		this.cpn_code = cpn_code;
	}
	public String getCpn_nm() {
		return cpn_nm;
	}

	public void setCpn_nm(String cpn_nm) {
		this.cpn_nm = cpn_nm;
	}
	public String getCpn_main_nm() {
		return cpn_main_nm;
	}

	public void setCpn_main_nm(String cpn_main_nm) {
		this.cpn_main_nm = cpn_main_nm;
	}
	public String getCpn_main_phone() {
		return cpn_main_phone;
	}

	public void setCpn_main_phone(String cpn_main_phone) {
		this.cpn_main_phone = cpn_main_phone;
	}
	public String getCpn_main_mail() {
		return cpn_main_mail;
	}

	public void setCpn_main_mail(String cpn_main_mail) {
		this.cpn_main_mail = cpn_main_mail;
	}
	public Integer getWork_area_id() {
		return work_area_id;
	}

	public void setWork_area_id(Integer work_area_id) {
		this.work_area_id = work_area_id;
	}
	public String getWork_address() {
		return work_address;
	}

	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}
	public Integer getCode_area_id() {
		return code_area_id;
	}

	public void setCode_area_id(Integer code_area_id) {
		this.code_area_id = code_area_id;
	}
	public String getCode_address() {
		return code_address;
	}

	public void setCode_address(String code_address) {
		this.code_address = code_address;
	}
	public String getCpn_acc_nm() {
		return cpn_acc_nm;
	}

	public void setCpn_acc_nm(String cpn_acc_nm) {
		this.cpn_acc_nm = cpn_acc_nm;
	}
	public String getCpn_acc_phone() {
		return cpn_acc_phone;
	}

	public void setCpn_acc_phone(String cpn_acc_phone) {
		this.cpn_acc_phone = cpn_acc_phone;
	}
	public String getCpn_acc_mail() {
		return cpn_acc_mail;
	}

	public void setCpn_acc_mail(String cpn_acc_mail) {
		this.cpn_acc_mail = cpn_acc_mail;
	}
	public String getCpn_acc_card_no() {
		return cpn_acc_card_no;
	}

	public void setCpn_acc_card_no(String cpn_acc_card_no) {
		this.cpn_acc_card_no = cpn_acc_card_no;
	}
	public String getCpn_acc_card_url1() {
		return cpn_acc_card_url1;
	}

	public void setCpn_acc_card_url1(String cpn_acc_card_url1) {
		this.cpn_acc_card_url1 = cpn_acc_card_url1;
	}
	public String getCpn_acc_card_url2() {
		return cpn_acc_card_url2;
	}

	public void setCpn_acc_card_url2(String cpn_acc_card_url2) {
		this.cpn_acc_card_url2 = cpn_acc_card_url2;
	}
	public String getCpn_code_url() {
		return cpn_code_url;
	}

	public void setCpn_code_url(String cpn_code_url) {
		this.cpn_code_url = cpn_code_url;
	}
	public Integer getCpn_st() {
		return cpn_st;
	}

	public void setCpn_st(Integer cpn_st) {
		this.cpn_st = cpn_st;
	}
	public Integer getCp_sp_st() {
		return cp_sp_st;
	}

	public void setCp_sp_st(Integer cp_sp_st) {
		this.cp_sp_st = cp_sp_st;
	}
	public Integer getSp_user_id() {
		return sp_user_id;
	}

	public void setSp_user_id(Integer sp_user_id) {
		this.sp_user_id = sp_user_id;
	}
	public String getSale_user_id() {
		return sale_user_id;
	}

	public void setSale_user_id(String sale_user_id) {
		this.sale_user_id = sale_user_id;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.cpn_id;
	}


}