package wy.rest.addons.zsh.bs_shop.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 商品Model
 *
 * @author wyFrame
 * @Date 2018-07-25 14:33:23
 */
 public class Bs_shop {

    private static final long serialVersionUID = 1L;

	@TableId(value="shop_id", type= IdType.AUTO)
	private Integer shop_id;
	private String shop_no;
	private String shop_nm;
	private Double shop_weigth;
	private String shop_spec;
	private String shop_no_num;
	private String shop_unit;
	private Integer xyd_st_id;
	private String xyd_cre_dt;
	private String xyd_up_dt;
	private Integer id;

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_no() {
		return shop_no;
	}

	public void setShop_no(String shop_no) {
		this.shop_no = shop_no;
	}
	public String getShop_nm() {
		return shop_nm;
	}

	public void setShop_nm(String shop_nm) {
		this.shop_nm = shop_nm;
	}
	public Double getShop_weigth() {
		return shop_weigth;
	}

	public void setShop_weigth(Double shop_weigth) {
		this.shop_weigth = shop_weigth;
	}
	public String getShop_spec() {
		return shop_spec;
	}

	public void setShop_spec(String shop_spec) {
		this.shop_spec = shop_spec;
	}
	public String getShop_no_num() {
		return shop_no_num;
	}

	public void setShop_no_num(String shop_no_num) {
		this.shop_no_num = shop_no_num;
	}
	public String getShop_unit() {
		return shop_unit;
	}

	public void setShop_unit(String shop_unit) {
		this.shop_unit = shop_unit;
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