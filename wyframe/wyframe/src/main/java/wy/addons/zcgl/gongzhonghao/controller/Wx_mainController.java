package wy.addons.zcgl.gongzhonghao.controller;

import wy.addons.zcgl.gongzhonghao.dao.Wx_mainDao;
import wy.addons.zcgl.gongzhonghao.dao.Wx_mainMapper;
import wy.addons.zcgl.gongzhonghao.model.Wx_main;
import wy.addons.zcgl.gongzhonghao.warpper.Wx_mainWarpper;
import wy.addons.zcgl.xydwx.entity.AccessToken;
//import wy.addons.zcgl.xydwx.util.WeixinUtil;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信公众号控制器
 *
 * @author wyframe
 * @Date 2017-11-10 10:46:11
 */
@Controller
@RequestMapping("/wx_main")
public class Wx_mainController extends BaseController {
	private String PREFIX = "/addons/zcgl/gongzhonghao/";

	@Resource
	Wx_mainDao wx_mainDao;
	
	@Resource
	Wx_mainMapper wx_mainMapper;
	public static String ACCESS_TOKEN = "";
	public static String APPID = "";
	public static String APPSECRET = "";
	public static  String TOKEN="";
	public static  String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static  String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static  String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static  String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static  String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	
    /**
     * 跳转到微信公众号首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wx_main.html";
    }

    /**
     * 跳转到添加微信公众号
     */
    @RequestMapping("/wx_main_add")
    public String wx_mainAdd() {
        return PREFIX + "wx_main_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/wx_main_add_param")
	public String wx_main_add_param() {
		return PREFIX + "wx_main_add_param.html";
	}

    /**
     * 跳转到修改微信公众号
     */
    @RequestMapping("/wx_main_update/{wx_mainId}")
    public String wx_mainUpdate(@PathVariable Integer wx_mainId, Model model) {
    	Wx_main wx_main = this.wx_mainDao.queryById(wx_mainId);
    	model.addAttribute(wx_main);
		LogObjectHolder.me().set(wx_main);
        return PREFIX + "wx_main_edit.html";
    }

	/**
     * 管理当前公众号
     */
    @RequestMapping("/wx_main_detail/{wx_mainId}")
    @ResponseBody
    public String wx_mainDetail(@PathVariable Integer wx_mainId) {
    	Wx_main wx_main = this.wx_mainDao.queryById(wx_mainId);
    	String  accessToken= wx_main.getAccess_token();
    	APPID = wx_main.getAppid();
    	APPSECRET = wx_main.getAppsecret();
    	TOKEN = wx_main.getToken();
    	String wxname = wx_main.getWxname();
    	System.err.println(APPID+"     "+APPSECRET);
    //	AccessToken token = WeixinUtil.getAccessToken(ACCESS_TOKEN_URL, APPID, APPSECRET);
    //	ACCESS_TOKEN =  token.getAccess_token();
    	return "success";
    }

    /**
     * 获取微信公众号列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    List<Map<String, Object>> list = this.wx_mainDao.list(condition);
        return super.warpObject(new Wx_mainWarpper(list));
    }


    /**
     * 新增微信公众号
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Wx_main wx_main) {
        return this.wx_mainMapper.insert(wx_main);
    }

    /**
     * 删除微信公众号
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wx_mainId) {
    	this.wx_mainMapper.deleteById(wx_mainId);
        return SUCCESS_TIP;
    }

    /**
     * 修改微信公众号
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Wx_main wx_main) {
    	this.wx_mainMapper.updateById(wx_main);
        return super.SUCCESS_TIP;
    }
    
    
     /**
     * 导出微信公众号
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/wx_main.xls";
    	String tarPath = "src/main/resources/excel/wx_main.xls";
    	String condition = null;
    	 List<Map<String, Object>> list = this.wx_mainDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "wx_main"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/wx_main.xls")));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
