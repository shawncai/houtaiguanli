package wy.addons.zcgl.menu.controller;

import wy.addons.zcgl.gongzhonghao.controller.Wx_mainController;
import wy.addons.zcgl.menu.dao.Wx_menuDao;
import wy.addons.zcgl.menu.dao.Wx_menuMapper;
import wy.addons.zcgl.menu.model.Wx_menu;
import wy.addons.zcgl.menu.warpper.Wx_menuWarpper;
import wy.addons.zcgl.xydwx.menu.Button;
import wy.addons.zcgl.xydwx.menu.Menu;
import wy.addons.zcgl.xydwx.util.WeixinUtil;
import com.alibaba.fastjson.JSONObject;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义菜单控制器
 *
 * @author wyframe
 * @Date 2017-11-10 10:05:28
 */
@Controller
@RequestMapping("/wx_menu")
public class Wx_menuController extends BaseController {
	private String PREFIX = "/addons/zcgl/menu/";
	@Resource
    Wx_menuDao wx_menuDao;
	
	@Resource
    Wx_menuMapper wx_menuMapper;
	
	public static final String DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public static final String CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static List<Map<String, Object>> paramList = null;
    /**
     * 跳转到自定义菜单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wx_menu.html";
    }

    /**
     * 跳转到添加自定义菜单
     */
    @RequestMapping("/wx_menu_add")
    public String wx_menuAdd() {
        return PREFIX + "wx_menu_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/wx_menu_add_param")
	public String wx_menu_add_param() {
		return PREFIX + "wx_menu_add_param.html";
	}

    /**
     * 跳转到修改自定义菜单
     */
    @RequestMapping("/wx_menu_update/{wx_menuId}")
    public String wx_menuUpdate(@PathVariable Integer wx_menuId, Model model) {
    	Wx_menu wx_menu = this.wx_menuDao.queryById(wx_menuId);
    	model.addAttribute(wx_menu);
		LogObjectHolder.me().set(wx_menu);
        return PREFIX + "wx_menu_edit.html";
    }

	/**
     * 跳转到详情自定义菜单
     */
    @RequestMapping("/wx_menu_detail/{wx_menuId}")
    public String wx_menuDetail(@PathVariable Integer wx_menuId, Model model) {
    	Wx_menu wx_menu = this.wx_menuDao.queryById(wx_menuId);
    	model.addAttribute(wx_menu);
		LogObjectHolder.me().set(wx_menu);
        return PREFIX + "wx_menu_detail.html";
    
    }

    /**
     * 获取自定义菜单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    paramList = null;
    List<Map<String, Object>> list = this.wx_menuDao.list(condition);
        return super.warpObject(new Wx_menuWarpper(list));
    }


    /**
     * 新增自定义菜单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Wx_menu wx_menu) {
//    	WeixinUtil.doGetStr(DELETE_URL.replace("ACCESS_TOKEN", Wx_mainController.ACCESS_TOKEN));
    	int deleteMenu = WeixinUtil.deleteMenu(Wx_mainController.ACCESS_TOKEN);
    	System.err.println(deleteMenu+"，Wx_mainController.ACCESS_TOKEN:"+Wx_mainController.ACCESS_TOKEN);
       this.wx_menuMapper.insert(wx_menu);
       List<Map<String, Object>> list = this.wx_menuDao.list(null);
       Menu menu = new Menu();
       List<Map<String,Object>> buttonList = new ArrayList<Map<String,Object>>();
       List<Map<String,Object>> subButtonList = new ArrayList<Map<String,Object>>();
       Button[] buttons = new Button[3];
       Button[] subButtons1 = new Button[5];
       Button[] subButtons2 = new Button[5];
       Button[] subButtons3 = new Button[5];
       for(Map<String, Object> map : list) {
    	   System.err.println("map:"+map);
    	if(map.get("btype").equals("button")){
    		buttonList.add(map);
    	}else{
    		subButtonList.add(map);
    	}
       }
    	System.err.println("buttonList:"+buttonList);
    	System.err.println("subButtonList:"+subButtonList);
			for(int i=1;i<=buttonList.size();i++){
				Map<String, Object> map01 = buttonList.get(i-1);
				if(map01.get("type").toString().equals("click")||map01.get("btype").toString().equals("button")){
					Button button = new Button();
					button.setType("click");
					button.setName(map01.get("name")+"");
					buttons[i-1]=button;
				}
			}
//			for(int i=1;i<subButtonList.size();i++){
//				Map<String, Object> map01 = subButtonList.get(i-1);
//				if(map01.get("type").toString().equals("view")||map01.get("fid").toString().equals("1")){
//					ViewButton button = new ViewButton();
//					button.setName(map01.get("name")+"");
//					button.setType("view");
//					button.setUrl(map01.get("url")+"");
//					subButtons1[i-1]=button;
//				}
//			}
			System.err.println("buttons:"+buttons.toString());
			System.err.println("subButtons1:"+subButtons1.toString());
//			buttons[0].setSub_button(subButtons1);
			menu.setButton(buttons);
			String menustr = JSONObject.toJSONString(menu.toString());
			WeixinUtil.createMenu(Wx_mainController.ACCESS_TOKEN, menustr);
       return SUCCESS_TIP;
    }

    /**
     * 删除自定义菜单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wx_menuId) {
    	this.wx_menuMapper.deleteById(wx_menuId);
        return SUCCESS_TIP;
    }

    /**
     * 修改自定义菜单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Wx_menu wx_menu) {
    	this.wx_menuMapper.updateById(wx_menu);
    	paramList=null;
        return super.SUCCESS_TIP;
    }
    
     /**
     * 导出自定义菜单
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/wx_menu.xls";
    	String tarPath = "src/main/resources/excel/wx_menu.xls";
    	String condition = null;
    	 List<Map<String, Object>> list = this.wx_menuDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "wx_menu"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/wx_menu.xls")));
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
