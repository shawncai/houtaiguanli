package wy.addons.fxb.xgt_subject.controller;

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
import wy.addons.fxb.xgt_subject.model.Xgt_subject;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_subject.dao.Xgt_subjectDao;
import wy.addons.fxb.xgt_subject.dao.Xgt_subjectMapper;
import wy.addons.fxb.xgt_subject.warpper.Xgt_subjectWarpper;

/**
 * 科目控制器
 *
 * @author wyFrame
 * @Date 2018-09-05 10:03:14
 */
@Controller
@RequestMapping("/xgt_subject")
public class Xgt_subjectController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_subject/";
	@Resource
	Xgt_subjectDao xgt_subjectDao;
	
	@Resource
	Xgt_subjectMapper xgt_subjectMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到科目首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list3 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map3",list3);
        return PREFIX + "xgt_subject.html";
    }

    /**
     * 跳转到添加科目
     */
    @RequestMapping("/xgt_subject_add")
    public String xgt_subjectAdd(Model model) {
                   List<Map<String, Object>> list2 = xgt_subjectDao.getMap2();
                   model.addAttribute("map2",list2);
             List<Map<String, Object>> list3 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map3",list3);
                   List<Map<String, Object>> list6 = xgt_subjectDao.getMap6();
                   model.addAttribute("map6",list6);
        return PREFIX + "xgt_subject_add.html";
    }

    /**
     * 跳转到修改科目
     */
    @RequestMapping("/xgt_subject_update/{xgt_subjectId}")
    public String xgt_subjectUpdate(@PathVariable Integer xgt_subjectId, Model model) {
    	Xgt_subject xgt_subject = this.xgt_subjectDao.queryById(xgt_subjectId);
    	model.addAttribute(xgt_subject);
		LogObjectHolder.me().set(xgt_subject);
                                 List<Map<String, Object>> list2 = xgt_subjectDao.getMap2();
                                 model.addAttribute("map2",list2);
                     List<Map<String, Object>> list3 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list6 = xgt_subjectDao.getMap6();
                                 model.addAttribute("map6",list6);
        return PREFIX + "xgt_subject_edit.html";
    }

    /**
     * 获取科目列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer xyd_st_id) {
        if(null==xyd_st_id){
        xyd_st_id=1;
        }
        List<Map<String, Object>> list = this.xgt_subjectDao.list(condition,xyd_st_id);
        return super.warpObject(new Xgt_subjectWarpper(list));
    }

    /**
     * 获取科目列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer xyd_st_id) {
        if(null==xyd_st_id){
               xyd_st_id=1;
        }
        List<Map<String, Object>> list = this.xgt_subjectDao.list(condition,xyd_st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_subjectWarpper(list)));
        return map;
    }

    /**
     * 新增科目
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_subject xgt_subject) {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId=xgt_subjectDao.queryCpnId(userId);
        xgt_subject.setXyd_st_id(1);
        xgt_subject.setXyd_cre_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_subject.setXyd_up_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_subject.setId(ShiroKit.getUser().getId());
        xgt_subject.setCpn_id(cpnId);
        return this.xgt_subjectMapper.insert(xgt_subject);
    }

    /**
     * 删除科目
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_subjectIds) {
        //物理删除
    	//this.xgt_subjectMapper.deleteById(xgt_subjectId);
    	//逻辑删除
    	  String[] split =xgt_subjectIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_subjectDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改科目
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_subject xgt_subject) {
        xgt_subject.setXyd_up_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_subject.setId(ShiroKit.getUser().getId());
    	this.xgt_subjectMapper.updateById(xgt_subject);
        return super.SUCCESS_TIP;
    }


	/**
     * 跳转到详情科目
     */
    @RequestMapping("/xgt_subject_detail/{xgt_subjectId}")
    public String xgt_subjectDetail(@PathVariable Integer xgt_subjectId, Model model) {
    	Xgt_subject xgt_subject = this.xgt_subjectDao.queryById(xgt_subjectId);
    	model.addAttribute(xgt_subject);
                                 List<Map<String, Object>> list2 = xgt_subjectDao.getMap2();
                                 model.addAttribute("map2",list2);
                     List<Map<String, Object>> list3 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map3",list3);
                                 List<Map<String, Object>> list6 = xgt_subjectDao.getMap6();
                                 model.addAttribute("map6",list6);

		LogObjectHolder.me().set(xgt_subject);
        return PREFIX + "xgt_subject_detail.html";
    }

     /**
     * 导出科目
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_subject.xls";
    	String tarPath = "src/main/resources/excel/xgt_subject.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_subjectDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_subject"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_subject.xls")));
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
