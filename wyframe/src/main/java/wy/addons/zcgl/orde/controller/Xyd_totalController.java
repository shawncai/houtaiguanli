package wy.addons.zcgl.orde.controller;

import wy.addons.zcgl.orde.dao.Xyd_totalDao;
import wy.addons.zcgl.orde.dao.Xyd_totalMapper;
import wy.addons.zcgl.orde.model.Xyd_total;
import wy.addons.zcgl.orde.warpper.Xyd_totalWarpper;
import com.alibaba.fastjson.JSON;
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
 * 订单控制器
 *
 * @author wyframe
 * @Date 2017-08-24 15:49:09
 */
@Controller
@RequestMapping("/xyd_total")
public class Xyd_totalController extends BaseController {
	private String PREFIX = "/addons/zcgl/orde/";
	@Resource
	Xyd_totalDao xyd_totalDao;
	
	@Resource
    Xyd_totalMapper xyd_totalMapper;
	
	public static List<Map<String, Object>> paramList = null;
    /**
     * 跳转到订单首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xyd_total.html";
    }

    /**
     * 跳转到添加订单
     */
    @RequestMapping("/xyd_total_add")
    public String xyd_totalAdd() {
        return PREFIX + "xyd_total_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_total_add_param")
	public String xyd_total_add_param() {
		return PREFIX + "xyd_total_add_param.html";
	}

    /**
     * 跳转到修改订单
     */
    @RequestMapping("/xyd_total_update/{xyd_totalId}")
    public String xyd_totalUpdate(@PathVariable Integer xyd_totalId, Model model) {
     	Xyd_total xyd_total = this.xyd_totalDao.queryById(xyd_totalId);
    	model.addAttribute(xyd_total);
		LogObjectHolder.me().set(xyd_total);
        return PREFIX + "xyd_total_edit.html";
    
    }

	/**
     * 跳转到详情订单
     */
    @RequestMapping("/xyd_total_detail/{xyd_totalId}")
    public String xyd_totalDetail(@PathVariable Integer xyd_totalId, Model model) {
    	Xyd_total xyd_total = this.xyd_totalDao.queryById(xyd_totalId);
    	model.addAttribute(xyd_total);
		LogObjectHolder.me().set(xyd_total);
        return PREFIX + "xyd_total_detail.html";
    
    }

    /**
     * 获取订单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    paramList = null;
    List<Map<String, Object>> list = this.xyd_totalDao.list(condition);
        return super.warpObject(new Xyd_totalWarpper(list));
    }

    /**
	 * 获取参数列表
	 */
	@RequestMapping(value = "/paramList")
	@ResponseBody
	public Object paramList(String condition) {
		return super.warpObject(new Xyd_totalWarpper(paramList));
	}
	
	/**
	 * 获取参数页面列表
	 */
	@RequestMapping(value = "/paramsList")
	@ResponseBody
	public Object paramsList(String condition) {
		List<Map<String, Object>> list = this.xyd_totalDao.paramsList(condition);
		if (paramList != null) {
			list.removeAll(paramList);
		}
		return super.warpObject(new Xyd_totalWarpper(list));
	}
	
	// 为paramList赋值
	@RequestMapping(value = "/param/{str}")
	@ResponseBody
	public Object param(@PathVariable String str) {
		String[] strs = str.split("\\.");
		List<Integer> list = new ArrayList<Integer>();
		for (String string : strs) {
			list.add(Integer.parseInt(string));
		}
		List<Map<String, Object>> param = this.xyd_totalDao.param(list);
		if (paramList == null) {
			paramList = param;
		} else {
			paramList.addAll(param);
		}
		return 1;
	}

	// 删除paramList
	@RequestMapping(value = "/deleteParam/{str}")
	@ResponseBody
	public Object deleteParam(@PathVariable String str) {
		String[] strs = str.split("\\.");
		List<Integer> list = new ArrayList<Integer>();
		for (String string : strs) {
			list.add(Integer.parseInt(string));
		}
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		for (Integer integer : list) {
			for (Map<String, Object> map : paramList) {
				if (map.get("SHOP_ID").equals(integer)) {
					list2.add(map);
				}
			}
		}
		paramList.removeAll(list2);
		return SUCCESS_TIP;
	}

 	/**
     * 新增订单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestParam String iData,@RequestParam String tData ) {
    	Map<String,Object> map = (Map<String, Object>) JSON.parse(iData);
    	List<Map<String,Object>> map2 = (List<Map<String, Object>>) JSON.parse(tData);
    	this.xyd_totalDao.insertTotal(map);
		for (Map<String, Object> m : map2) {
			m.put("msg_id", map.get("msg_id"));
		}
    	this.xyd_totalDao.insertDetail(map2);
        return SUCCESS_TIP;
    }
    
    /**
     * 订单详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable Integer id) {
    	List<Map<String,Object>> list =  this.xyd_totalDao.selectDetail(id);
    	if(paramList!=null){
    		 return super.warpObject(new Xyd_totalWarpper(paramList));
    	}
    	paramList=list;
        return super.warpObject(new Xyd_totalWarpper(list));
    }
    
     /**
     * 修改订单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xyd_total xyd_total,@RequestParam String str) {
    	this.xyd_totalMapper.updateById(xyd_total);
    	String[] strs = str.split("\\.");
    	List<Integer> list = new ArrayList<Integer>();
		for (String string : strs) {
			list.add(Integer.parseInt(string));
		}
		
		Integer id = xyd_total.getMsg_id();
		this.xyd_totalDao.deleteDetl(id);
		List<Map<String,Object>> map2 = new ArrayList<Map<String,Object>>();
		for(Integer i:list){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("msg_id", id);
			map.put("SHOP_ID", i);
			map2.add(map);
		}
		 xyd_totalDao.insertDetail(map2);
    	paramList=null;
        return super.SUCCESS_TIP;
    }

    /**
     * 删除订单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xyd_totalId) {
    	this.xyd_totalDao.deleteParam(xyd_totalId);
    	this.xyd_totalDao.deleteTotal(xyd_totalId);
        return SUCCESS_TIP;
    }

    
     /**
     * 导出订单
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xyd_total.xls";
    	String tarPath = "src/main/resources/excel/xyd_total.xls";
    	String condition = null;
    	 List<Map<String, Object>> list = this.xyd_totalDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xyd_total"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_total.xls")));
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
