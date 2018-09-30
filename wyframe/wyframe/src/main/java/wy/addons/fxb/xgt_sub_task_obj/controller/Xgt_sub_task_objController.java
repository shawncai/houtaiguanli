package wy.addons.fxb.xgt_sub_task_obj.controller;

import wy.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.File;
import java.util.Arrays;
import com.alibaba.fastjson.JSON;
import wy.core.util.DateUtil;
import java.io.FileInputStream;
import wy.core.shiro.ShiroKit;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import javax.annotation.Resource;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import wy.core.log.LogObjectHolder;
import wy.core.util.DateUtil;
import wy.common.constant.factory.ConstantFactory;
import wy.config.properties.XydProperties;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import wy.common.annotion.Permission;
import wy.common.annotion.BussinessLog;
import wy.common.persistence.model.Page;;
import wy.common.persistence.model.ResultMap;
import wy.core.node.Node;
import wy.core.util.TreeBuilder;
import javax.servlet.http.HttpServletRequest;
import wy.addons.fxb.xgt_sub_task_obj.model.Xgt_sub_task_obj;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_sub_task_obj.dao.Xgt_sub_task_objDao;
import wy.addons.fxb.xgt_sub_task_obj.dao.Xgt_sub_task_objMapper;
import wy.addons.fxb.xgt_sub_task_obj.warpper.Xgt_sub_task_objWarpper;

/**
 * 作业对象控制器
 *
 * @author wyFrame
 * @Date 2018-09-05 15:45:21
 */
@Controller
@RequestMapping("/xgt_sub_task_obj")
public class Xgt_sub_task_objController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_sub_task_obj/";
	@Resource
	Xgt_sub_task_objDao xgt_sub_task_objDao;
	
	@Resource
	Xgt_sub_task_objMapper xgt_sub_task_objMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到作业对象首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("完成状态");
                 model.addAttribute("map5",list5);
                 List<Map<String, Object>> list11 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map11",list11);
        return PREFIX + "xgt_sub_task_obj.html";
    }

    /**
     * 跳转到添加作业对象
     */
    @RequestMapping("/xgt_sub_task_obj_add")
    public String xgt_sub_task_objAdd(Model model) {
                   List<Map<String, Object>> list1 = xgt_sub_task_objDao.getMap1();
                   model.addAttribute("map1",list1);
             List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("完成状态");
             model.addAttribute("map5",list5);
                   List<Map<String, Object>> list10 = xgt_sub_task_objDao.getMap10();
                   model.addAttribute("map10",list10);
             List<Map<String, Object>> list11 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map11",list11);
        return PREFIX + "xgt_sub_task_obj_add.html";
    }

    /**
     * 跳转到修改作业对象
     */
    @RequestMapping("/xgt_sub_task_obj_update/{xgt_sub_task_objId}")
    public String xgt_sub_task_objUpdate(@PathVariable Integer xgt_sub_task_objId, Model model) {
    	Xgt_sub_task_obj xgt_sub_task_obj = this.xgt_sub_task_objDao.queryById(xgt_sub_task_objId);
    	model.addAttribute(xgt_sub_task_obj);
		LogObjectHolder.me().set(xgt_sub_task_obj);
                                 List<Map<String, Object>> list1 = xgt_sub_task_objDao.getMap1();
                                 model.addAttribute("map1",list1);
                     List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("完成状态");
                     model.addAttribute("map5",list5);
                                 List<Map<String, Object>> list10 = xgt_sub_task_objDao.getMap10();
                                 model.addAttribute("map10",list10);
                     List<Map<String, Object>> list11 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map11",list11);
        return PREFIX + "xgt_sub_task_obj_edit.html";
    }

    /**
     * 获取作业对象列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer over_st_id,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_task_objDao.list(condition,over_st_id,st_id);
        return super.warpObject(new Xgt_sub_task_objWarpper(list));
    }

    /**
     * 获取作业对象列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer over_st_id,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_task_objDao.list(condition,over_st_id,st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_sub_task_objWarpper(list)));
        return map;
    }

    /**
     * 新增作业对象
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(Xgt_sub_task_obj xgt_sub_task_obj,HttpServletRequest request) {
        String array = request.getParameter("stids");
        System.err.println(array);
        String[] str = array.split(",");
        System.err.println(str.toString());
        for (int i = 0; i < str.length; i++) {
            Integer userId = ShiroKit.getUser().getId();
            Integer cpnId = xgt_sub_task_objDao.queryCpnId(userId);
            Integer id= Integer.valueOf(str[i]);
            xgt_sub_task_obj.setOver_id(id);
            xgt_sub_task_obj.setSt_id(1);
            xgt_sub_task_obj.setCre_dt(new Date());
            xgt_sub_task_obj.setCpn_id(cpnId);
             this.xgt_sub_task_objMapper.insert(xgt_sub_task_obj);
        }
    }
    /**
     * 删除作业对象
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_sub_task_objIds) {
        //物理删除
    	//this.xgt_sub_task_objMapper.deleteById(xgt_sub_task_objId);
    	//逻辑删除
    	  String[] split =xgt_sub_task_objIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_sub_task_objDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改作业对象
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_sub_task_obj xgt_sub_task_obj) {
    	this.xgt_sub_task_objMapper.updateById(xgt_sub_task_obj);
        return super.SUCCESS_TIP;
    }


	/**
     * 跳转到详情作业对象
     */
    @RequestMapping("/xgt_sub_task_obj_detail/{xgt_sub_task_objId}")
    public String xgt_sub_task_objDetail(@PathVariable Integer xgt_sub_task_objId, Model model) {
    	Xgt_sub_task_obj xgt_sub_task_obj = this.xgt_sub_task_objDao.queryById(xgt_sub_task_objId);
    	model.addAttribute(xgt_sub_task_obj);
                                 List<Map<String, Object>> list1 = xgt_sub_task_objDao.getMap1();
                                 model.addAttribute("map1",list1);
                     List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("完成状态");
                     model.addAttribute("map5",list5);
                                 List<Map<String, Object>> list10 = xgt_sub_task_objDao.getMap10();
                                 model.addAttribute("map10",list10);
                     List<Map<String, Object>> list11 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map11",list11);

		LogObjectHolder.me().set(xgt_sub_task_obj);
        return PREFIX + "xgt_sub_task_obj_detail.html";
    }

     /**
     * 导出作业对象
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_sub_task_obj.xls";
    	String tarPath = "src/main/resources/excel/xgt_sub_task_obj.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_sub_task_objDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_sub_task_obj"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_sub_task_obj.xls")));
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
