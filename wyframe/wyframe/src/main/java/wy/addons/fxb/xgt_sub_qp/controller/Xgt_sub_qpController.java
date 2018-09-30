package wy.addons.fxb.xgt_sub_qp.controller;

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
import wy.addons.fxb.xgt_sub_qp.model.Xgt_sub_qp;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.fxb.xgt_sub_qp.dao.Xgt_sub_qpDao;
import wy.addons.fxb.xgt_sub_qp.dao.Xgt_sub_qpMapper;
import wy.addons.fxb.xgt_sub_qp.warpper.Xgt_sub_qpWarpper;

/**
 * 题目控制器
 *
 * @author wyFrame
 * @Date 2018-09-12 16:19:48
 */
@Controller
@RequestMapping("/xgt_sub_qp")
public class Xgt_sub_qpController extends BaseController {

    private String PREFIX = "/addons/fxb/xgt_sub_qp/";
	@Resource
	Xgt_sub_qpDao xgt_sub_qpDao;
	
	@Resource
	Xgt_sub_qpMapper xgt_sub_qpMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到题目首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list17 = ConstantFactory.me().getDictByName("状态");
                 model.addAttribute("map17",list17);
        return PREFIX + "xgt_sub_qp.html";
    }

    /**
     * 跳转到添加题目
     */
    @RequestMapping("/xgt_sub_qp_add")
    public String xgt_sub_qpAdd(Model model) {
                   List<Map<String, Object>> list2 = xgt_sub_qpDao.getMap2();
                   model.addAttribute("map2",list2);
                   List<Map<String, Object>> list3 = xgt_sub_qpDao.getMap3();
                   model.addAttribute("map3",list3);
             List<Map<String, Object>> list4 = ConstantFactory.me().getDictByName("题目类型");
             model.addAttribute("map4",list4);
             List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("题目难度");
             model.addAttribute("map5",list5);
             List<Map<String, Object>> list14 = ConstantFactory.me().getDictByName("题目分类");
             model.addAttribute("map14",list14);
             List<Map<String, Object>> list17 = ConstantFactory.me().getDictByName("状态");
             model.addAttribute("map17",list17);
                   List<Map<String, Object>> list18 = xgt_sub_qpDao.getMap18();
                   model.addAttribute("map18",list18);
        return PREFIX + "xgt_sub_qp_add.html";
    }

    /**
     * 跳转到修改题目
     */
    @RequestMapping("/xgt_sub_qp_update/{xgt_sub_qpId}")
    public String xgt_sub_qpUpdate(@PathVariable Integer xgt_sub_qpId, Model model) {
    	Xgt_sub_qp xgt_sub_qp = this.xgt_sub_qpDao.queryById(xgt_sub_qpId);
    	model.addAttribute(xgt_sub_qp);
		LogObjectHolder.me().set(xgt_sub_qp);
                                 List<Map<String, Object>> list2 = xgt_sub_qpDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_qpDao.getMap3();
                                 model.addAttribute("map3",list3);
                     List<Map<String, Object>> list4 = ConstantFactory.me().getDictByName("题目类型");
                     model.addAttribute("map4",list4);
                     List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("题目难度");
                     model.addAttribute("map5",list5);
                     List<Map<String, Object>> list14 = ConstantFactory.me().getDictByName("题目分类");
                     model.addAttribute("map14",list14);
                     List<Map<String, Object>> list17 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map17",list17);
                                 List<Map<String, Object>> list18 = xgt_sub_qpDao.getMap18();
                                 model.addAttribute("map18",list18);
        return PREFIX + "xgt_sub_qp_edit.html";
    }

    /**
     * 获取题目列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_qpDao.list(condition,st_id);
        return super.warpObject(new Xgt_sub_qpWarpper(list));
    }

    /**
     * 获取题目列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer st_id) {
        List<Map<String, Object>> list = this.xgt_sub_qpDao.list(condition,st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_sub_qpWarpper(list)));
        return map;
    }

    /**
     * 新增题目
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_sub_qp xgt_sub_qp) {
        xgt_sub_qp.setSt_id(1);
        xgt_sub_qp.setCre_dt(new Date());
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId=xgt_sub_qpDao.queryCpnId(userId);
        xgt_sub_qp.setCpn_id(cpnId);
        return this.xgt_sub_qpMapper.insert(xgt_sub_qp);
    }

    /**
     * 删除题目
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_sub_qpIds) {
        //物理删除
    	//this.xgt_sub_qpMapper.deleteById(xgt_sub_qpId);
    	//逻辑删除
    	  String[] split =xgt_sub_qpIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_sub_qpDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改题目
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_sub_qp xgt_sub_qp) {
    	this.xgt_sub_qpMapper.updateById(xgt_sub_qp);
        return super.SUCCESS_TIP;
    }


	/**
     * 跳转到详情题目
     */
    @RequestMapping("/xgt_sub_qp_detail/{xgt_sub_qpId}")
    public String xgt_sub_qpDetail(@PathVariable Integer xgt_sub_qpId, Model model) {
    	Xgt_sub_qp xgt_sub_qp = this.xgt_sub_qpDao.queryById(xgt_sub_qpId);
    	model.addAttribute(xgt_sub_qp);
                                 List<Map<String, Object>> list2 = xgt_sub_qpDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list3 = xgt_sub_qpDao.getMap3();
                                 model.addAttribute("map3",list3);
                     List<Map<String, Object>> list4 = ConstantFactory.me().getDictByName("题目类型");
                     model.addAttribute("map4",list4);
                     List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("题目难度");
                     model.addAttribute("map5",list5);
                     List<Map<String, Object>> list14 = ConstantFactory.me().getDictByName("题目分类");
                     model.addAttribute("map14",list14);
                     List<Map<String, Object>> list17 = ConstantFactory.me().getDictByName("状态");
                     model.addAttribute("map17",list17);
                                 List<Map<String, Object>> list18 = xgt_sub_qpDao.getMap18();
                                 model.addAttribute("map18",list18);

		LogObjectHolder.me().set(xgt_sub_qp);
        return PREFIX + "xgt_sub_qp_detail.html";
    }

     /**
     * 导出题目
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_sub_qp.xls";
    	String tarPath = "src/main/resources/excel/xgt_sub_qp.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_sub_qpDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_sub_qp"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_sub_qp.xls")));
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
