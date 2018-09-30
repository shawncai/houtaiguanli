package wy.rest.addons.zcgl.products.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.base.controller.BaseController;
import wy.rest.addons.zcgl.products.dao.Xgt_goods_productDao;
import wy.rest.addons.zcgl.products.dao.Xgt_goods_productMapper;
import wy.rest.addons.zcgl.products.model.Xgt_goods_product;
import wy.rest.common.persistence.dao.UserMgrDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品管理控制器
 *
 * @author wyframe
 * @Date 2018-05-08 16:35:29
 */
@Controller
@RequestMapping("/xgt_goods_product")
public class Xgt_goods_productController extends BaseController {
    private String PREFIX = "/addons/zcgl/products/";
	@Resource
    Xgt_goods_productDao xgt_goods_productDao;
	
	@Resource
    Xgt_goods_productMapper xgt_goods_productMapper;

	@Resource
    private UserMgrDao managerDao;


	public static List<Map<String, Object>> paramList = null;

    /**
     * 跳转到商品管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xgt_goods_product.html";
    }


    /**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_goods_product_add_param")
	public String xgt_goods_product_add_param() {
		return PREFIX + "xgt_goods_product_add_param.html";
	}

    /**
     * 跳转到修改商品管理
     */
    @RequestMapping("/xgt_goods_product_update/{xgt_goods_productId}")
    public String xgt_goods_productUpdate(@PathVariable Integer xgt_goods_productId, Model model) {
    	Xgt_goods_product xgt_goods_product = this.xgt_goods_productDao.queryById(xgt_goods_productId);
        Integer cpnId = managerDao.queryCpnId(null);
        List<Map<String, Object>> prdClsList=xgt_goods_productDao.prdClsList(cpnId);
        List<Map<String, Object>> prdUnitList=xgt_goods_productDao.prdUnitList();
        model.addAttribute("prdClsList",prdClsList);
        model.addAttribute("prdUnitList",prdUnitList);
    	model.addAttribute(xgt_goods_product);
        System.out.println("");
        return PREFIX + "xgt_goods_product_edit.html";
    }

	/**
     * 跳转到详情商品管理
     */
    @RequestMapping("/xgt_goods_product_detail/{xgt_goods_productId}")
    public String xgt_goods_productDetail(@PathVariable Integer xgt_goods_productId, Model model) {
    	Xgt_goods_product xgt_goods_product = this.xgt_goods_productDao.queryById(xgt_goods_productId);
        model.addAttribute(xgt_goods_product);
        Integer cpnId = managerDao.queryCpnId(null);
        List<Map<String, Object>> prdClsList=xgt_goods_productDao.prdClsList(cpnId);
        List<Map<String, Object>> prdUnitList=xgt_goods_productDao.prdUnitList();
        model.addAttribute("prdClsList",prdClsList);
        model.addAttribute("prdUnitList",prdUnitList);
        return PREFIX + "xgt_goods_product_detail.html";
    
    }

    /**
     * 获取商品管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String condition,@RequestParam(required = false)Integer st_id,@RequestParam(required = false)Integer prd_id) {
        List<Xgt_goods_product> list = this.xgt_goods_productMapper.selectList(new EntityWrapper<Xgt_goods_product>());
        return list;
    }


    /**
     * 新增商品管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody Xgt_goods_product xgt_goods_product) {
        xgt_goods_product.setCpn_id(1);
        xgt_goods_product.setCpn_branch_id(1);
        xgt_goods_product.setOper_user(null);
        xgt_goods_product.setSt_id(1);
        xgt_goods_product.setCre_dt(new Date());
        xgt_goods_product.setPrd_crt_dt(new Date());
        xgt_goods_product.setPrd_nm(xgt_goods_product.getPrd_nm_alias()+"/"+xgt_goods_product.getPrd_sn()+"/"+xgt_goods_product.getPrd_model()+"/"+xgt_goods_product.getPrd_spec());
        return this.xgt_goods_productMapper.insert(xgt_goods_product);
    }

    /**
     * 删除商品管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer xgt_goods_productId) {
    	this.xgt_goods_productMapper.deleteById(xgt_goods_productId);
        return SUCCESS_TIP;
    }

    /**
     * 修改商品管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_goods_product xgt_goods_product) {
    	this.xgt_goods_productMapper.updateById(xgt_goods_product);
    	paramList=null;
        return super.SUCCESS_TIP;
    }



}
