package wy.addons.zcgl.prdBrand.controller;

import wy.addons.zcgl.prdBrand.dao.Xgt_goods_prd_brandDao;
import wy.addons.zcgl.prdBrand.dao.Xgt_goods_prd_brandMapper;
import wy.addons.zcgl.prdBrand.model.Xgt_goods_prd_brand;
import wy.addons.zcgl.prdBrand.warpper.Xgt_goods_prd_brandWarpper;
import wy.core.base.controller.BaseController;
import wy.core.node.ZTreeNode;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品品牌控制器
 *
 * @author wyframe
 * @Date 2017-11-21 21:07:58
 */
@Controller
@RequestMapping("/xgt_goods_prd_brand")
public class Xgt_goods_prd_brandController extends BaseController {
	private String PREFIX = "/addons/zcgl/prdBrand/";

	@Resource
	Xgt_goods_prd_brandDao xgt_goods_prd_brandDao;

	@Resource
	Xgt_goods_prd_brandMapper xgt_goods_prd_brandMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到产品品牌首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xgt_goods_prd_brand.html";
	}

	/**
	 * 跳转到添加产品品牌
	 */
	@RequestMapping("/xgt_goods_prd_brand_add/{brandId}")
	public String xgt_goods_prd_brandAdd(@PathVariable("brandId") Integer brandId,Model model) {
		Integer userId = ShiroKit.getUser().getId();
		String brandNm=xgt_goods_prd_brandDao.selectBrandNm(brandId);
		model.addAttribute("brandId", brandId);
		model.addAttribute("brandNm", brandNm);
		return PREFIX + "prd_brand_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_goods_prd_brand_add_param")
	public String xgt_goods_prd_brand_add_param() {
		return PREFIX + "xgt_goods_prd_brand_add_param.html";
	}

	/**
	 * 跳转到修改产品品牌
	 */
	@RequestMapping("/xgt_goods_prd_brand_update/{xgt_goods_prd_brandId}")
	public String xgt_goods_prd_brandUpdate(@PathVariable Integer xgt_goods_prd_brandId, Model model) {
		Xgt_goods_prd_brand xgt_goods_prd_brand = this.xgt_goods_prd_brandDao.queryById(xgt_goods_prd_brandId);
		Integer parPrdBrandid=xgt_goods_prd_brand.getPar_prd_brand_id();
		System.err.println("parPrdBrandid:"+parPrdBrandid);
		String pBrandName=xgt_goods_prd_brandDao.queryBrandNm(parPrdBrandid);
		System.err.println(pBrandName);
		model.addAttribute("pBrandName", pBrandName);
		model.addAttribute("brandId",xgt_goods_prd_brandId);
		model.addAttribute(xgt_goods_prd_brand);
		LogObjectHolder.me().set(xgt_goods_prd_brand);
		return PREFIX + "prd_brand_edit.html";
	}

	/**
	 * 跳转到详情产品品牌
	 */
	@RequestMapping("/xgt_goods_prd_brand_detail/{xgt_goods_prd_brandId}")
	public String xgt_goods_prd_brandDetail(@PathVariable Integer xgt_goods_prd_brandId, Model model) {
		Xgt_goods_prd_brand xgt_goods_prd_brand = this.xgt_goods_prd_brandDao.queryById(xgt_goods_prd_brandId);
		Integer parPrdBrandid=xgt_goods_prd_brand.getPar_prd_brand_id();
		String pBrandName=xgt_goods_prd_brandDao.queryBrandNm(parPrdBrandid);
		model.addAttribute("pBrandName", pBrandName);
		model.addAttribute("brandId",xgt_goods_prd_brandId);
		model.addAttribute(xgt_goods_prd_brand);
		LogObjectHolder.me().set(xgt_goods_prd_brand);
		return PREFIX + "prd_brand_detail.html";
	}

	/**
	 * 获取产品品牌列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String condition,@RequestParam(required = false) Integer prd_brand_id) {
		paramList = null;
		Integer userId = ShiroKit.getUser().getId();
		System.err.println(prd_brand_id);
		Integer cpnId = xgt_goods_prd_brandDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			if (null==prd_brand_id){
				prd_brand_id=0;
			}
			List<Map<String, Object>> list = this.xgt_goods_prd_brandDao.list(condition,prd_brand_id);
			System.err.println("list："+list);
			return super.warpObject(new Xgt_goods_prd_brandWarpper(list));
		}
		else {
			if (null==prd_brand_id){
				prd_brand_id=0;
			}
			List<Map<String, Object>> list = this.xgt_goods_prd_brandDao.list2(condition,cpnId,prd_brand_id);
			System.err.println("list2："+list);
			return super.warpObject(new Xgt_goods_prd_brandWarpper(list));
		}
	}

	/**
	 * 获取全部产品品牌
	 */
	public List<Map<String, Object>> brandList() {
		paramList = null;
		List<Map<String, Object>> brandList = this.xgt_goods_prd_brandDao.brandList();
		return brandList;
	}


	/**
	 * 获取品牌的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree(){
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xgt_goods_prd_brandDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			List<ZTreeNode> tree =this.xgt_goods_prd_brandDao.tree1();
			tree.add(ZTreeNode.createParent());
			return tree;
		}else {
			List<ZTreeNode> tree =this.xgt_goods_prd_brandDao.tree(cpnId);
			tree.add(ZTreeNode.createParent());
			return tree;
		}
	}

	/**
	 * 新增产品品牌
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xgt_goods_prd_brand xgt_goods_prd_brand) {
		Integer userId = ShiroKit.getUser().getId();
		String userName = ShiroKit.getUser().getName();
		Integer cpnId = xgt_goods_prd_brandDao.queryCpnId(userId);
		Integer cpnBranchId = xgt_goods_prd_brandDao.queryCpnBrandId(userId);
		xgt_goods_prd_brand.setCpn_id(cpnId);
		xgt_goods_prd_brand.setCpn_branch_id(cpnBranchId);
		xgt_goods_prd_brand.setOper_user(userName);
		xgt_goods_prd_brand.setSt_id(1);
		xgt_goods_prd_brand.setCre_dt(new Date());
		return this.xgt_goods_prd_brandMapper.insert(xgt_goods_prd_brand);
	}

	/**
	 * 删除产品品牌
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xgt_goods_prd_brandId) {
		this.xgt_goods_prd_brandDao.updateBrandById(xgt_goods_prd_brandId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改产品品牌
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xgt_goods_prd_brand xgt_goods_prd_brand) {
		this.xgt_goods_prd_brandMapper.updateById(xgt_goods_prd_brand);
		paramList=null;
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出产品品牌
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xgt_goods_prd_brand.xls";
		String tarPath = "src/main/resources/excel/xgt_goods_prd_brand.xls";
		Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);

		//下载
		String fileName = "xgt_goods_prd_brand"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_prd_brand.xls")));
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
