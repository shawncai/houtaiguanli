package wy.addons.zcgl.cpn_room.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 房间Model
 *
 * @author wyframe
 * @Date 2018-01-03 15:02:19
 */
 public class Xgt_cpn_room {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="room_id", type= IdType.AUTO)
	private Integer room_id;
	private String room_nm;
	private String room_yt;
	private String room_adrs;
	private Double room_adrs_x;
	private Double room_adrs_y;
	private String romm_photo_url;
	private String romm_photo_url6;
	private String romm_photo_url5;
	private String romm_photo_url4;
	private String romm_photo_url3;
	private String romm_photo_url2;
	private Integer par_room_id;
	private Integer cpn_branch_id;
	private Date cre_dt;
	private Integer st_id;
	private String oper_user;

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}
	public String getRoom_nm() {
		return room_nm;
	}

	public void setRoom_nm(String room_nm) {
		this.room_nm = room_nm;
	}
	public String getRoom_yt() {
		return room_yt;
	}

	public void setRoom_yt(String room_yt) {
		this.room_yt = room_yt;
	}
	public String getRoom_adrs() {
		return room_adrs;
	}

	public void setRoom_adrs(String room_adrs) {
		this.room_adrs = room_adrs;
	}
	public Double getRoom_adrs_x() {
		return room_adrs_x;
	}

	public void setRoom_adrs_x(Double room_adrs_x) {
		this.room_adrs_x = room_adrs_x;
	}
	public Double getRoom_adrs_y() {
		return room_adrs_y;
	}

	public void setRoom_adrs_y(Double room_adrs_y) {
		this.room_adrs_y = room_adrs_y;
	}
	public String getRomm_photo_url() {
		return romm_photo_url;
	}

	public void setRomm_photo_url(String romm_photo_url) {
		this.romm_photo_url = romm_photo_url;
	}
	public String getRomm_photo_url6() {
		return romm_photo_url6;
	}

	public void setRomm_photo_url6(String romm_photo_url6) {
		this.romm_photo_url6 = romm_photo_url6;
	}
	public String getRomm_photo_url5() {
		return romm_photo_url5;
	}

	public void setRomm_photo_url5(String romm_photo_url5) {
		this.romm_photo_url5 = romm_photo_url5;
	}
	public String getRomm_photo_url4() {
		return romm_photo_url4;
	}

	public void setRomm_photo_url4(String romm_photo_url4) {
		this.romm_photo_url4 = romm_photo_url4;
	}
	public String getRomm_photo_url3() {
		return romm_photo_url3;
	}

	public void setRomm_photo_url3(String romm_photo_url3) {
		this.romm_photo_url3 = romm_photo_url3;
	}
	public String getRomm_photo_url2() {
		return romm_photo_url2;
	}

	public void setRomm_photo_url2(String romm_photo_url2) {
		this.romm_photo_url2 = romm_photo_url2;
	}
	public Integer getPar_room_id() {
		return par_room_id;
	}

	public void setPar_room_id(Integer par_room_id) {
		this.par_room_id = par_room_id;
	}
	public Integer getCpn_branch_id() {
		return cpn_branch_id;
	}

	public void setCpn_branch_id(Integer cpn_branch_id) {
		this.cpn_branch_id = cpn_branch_id;
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
	public String getOper_user() {
		return oper_user;
	}

	public void setOper_user(String oper_user) {
		this.oper_user = oper_user;
	}

	@Override
	public String toString() {
		return "Xgt_cpn_room [room_id=" + room_id + ", room_nm=" + room_nm + ", room_yt=" + room_yt + ", room_adrs="
				+ room_adrs + ", room_adrs_x=" + room_adrs_x + ", room_adrs_y=" + room_adrs_y + ", romm_photo_url="
				+ romm_photo_url + ", romm_photo_url6=" + romm_photo_url6 + ", romm_photo_url5=" + romm_photo_url5
				+ ", romm_photo_url4=" + romm_photo_url4 + ", romm_photo_url3=" + romm_photo_url3 + ", romm_photo_url2="
				+ romm_photo_url2 + ", par_room_id=" + par_room_id + ", cpn_branch_id=" + cpn_branch_id + ", cre_dt="
				+ cre_dt + ", st_id=" + st_id + ", oper_user=" + oper_user + "]";
	}

	

}