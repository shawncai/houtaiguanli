package wy.rest.addons.zsh.bs_bill.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 订单Model
 *
 * @author wyFrame
 * @Date 2018-07-25 15:16:00
 */
 public class Bs_bill {

    private static final long serialVersionUID = 1L;

	@TableId(value="bill_id", type= IdType.AUTO)
	private Integer bill_id;
	private String bill_no;
	private String buy_dt;
	private String pay_dt;
	private Double total_money;
	private String access_mem;
	private String access_addr_desc;
	private String access_phone;
	private Integer area_id;
	private Integer city_id;
	private Integer send_chnl_id;
	private String lu_user;
	private String send_dt;
	private Integer bill_st_id;
	private String staff_user;
	private String crt_dt;
	private Integer prov_id;
	private String user_remark;
	private String remarks;
	private Integer send_st;
	private String send_user;
	private String send_cre_dt;
	private String send_remark;
	private Integer total_num;
	private String card_no;
	private String src_bill_no;
	private String new_area_desc;
	private Integer xyd_st_id;
	private String xyd_cre_dt;
	private String xyd_up_dt;
	private Integer id;

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public Integer getBill_id() {
		return bill_id;
	}

	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}
	public String getBuy_dt() {
		return buy_dt;
	}

	public void setBuy_dt(String buy_dt) {
		this.buy_dt = buy_dt;
	}
	public String getPay_dt() {
		return pay_dt;
	}

	public void setPay_dt(String pay_dt) {
		this.pay_dt = pay_dt;
	}
	public Double getTotal_money() {
		return total_money;
	}

	public void setTotal_money(Double total_money) {
		this.total_money = total_money;
	}
	public String getAccess_mem() {
		return access_mem;
	}

	public void setAccess_mem(String access_mem) {
		this.access_mem = access_mem;
	}
	public String getAccess_addr_desc() {
		return access_addr_desc;
	}

	public void setAccess_addr_desc(String access_addr_desc) {
		this.access_addr_desc = access_addr_desc;
	}
	public String getAccess_phone() {
		return access_phone;
	}

	public void setAccess_phone(String access_phone) {
		this.access_phone = access_phone;
	}
	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public Integer getSend_chnl_id() {
		return send_chnl_id;
	}

	public void setSend_chnl_id(Integer send_chnl_id) {
		this.send_chnl_id = send_chnl_id;
	}
	public String getLu_user() {
		return lu_user;
	}

	public void setLu_user(String lu_user) {
		this.lu_user = lu_user;
	}
	public String getSend_dt() {
		return send_dt;
	}

	public void setSend_dt(String send_dt) {
		this.send_dt = send_dt;
	}
	public Integer getBill_st_id() {
		return bill_st_id;
	}

	public void setBill_st_id(Integer bill_st_id) {
		this.bill_st_id = bill_st_id;
	}
	public String getStaff_user() {
		return staff_user;
	}

	public void setStaff_user(String staff_user) {
		this.staff_user = staff_user;
	}
	public String getCrt_dt() {
		return crt_dt;
	}

	public void setCrt_dt(String crt_dt) {
		this.crt_dt = crt_dt;
	}
	public Integer getProv_id() {
		return prov_id;
	}

	public void setProv_id(Integer prov_id) {
		this.prov_id = prov_id;
	}
	public String getUser_remark() {
		return user_remark;
	}

	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getSend_st() {
		return send_st;
	}

	public void setSend_st(Integer send_st) {
		this.send_st = send_st;
	}
	public String getSend_user() {
		return send_user;
	}

	public void setSend_user(String send_user) {
		this.send_user = send_user;
	}
	public String getSend_cre_dt() {
		return send_cre_dt;
	}

	public void setSend_cre_dt(String send_cre_dt) {
		this.send_cre_dt = send_cre_dt;
	}
	public String getSend_remark() {
		return send_remark;
	}

	public void setSend_remark(String send_remark) {
		this.send_remark = send_remark;
	}
	public Integer getTotal_num() {
		return total_num;
	}

	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}
	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getSrc_bill_no() {
		return src_bill_no;
	}

	public void setSrc_bill_no(String src_bill_no) {
		this.src_bill_no = src_bill_no;
	}
	public String getNew_area_desc() {
		return new_area_desc;
	}

	public void setNew_area_desc(String new_area_desc) {
		this.new_area_desc = new_area_desc;
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