package wy.addons.zcgl.gongzhonghao.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 微信公众号Model
 *
 * @author wyframe
 * @Date 2017-11-10 10:46:11
 */
 public class Wx_main {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String wxname;
	private String appid;
	private String appsecret;
	private String token;
	private String access_token;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getWxname() {
		return wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}


}