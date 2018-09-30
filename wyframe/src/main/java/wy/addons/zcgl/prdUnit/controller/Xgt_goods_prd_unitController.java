package wy.addons.zcgl.prdUnit.controller;

import wy.addons.zcgl.prdUnit.dao.Xgt_goods_prd_unitDao;
import wy.addons.zcgl.prdUnit.dao.Xgt_goods_prd_unitMapper;
import wy.addons.zcgl.prdUnit.model.Xgt_goods_prd_unit;
import wy.addons.zcgl.prdUnit.warpper.Xgt_goods_prd_unitWarpper;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;
import wy.core.shiro.ShiroKit;
import wy.xydframe.system.dao.UserMgrDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品单位控制器
 *
 * @author wyframe
 * @Date 2017-11-21 21:15:14
 */
@Controller
@RequestMapping("/xgt_goods_prd_unit")
public class Xgt_goods_prd_unitController extends BaseController {
    private String PREFIX = "/addons/zcgl/prdUnit/";

    
	@Resource
    Xgt_goods_prd_unitDao xgt_goods_prd_unitDao;
	
	@Resource
    Xgt_goods_prd_unitMapper xgt_goods_prd_unitMapper;

    @Resource
    private UserMgrDao managerDao;
	
	public static List<Map<String, Object>> paramList = null;
    /**
     * 跳转到产品单位首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xgt_goods_prd_unit.html";
    }

    /**
     * 跳转到添加产品单位
     */
    @RequestMapping("/xgt_goods_prd_unit_add")
    public String xgt_goods_prd_unitAdd() {
//        return PREFIX + "xgt_goods_prd_unit_add.html";
    	return PREFIX + "prd_unit_add.html";
    }
    
    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_goods_prd_unit_add_param")
	public String xgt_goods_prd_unit_add_param() {
		return PREFIX + "xgt_goods_prd_unit_add_param.html";
	}

    /**
     * 跳转到修改产品单位
     */
    @RequestMapping("/xgt_goods_prd_unit_update/{xgt_goods_prd_unitId}")
    public String xgt_goods_prd_unitUpdate(@PathVariable Integer xgt_goods_prd_unitId, Model model) {
    	Xgt_goods_prd_unit xgt_goods_prd_unit = this.xgt_goods_prd_unitDao.queryById(xgt_goods_prd_unitId);
    	model.addAttribute(xgt_goods_prd_unit);
		LogObjectHolder.me().set(xgt_goods_prd_unit);
//        return PREFIX + "xgt_goods_prd_unit_edit.html";
		return PREFIX + "prd_unit_edit.html";
    }

	/**
     * 跳转到详情产品单位
     */
    @RequestMapping("/xgt_goods_prd_unit_detail/{xgt_goods_prd_unitId}")
    public String xgt_goods_prd_unitDetail(@PathVariable Integer xgt_goods_prd_unitId, Model model) {
    	Xgt_goods_prd_unit xgt_goods_prd_unit = this.xgt_goods_prd_unitDao.queryById(xgt_goods_prd_unitId);
    	model.addAttribute(xgt_goods_prd_unit);
		LogObjectHolder.me().set(xgt_goods_prd_unit);
//        return PREFIX + "xgt_goods_prd_unit_detail.html";
		return PREFIX + "prd_unit_detail.html";
    }

    /**
     * 获取产品单位列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    paramList = null;
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
        List<Map<String, Object>> list = this.xgt_goods_prd_unitDao.list(condition);
        return super.warpObject(new Xgt_goods_prd_unitWarpper(list));
    }

    /**
     * 获取全部产品单位
     */
    @RequestMapping(value = "/prdUnitList")
    @ResponseBody
    public Object prdUnitList() {
    List<Map<String, Object>> prdUnitList = this.xgt_goods_prd_unitDao.prdUnitList();
        return prdUnitList;
    }

    public List<Map<String, Object>> unitList() {
    List<Map<String, Object>> unitList = this.xgt_goods_prd_unitDao.prdUnitList();
    return unitList;
    }
    
    /**
     * 新增产品单位
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_goods_prd_unit xgt_goods_prd_unit) {
        return this.xgt_goods_prd_unitMapper.insert(xgt_goods_prd_unit);
    }

    /**
     * 删除产品单位
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xgt_goods_prd_unitId) {
    	this.xgt_goods_prd_unitMapper.deleteById(xgt_goods_prd_unitId);
        return SUCCESS_TIP;
    }
    /**
     * 模糊查询
     */
    @RequestMapping(value = "findByName")
    @ResponseBody
    public Object findByName(String condition){
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
        List<Map<String, Object>> list = this.xgt_goods_prd_unitDao.findByName(condition);
        return list;
    }

    /**
     * 修改产品单位
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_goods_prd_unit xgt_goods_prd_unit) {
    	this.xgt_goods_prd_unitMapper.updateById(xgt_goods_prd_unit);
    	paramList=null;
        return super.SUCCESS_TIP;
    }
    
     /**
     * 导出产品单位
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_goods_prd_unit.xls";
    	String tarPath = "src/main/resources/excel/xgt_goods_prd_unit.xls";
    	String condition = null;
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
    	 List<Map<String, Object>> list = this.xgt_goods_prd_unitDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	     beanParams.put("list", list);  
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_goods_prd_unit"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_prd_unit.xls")));
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
