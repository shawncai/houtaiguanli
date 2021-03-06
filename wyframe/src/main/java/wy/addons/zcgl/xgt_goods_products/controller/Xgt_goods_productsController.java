package wy.addons.zcgl.xgt_goods_products.controller;

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
import wy.addons.zcgl.xgt_goods_products.model.Xgt_goods_products;
import org.springframework.web.bind.annotation.PathVariable;
import wy.addons.zcgl.xgt_goods_products.dao.Xgt_goods_productsDao;
import wy.addons.zcgl.xgt_goods_products.dao.Xgt_goods_productsMapper;
import wy.addons.zcgl.xgt_goods_products.warpper.Xgt_goods_productsWarpper;

/**
 * 商品测试控制器
 *
 * @author wyFrame
 * @Date 2018-07-20 20:23:12
 */
@Controller
@RequestMapping("/xgt_goods_products")
public class Xgt_goods_productsController extends BaseController {

    private String PREFIX = "/addons/zcgl/xgt_goods_products/";
	@Resource
	Xgt_goods_productsDao xgt_goods_productsDao;
	
	@Resource
	Xgt_goods_productsMapper xgt_goods_productsMapper;

	@Resource
    XydProperties xydProperties;
	
    /**
     * 跳转到商品测试首页
     */
    @RequestMapping("")
    public String index(Model model) {
                 List<Map<String, Object>> list18 = ConstantFactory.me().getDictByName("删除状态");
                 model.addAttribute("map18",list18);
        return PREFIX + "xgt_goods_products.html";
    }

    /**
     * 跳转到添加商品测试
     */
    @RequestMapping("/xgt_goods_products_add")
    public String xgt_goods_productsAdd(Model model) {
                   List<Map<String, Object>> list2 = xgt_goods_productsDao.getMap2();
                   model.addAttribute("map2",list2);
                   List<Map<String, Object>> list4 = xgt_goods_productsDao.getMap4();
                   model.addAttribute("map4",list4);
                   List<Map<String, Object>> list6 = xgt_goods_productsDao.getMap6();
                   model.addAttribute("map6",list6);
                   List<Map<String, Object>> list15 = xgt_goods_productsDao.getMap15();
                   model.addAttribute("map15",list15);
             List<Map<String, Object>> list18 = ConstantFactory.me().getDictByName("删除状态");
             model.addAttribute("map18",list18);
        return PREFIX + "xgt_goods_products_add.html";
    }

    /**
     * 跳转到修改商品测试
     */
    @RequestMapping("/xgt_goods_products_update/{xgt_goods_productsId}")
    public String xgt_goods_productsUpdate(@PathVariable Integer xgt_goods_productsId, Model model) {
    	Xgt_goods_products xgt_goods_products = this.xgt_goods_productsDao.queryById(xgt_goods_productsId);
    	        xgt_goods_products.setPrd_nm_img(xydProperties.getUrl()+"/"+xgt_goods_products.getPrd_nm_img());
    	model.addAttribute(xgt_goods_products);
		LogObjectHolder.me().set(xgt_goods_products);
                                 List<Map<String, Object>> list2 = xgt_goods_productsDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list4 = xgt_goods_productsDao.getMap4();
                                 model.addAttribute("map4",list4);
                                 List<Map<String, Object>> list6 = xgt_goods_productsDao.getMap6();
                                 model.addAttribute("map6",list6);
                                 List<Map<String, Object>> list15 = xgt_goods_productsDao.getMap15();
                                 model.addAttribute("map15",list15);
                     List<Map<String, Object>> list18 = ConstantFactory.me().getDictByName("删除状态");
                     model.addAttribute("map18",list18);
        return PREFIX + "xgt_goods_products_edit.html";
    }

    /**
     * 获取商品测试列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition ,Integer xyd_st_id) {
        if(null==xyd_st_id){
        xyd_st_id=1;
        }
        List<Map<String, Object>> list = this.xgt_goods_productsDao.list(condition,xyd_st_id);
        return super.warpObject(new Xgt_goods_productsWarpper(list));
    }

    /**
     * 获取商品测试列表
     */
    @RequestMapping(value = "/editList")
    @ResponseBody
    public Object editList(String condition,Integer xyd_st_id) {
        if(null==xyd_st_id){
               xyd_st_id=1;
        }
        List<Map<String, Object>> list = this.xgt_goods_productsDao.list(condition,xyd_st_id);
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",super.warpObject(new Xgt_goods_productsWarpper(list)));
        return map;
    }

    /**
     * 新增商品测试
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_goods_products xgt_goods_products) {
        xgt_goods_products.setXyd_st_id(1);
        xgt_goods_products.setXyd_cre_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_goods_products.setXyd_up_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_goods_products.setId(ShiroKit.getUser().getId());
        return this.xgt_goods_productsMapper.insert(xgt_goods_products);
    }

    /**
     * 删除商品测试
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String xgt_goods_productsIds) {
        //物理删除
    	//this.xgt_goods_productsMapper.deleteById(xgt_goods_productsId);
    	//逻辑删除
    	  String[] split =xgt_goods_productsIds.split(",");
          Integer[] iarray = new Integer[split.length];
          for(int i=0;i<split.length;i++){
              iarray[i]=Integer.parseInt(split[i]);
           }
          List<Integer> list = Arrays.asList(iarray);
    	this.xgt_goods_productsDao.deleteByIds(list);
        return SUCCESS_TIP;
    }

     /**
     * 修改商品测试
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_goods_products xgt_goods_products) {
        xgt_goods_products.setXyd_up_dt(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        xgt_goods_products.setId(ShiroKit.getUser().getId());
    	this.xgt_goods_productsMapper.updateById(xgt_goods_products);
        return super.SUCCESS_TIP;
    }


	/**
     * 跳转到详情商品测试
     */
    @RequestMapping("/xgt_goods_products_detail/{xgt_goods_productsId}")
    public String xgt_goods_productsDetail(@PathVariable Integer xgt_goods_productsId, Model model) {
    	Xgt_goods_products xgt_goods_products = this.xgt_goods_productsDao.queryById(xgt_goods_productsId);
            	        xgt_goods_products.setPrd_nm_img(xydProperties.getUrl()+"/"+xgt_goods_products.getPrd_nm_img());
    	model.addAttribute(xgt_goods_products);
                                 List<Map<String, Object>> list2 = xgt_goods_productsDao.getMap2();
                                 model.addAttribute("map2",list2);
                                 List<Map<String, Object>> list4 = xgt_goods_productsDao.getMap4();
                                 model.addAttribute("map4",list4);
                                 List<Map<String, Object>> list6 = xgt_goods_productsDao.getMap6();
                                 model.addAttribute("map6",list6);
                                 List<Map<String, Object>> list15 = xgt_goods_productsDao.getMap15();
                                 model.addAttribute("map15",list15);
                     List<Map<String, Object>> list18 = ConstantFactory.me().getDictByName("删除状态");
                     model.addAttribute("map18",list18);

		LogObjectHolder.me().set(xgt_goods_products);
        return PREFIX + "xgt_goods_products_detail.html";
    }

     /**
     * 导出商品测试
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_goods_products.xls";
    	String tarPath = "src/main/resources/excel/xgt_goods_products.xls";
    	String condition = null;
    	// List<Map<String, Object>> list = this.xgt_goods_productsDao.list(condition);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();  
	    // beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();  
	     former.transformXLS(resourcePath, beanParams, tarPath); 
	     
	     //下载
		String fileName = "xgt_goods_products"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_products.xls")));
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
