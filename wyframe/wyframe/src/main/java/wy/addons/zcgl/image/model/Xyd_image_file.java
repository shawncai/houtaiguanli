package wy.addons.zcgl.image.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
/**
 * 图片Model
 *
 * @author wyframe
 * @Date 2017-11-09 16:30:08
 */
 public class Xyd_image_file {
 
 
 
private static final long serialVersionUID = 1L;

	@TableId(value="image_file_id", type= IdType.AUTO)
	private Integer image_file_id;
	private String image_file_nm;
	private String image_file_src_url;
	private String image_file_url;
	private String file_url;
	private Integer img_file_cls;
	private Integer img_long;
	private Integer img_wid;
	private Date cre_dt;
	private Integer st_id;
	private String oper_user;

	public Integer getImage_file_id() {
		return image_file_id;
	}

	public void setImage_file_id(Integer image_file_id) {
		this.image_file_id = image_file_id;
	}
	public String getImage_file_nm() {
		return image_file_nm;
	}

	public void setImage_file_nm(String image_file_nm) {
		this.image_file_nm = image_file_nm;
	}
	public String getImage_file_src_url() {
		return image_file_src_url;
	}

	public void setImage_file_src_url(String image_file_src_url) {
		this.image_file_src_url = image_file_src_url;
	}
	public String getImage_file_url() {
		return image_file_url;
	}

	public void setImage_file_url(String image_file_url) {
		this.image_file_url = image_file_url;
	}
	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public Integer getImg_file_cls() {
		return img_file_cls;
	}

	public void setImg_file_cls(Integer img_file_cls) {
		this.img_file_cls = img_file_cls;
	}
	public Integer getImg_long() {
		return img_long;
	}

	public void setImg_long(Integer img_long) {
		this.img_long = img_long;
	}
	public Integer getImg_wid() {
		return img_wid;
	}

	public void setImg_wid(Integer img_wid) {
		this.img_wid = img_wid;
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


}