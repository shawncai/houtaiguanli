package wy.addons.fxb.xgt_sub_task.controller;

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
import wy.addons.fxb.xgt_sub_task.model.Xgt_sub_task;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_sub_task.dao.Xgt_sub_taskDao;
import wy.addons.fxb.xgt_sub_task.dao.Xgt_sub_taskMapper;
import wy.addons.fxb.xgt_sub_task.warpper.Xgt_sub_taskWarpper;

/**
 * 作业任务控制器
 *
 * @author wyFrame
 * @Date 2018-09-05 11:51:57
 */
@Controller
@RequestMapping("/xgt_sub_task")
public class Xgt_sub_taskController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_sub_task/";
	@Resource
	Xgt_sub_taskDao xgt_sub_taskDao;
	
	@Resource
	Xgt_sub_taskMapper xgt_sub_taskMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到作业任务首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list9 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map9",list9);
        return PREFIX + "xgt_sub_task.html";
    }

    /**
     * 跳转到添加作业任务
     */
    @RequestMapping("/xgt_sub_task_add")
    public String xgt_sub_taskAdd(Model model) {
                   List<Map<String, Object>> list2 = xgt_sub_taskDao.getMap2();
                   model.addAttribute("map2",list2);
                   List<Map<String, Object>> list3 = xgt_sub_taskDao.getMap3();
                   model.addAttribute("map3",list3);
                   List<Map<String, Object>> list4 = xgt_sub_taskDao.getMap4();
                   model.addAttribute("map4",list4);
        List<Map<String, Object>> list6 = xgt_sub_taskDao.getMap6();
        model.addAttribute("map6",list6);
             List<Map<String, Object>> list9 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map9",list9);
        return PREFIX + "xgt_sub_task_add.html";
    }

    /**
     * 跳转到修改作业任务
     */
    @RequestMapping("/xgt_sub_task_update/{xgt_sub_taskId}")
    public String xgt_sub_taskUpdate(@PathVariable Integer xgt_sub_taskId, Model model) {
    	Xgt_sub_task xgt_sub_task = this.xgt_sub_taskDao.queryById(xgt_sub_taskId);
    	model.addAttribute(xgt_sub_task);
		LogObjectHolder.me().set(xgt_sub_task);
                                 List<Map<String, Object>> list2 = xgt_sub_taskDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_taskDao.getMap3();
                                 model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list4 = xgt_sub_taskDao.getMap4();
                                 model.addAttribute("map4",list4);
        List<Map<String, Object>> list6 = xgt_sub_taskDao.getMap6();
        model.addAttribute("map6",list6);
                     List<Map<String, Object>> list9 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map9",list9);
        return PREFIX + "xgt_sub_task_edit.html";
    }

    /**
     * 获取作业任务列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_taskDao.list(condition,st_id);
        return super.warpObject(new Xgt_sub_taskWarpper(list));
    }

    /**
     * 获取作业任务列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer st_id) {

        List<Map<String, Object>> list = this.xgt_sub_taskDao.list(condition,st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_sub_taskWarpper(list)));
        return map;
    }

    /**
     * 新增作业任务
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_sub_task xgt_sub_task) {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId=xgt_sub_taskDao.queryCpnId(userId);
        xgt_sub_task.setId(ShiroKit.getUser().getId());
        xgt_sub_task.setCre_dt(new Date());
        xgt_sub_task.setSt_id(1);
        xgt_sub_task.setCpn_id(cpnId);
        return this.xgt_sub_taskMapper.insert(xgt_sub_task);
    }

    /**
     * 删除作业任务
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_sub_taskIds) {
        //物理删除
    	//this.xgt_sub_taskMapper.deleteById(xgt_sub_taskId);
    	//逻辑删除
    	  String[] split =xgt_sub_taskIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_sub_taskDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改作业任务
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_sub_task xgt_sub_task) {
    	this.xgt_sub_taskMapper.updateById(xgt_sub_task);
        return super.SUCCESS_TIP;
    }

    /**
     * 高三一班详情
     */
    @RequestMapping(value = "/ClassOne")
    @ResponseBody
    public ResultMap<List<Map>> ClassOne(@RequestParam Integer cpn_dept_id) {
        List<Map> One=this.xgt_sub_taskDao.ClassOne(cpn_dept_id);
        int totals=40;
        return new ResultMap<List<Map>>("",One,0,40);
    }

    /**
     * 高三五班详情
     */
    @RequestMapping(value = "/ClassFive")
    @ResponseBody
    public ResultMap<List<Map>> ClassFive(@RequestParam Integer cpn_dept_id) {
        List<Map> One=this.xgt_sub_taskDao.ClassOne(cpn_dept_id);
        int totals=40;
        return new ResultMap<List<Map>>("",One,0,40);
    }

    /**
     * 返回给前台高三部的班级名称
     */
    @RequestMapping(value = "/FindClass")
    @ResponseBody
    public Object FindClass() {
        List<Map<String, Object>>classlist=this.xgt_sub_taskDao.FindClass();
        return classlist;
    }
	/**
     * 跳转到详情作业任务
     */
    @RequestMapping("/xgt_sub_task_detail/{xgt_sub_taskId}")
    public String xgt_sub_taskDetail(@PathVariable Integer xgt_sub_taskId, Model model) {
    	Xgt_sub_task xgt_sub_task = this.xgt_sub_taskDao.queryById(xgt_sub_taskId);
    	model.addAttribute(xgt_sub_task);
                                 List<Map<String, Object>> list2 = xgt_sub_taskDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_taskDao.getMap3();
                                 model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list4 = xgt_sub_taskDao.getMap4();
                                 model.addAttribute("map4",list4);
        List<Map<String, Object>> list6 = xgt_sub_taskDao.getMap6();
        model.addAttribute("map6",list6);
                     List<Map<String, Object>> list9 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map9",list9);

		LogObjectHolder.me().set(xgt_sub_task);
        return PREFIX + "xgt_sub_task_detail.html";
    }

     /**
     * 导出作业任务
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_sub_task.xls";
    	String tarPath = "src/main/resources/excel/xgt_sub_task.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_sub_taskDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_sub_task"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_sub_task.xls")));
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