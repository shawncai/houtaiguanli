package wy.addons.fxb.xgt_sub_task_dtl.controller;

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
import wy.addons.fxb.xgt_sub_task_dtl.model.Xgt_sub_task_dtl;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_sub_task_dtl.dao.Xgt_sub_task_dtlDao;
import wy.addons.fxb.xgt_sub_task_dtl.dao.Xgt_sub_task_dtlMapper;
import wy.addons.fxb.xgt_sub_task_dtl.warpper.Xgt_sub_task_dtlWarpper;

/**
 * 任务详情控制器
 *
 * @author wyFrame
 * @Date 2018-09-05 15:20:52
 */
@Controller
@RequestMapping("/xgt_sub_task_dtl")
public class Xgt_sub_task_dtlController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_sub_task_dtl/";
	@Resource
	Xgt_sub_task_dtlDao xgt_sub_task_dtlDao;
	
	@Resource
	Xgt_sub_task_dtlMapper xgt_sub_task_dtlMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到任务详情首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list10 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map10",list10);
        return PREFIX + "xgt_sub_task_dtl.html";
    }

    /**
     * 跳转到添加任务详情
     */
    @RequestMapping("/xgt_sub_task_dtl_add")
    public String xgt_sub_task_dtlAdd(Model model) {
                   List<Map<String, Object>> list1 = xgt_sub_task_dtlDao.getMap1();
                   model.addAttribute("map1",list1);
             List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("正确与否");
             model.addAttribute("map6",list6);
                   List<Map<String, Object>> list9 = xgt_sub_task_dtlDao.getMap9();
                   model.addAttribute("map9",list9);
             List<Map<String, Object>> list10 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map10",list10);
        return PREFIX + "xgt_sub_task_dtl_add.html";
    }

    /**
     * 跳转到修改任务详情
     */
    @RequestMapping("/xgt_sub_task_dtl_update/{xgt_sub_task_dtlId}")
    public String xgt_sub_task_dtlUpdate(@PathVariable Integer xgt_sub_task_dtlId, Model model) {
    	Xgt_sub_task_dtl xgt_sub_task_dtl = this.xgt_sub_task_dtlDao.queryById(xgt_sub_task_dtlId);
    	model.addAttribute(xgt_sub_task_dtl);
		LogObjectHolder.me().set(xgt_sub_task_dtl);
                                 List<Map<String, Object>> list1 = xgt_sub_task_dtlDao.getMap1();
                                 model.addAttribute("map1",list1);
                     List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("正确与否");
                     model.addAttribute("map6",list6);
                                 List<Map<String, Object>> list9 = xgt_sub_task_dtlDao.getMap9();
                                 model.addAttribute("map9",list9);
                     List<Map<String, Object>> list10 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map10",list10);
        return PREFIX + "xgt_sub_task_dtl_edit.html";
    }

    /**
     * 获取任务详情列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_task_dtlDao.list(condition,st_id);
        return super.warpObject(new Xgt_sub_task_dtlWarpper(list));
    }

    /**
     * 获取任务详情列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer st_id) {

        List<Map<String, Object>> list = this.xgt_sub_task_dtlDao.list(condition,st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_sub_task_dtlWarpper(list)));
        return map;
    }

    /**
     * 新增任务详情
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_sub_task_dtl xgt_sub_task_dtl) {
        return this.xgt_sub_task_dtlMapper.insert(xgt_sub_task_dtl);
    }

    /**
     * 删除任务详情
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_sub_task_dtlIds) {
        //物理删除
    	//this.xgt_sub_task_dtlMapper.deleteById(xgt_sub_task_dtlId);
    	//逻辑删除
    	  String[] split =xgt_sub_task_dtlIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_sub_task_dtlDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改任务详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_sub_task_dtl xgt_sub_task_dtl) {
    	this.xgt_sub_task_dtlMapper.updateById(xgt_sub_task_dtl);
        return super.SUCCESS_TIP;
    }


	/**
     * 跳转到详情任务详情
     */
    @RequestMapping("/xgt_sub_task_dtl_detail/{xgt_sub_task_dtlId}")
    public String xgt_sub_task_dtlDetail(@PathVariable Integer xgt_sub_task_dtlId, Model model) {
    	Xgt_sub_task_dtl xgt_sub_task_dtl = this.xgt_sub_task_dtlDao.queryById(xgt_sub_task_dtlId);
    	model.addAttribute(xgt_sub_task_dtl);
                                 List<Map<String, Object>> list1 = xgt_sub_task_dtlDao.getMap1();
                                 model.addAttribute("map1",list1);
                     List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("正确与否");
                     model.addAttribute("map6",list6);
                                 List<Map<String, Object>> list9 = xgt_sub_task_dtlDao.getMap9();
                                 model.addAttribute("map9",list9);
                     List<Map<String, Object>> list10 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map10",list10);

		LogObjectHolder.me().set(xgt_sub_task_dtl);
        return PREFIX + "xgt_sub_task_dtl_detail.html";
    }

     /**
     * 导出任务详情
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_sub_task_dtl.xls";
    	String tarPath = "src/main/resources/excel/xgt_sub_task_dtl.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_sub_task_dtlDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_sub_task_dtl"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_sub_task_dtl.xls")));
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
