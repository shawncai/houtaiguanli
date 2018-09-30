package wy.addons.zcgl.cpncata.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 入驻企业Model
 *
 * @author wyframe
 * @Date 2017-09-06 18:41:54
 */
 public class Xyd_cpn_cata {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="cpn_cata_id", type= IdType.AUTO)
	private Integer cpn_cata_id;
	private String cpn_cata_code;
	private String cpn_cata_nm;
	private Integer par_cpn_cata_id;

	public Integer getCpn_cata_id() {
		return cpn_cata_id;
	}

	public void setCpn_cata_id(Integer cpn_cata_id) {
		this.cpn_cata_id = cpn_cata_id;
	}
	public String getCpn_cata_code() {
		return cpn_cata_code;
	}

	public void setCpn_cata_code(String cpn_cata_code) {
		this.cpn_cata_code = cpn_cata_code;
	}
	public String getCpn_cata_nm() {
		return cpn_cata_nm;
	}

	public void setCpn_cata_nm(String cpn_cata_nm) {
		this.cpn_cata_nm = cpn_cata_nm;
	}
	public Integer getPar_cpn_cata_id() {
		return par_cpn_cata_id;
	}

	public void setPar_cpn_cata_id(Integer par_cpn_cata_id) {
		this.par_cpn_cata_id = par_cpn_cata_id;
	}


}