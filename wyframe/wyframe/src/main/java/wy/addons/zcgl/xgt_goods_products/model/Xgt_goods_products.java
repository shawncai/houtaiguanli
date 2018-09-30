package wy.addons.zcgl.xgt_goods_products.model;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 商品测试Model
 *
 * @author wyFrame
 * @Date 2018-07-20 20:23:12
 */
 public class Xgt_goods_products {

    private static final long serialVersionUID = 1L;

	@TableId(value="prd_id", type= IdType.AUTO)
	private Integer prd_id;
	private String prd_nm;
	private Integer prd_brand_id;
	private String prd_nm_alias;
	private Integer prd_cls_id;
	private String prd_sn;
	private Integer prd_unit_id;
	private String prd_model;
	private String prd_spec;
	private String prd_no;
	private String prd_crt_dt;
	private Double prd_purchase;
	private Double prd_price;
	private String xyd_cre_dt;
	private String xyd_up_dt;
	private Integer id;
	private String prd_nm_img;
	private String prd_nm_dsc;
	private Integer xyd_st_id;

	public Integer getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(Integer prd_id) {
		this.prd_id = prd_id;
	}
	public String getPrd_nm() {
		return prd_nm;
	}

	public void setPrd_nm(String prd_nm) {
		this.prd_nm = prd_nm;
	}
	public Integer getPrd_brand_id() {
		return prd_brand_id;
	}

	public void setPrd_brand_id(Integer prd_brand_id) {
		this.prd_brand_id = prd_brand_id;
	}
	public String getPrd_nm_alias() {
		return prd_nm_alias;
	}

	public void setPrd_nm_alias(String prd_nm_alias) {
		this.prd_nm_alias = prd_nm_alias;
	}
	public Integer getPrd_cls_id() {
		return prd_cls_id;
	}

	public void setPrd_cls_id(Integer prd_cls_id) {
		this.prd_cls_id = prd_cls_id;
	}
	public String getPrd_sn() {
		return prd_sn;
	}

	public void setPrd_sn(String prd_sn) {
		this.prd_sn = prd_sn;
	}
	public Integer getPrd_unit_id() {
		return prd_unit_id;
	}

	public void setPrd_unit_id(Integer prd_unit_id) {
		this.prd_unit_id = prd_unit_id;
	}
	public String getPrd_model() {
		return prd_model;
	}

	public void setPrd_model(String prd_model) {
		this.prd_model = prd_model;
	}
	public String getPrd_spec() {
		return prd_spec;
	}

	public void setPrd_spec(String prd_spec) {
		this.prd_spec = prd_spec;
	}
	public String getPrd_no() {
		return prd_no;
	}

	public void setPrd_no(String prd_no) {
		this.prd_no = prd_no;
	}
	public String getPrd_crt_dt() {
		return prd_crt_dt;
	}

	public void setPrd_crt_dt(String prd_crt_dt) {
		this.prd_crt_dt = prd_crt_dt;
	}
	public Double getPrd_purchase() {
		return prd_purchase;
	}

	public void setPrd_purchase(Double prd_purchase) {
		this.prd_purchase = prd_purchase;
	}
	public Double getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(Double prd_price) {
		this.prd_price = prd_price;
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
	public String getPrd_nm_img() {
		return prd_nm_img;
	}

	public void setPrd_nm_img(String prd_nm_img) {
		this.prd_nm_img = prd_nm_img;
	}
	public String getPrd_nm_dsc() {
		return prd_nm_dsc;
	}

	public void setPrd_nm_dsc(String prd_nm_dsc) {
		this.prd_nm_dsc = prd_nm_dsc;
	}
	public Integer getXyd_st_id() {
		return xyd_st_id;
	}

	public void setXyd_st_id(Integer xyd_st_id) {
		this.xyd_st_id = xyd_st_id;
	}
}