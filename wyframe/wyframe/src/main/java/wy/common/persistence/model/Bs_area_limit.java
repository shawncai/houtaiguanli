package wy.common.persistence.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Bs_area_limit {
	
	@TableId(value="area_limit_id", type= IdType.AUTO)
	private Integer area_limit_id;
	
	private Integer area_id;
	
	private Integer user_id;

	public Integer getArea_limit_id() {
		return area_limit_id;
	}

	public void setArea_limit_id(Integer area_limit_id) {
		this.area_limit_id = area_limit_id;
	}

	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Bs_area_limit [area_limit_id=" + area_limit_id + ", area_id=" + area_id + ", user_id=" + user_id + "]";
	}
}
