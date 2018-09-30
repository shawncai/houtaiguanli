package wy.addons.zcgl.products.controller;

import wy.addons.zcgl.products.dao.Xgt_goods_productMapper;
import wy.addons.zcgl.products.model.Xgt_goods_product;
import wy.config.properties.XydProperties;
import wy.core.base.controller.BaseController;
import wy.core.log.LogObjectHolder;
import wy.core.node.ZTreeNode;
import wy.core.shiro.ShiroKit;
import wy.addons.zcgl.products.dao.Xgt_goods_productDao;
import wy.addons.zcgl.products.warpper.Xgt_goods_productWarpper;
import wy.xydframe.system.dao.UserMgrDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@Resource
    XydProperties xydProperties;
	
	public static List<Map<String, Object>> paramList = null;

    /**
     * 跳转到商品管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "xgt_goods_product.html";
    }

    /**
     * 跳转到添加商品管理
     */
    @RequestMapping("/xgt_goods_product_add")
    public String xgt_goods_productAdd(Model model) {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
        List<Map<String, Object>> prdClsList=xgt_goods_productDao.prdClsList(cpnId);
        List<Map<String, Object>> prdUnitList=xgt_goods_productDao.prdUnitList();
        model.addAttribute("prdClsList",prdClsList);
        model.addAttribute("prdUnitList",prdUnitList);
        return PREFIX + "xgt_goods_product_add.html";
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
        xgt_goods_product.setPrd_nm_img(xydProperties.getUrl()+"/"+xgt_goods_product.getPrd_nm_img());
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
        List<Map<String, Object>> prdClsList=xgt_goods_productDao.prdClsList(cpnId);
        List<Map<String, Object>> prdUnitList=xgt_goods_productDao.prdUnitList();
        model.addAttribute("prdClsList",prdClsList);
        model.addAttribute("prdUnitList",prdUnitList);
    	model.addAttribute(xgt_goods_product);
		LogObjectHolder.me().set(xgt_goods_product);
        return PREFIX + "xgt_goods_product_edit.html";
    }

	/**
     * 跳转到详情商品管理
     */
    @RequestMapping("/xgt_goods_product_detail/{xgt_goods_productId}")
    public String xgt_goods_productDetail(@PathVariable Integer xgt_goods_productId, Model model) {
    	Xgt_goods_product xgt_goods_product = this.xgt_goods_productDao.queryById(xgt_goods_productId);
    	xgt_goods_product.setPrd_nm_img(xydProperties.getUrl()+"/"+xgt_goods_product.getPrd_nm_img());
        model.addAttribute(xgt_goods_product);
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = managerDao.queryCpnId(userId);
        List<Map<String, Object>> prdClsList=xgt_goods_productDao.prdClsList(cpnId);
        List<Map<String, Object>> prdUnitList=xgt_goods_productDao.prdUnitList();
        model.addAttribute("prdClsList",prdClsList);
        model.addAttribute("prdUnitList",prdUnitList);
		LogObjectHolder.me().set(xgt_goods_product);
        return PREFIX + "xgt_goods_product_detail.html";
    
    }

    /**
     * 获取商品管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String condition,@RequestParam(required = false)Integer st_id,@RequestParam(required = false)Integer prd_id) {
    paramList = null;
        Integer id = ShiroKit.getUser().getId();
        int cpnId = managerDao.queryCpnId(id);
        if (null==prd_id){
            prd_id=0;
        }
        List<Map<String, Object>> list = this.xgt_goods_productDao.list2(cpnId,condition,st_id,prd_id);
        return super.warpObject(new Xgt_goods_productWarpper(list));
    }


    /**
     * 新增商品管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Xgt_goods_product xgt_goods_product) {
        Integer userId = ShiroKit.getUser().getId();
        String userName = ShiroKit.getUser().getName();
        Integer cpnId = managerDao.queryCpnId(userId);
        Integer cpnBranchId = managerDao.queryCpnBrandId(userId);
        xgt_goods_product.setCpn_id(cpnId);
        xgt_goods_product.setCpn_branch_id(cpnBranchId);
        xgt_goods_product.setOper_user(userName);
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


    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        Integer userId = ShiroKit.getUser().getId();
        Integer cpnId = xgt_goods_productDao.queryCpnId(userId);
        if (ShiroKit.isAdmin()){
            List<ZTreeNode> tree= this.xgt_goods_productDao.tree1();
            tree.add(ZTreeNode.createParent());
            return tree;
        }
        else {
            List<ZTreeNode> tree= this.xgt_goods_productDao.tree(cpnId);
            tree.add(ZTreeNode.createParent());
            return tree;
        }
    }
    /* *//**
     * 导出商品管理
     *//*
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
    	String resourcePath = "src/main/resources/excelTemplate/xgt_goods_product.xls";
    	String tarPath = "src/main/resources/excel/xgt_goods_product.xls";
    	Integer condition = null;
        Integer id = ShiroKit.getUser().getId();
        int cpnId = managerDao.queryCpnId(id);
    	 List<Map<String, Object>> list = this.xgt_goods_productDao.list(cpnId);
    	 Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
	     beanParams.put("list", list);
	     XLSTransformer former = new XLSTransformer();
	     former.transformXLS(resourcePath, beanParams, tarPath);

	     //下载
		String fileName = "xgt_goods_product"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_product.xls")));
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
    }*/
}
