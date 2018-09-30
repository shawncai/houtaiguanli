package wy.addons.zcgl.prdCls.controller;

import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.prdCls.dao.Xgt_goods_prd_clsDao;
import wy.addons.zcgl.prdCls.dao.Xgt_goods_prd_clsMapper;
import wy.addons.zcgl.prdCls.model.Xgt_goods_prd_cls;
import wy.addons.zcgl.prdCls.warpper.Xgt_goods_prd_clsWarpper;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
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
import wy.xydframe.system.dao.DictDao;
import wy.xydframe.system.dao.UserMgrDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品分类控制器
 *
 * @author wyframe
 * @Date 2017-11-21 21:10:33
 */
@Controller
@RequestMapping("/xgt_goods_prd_cls")
public class Xgt_goods_prd_clsController extends BaseController {
	private String PREFIX = "/addons/zcgl/prdCls/";

	@Resource
	Xgt_goods_prd_clsDao xgt_goods_prd_clsDao;

	@Resource
	Xgt_goods_prd_clsMapper xgt_goods_prd_clsMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到产品分类首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xgt_goods_prd_cls.html";
	}

	/**
	 * 跳转到添加产品分类
	 */
	@RequestMapping("/xgt_goods_prd_cls_add/{clsId}")
	public String xgt_goods_prd_clsAdd(@PathVariable("clsId") Integer clsId, Model model) {
		System.err.println("选中的ID:" + clsId);
		String clsNm = xgt_goods_prd_clsDao.selectClsNm(clsId);
		System.err.println("选中的分类名字:" + clsNm);
		model.addAttribute("clsId", clsId);
		model.addAttribute("clsNm", clsNm);
		return PREFIX + "prd_cls_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_goods_prd_cls_add_param")
	public String xgt_goods_prd_cls_add_param() {
		return PREFIX + "xgt_goods_prd_cls_add_param.html";
	}

	/**
	 * 跳转到修改产品分类
	 */
	@RequestMapping("/xgt_goods_prd_cls_update/{xgt_goods_prd_clsId}")
	public String xgt_goods_prd_clsUpdate(@PathVariable Integer xgt_goods_prd_clsId, Model model) {
		Xgt_goods_prd_cls xgt_goods_prd_cls = this.xgt_goods_prd_clsDao.queryById(xgt_goods_prd_clsId);
		Integer parPrdClsId = xgt_goods_prd_cls.getPar_prd_cls_id();
		String pClsName = xgt_goods_prd_clsDao.queryClsName(parPrdClsId);
		model.addAttribute("pClsName", pClsName);
		model.addAttribute("clsId",xgt_goods_prd_clsId);
		model.addAttribute(xgt_goods_prd_cls);
		LogObjectHolder.me().set(xgt_goods_prd_cls);
		return PREFIX + "prd_cls_edit.html";
	}

	/**
	 * 跳转到详情产品分类
	 */
	@RequestMapping("/xgt_goods_prd_cls_detail/{xgt_goods_prd_clsId}")
	public String xgt_goods_prd_clsDetail(@PathVariable Integer xgt_goods_prd_clsId, Model model) {
		Xgt_goods_prd_cls xgt_goods_prd_cls = this.xgt_goods_prd_clsDao.queryById(xgt_goods_prd_clsId);
		Integer parPrdClsId = xgt_goods_prd_cls.getPar_prd_cls_id();
		String pClsName = xgt_goods_prd_clsDao.queryClsName(parPrdClsId);
		model.addAttribute("pClsName", pClsName);
		model.addAttribute("clsId",xgt_goods_prd_clsId);
		model.addAttribute(xgt_goods_prd_cls);
		LogObjectHolder.me().set(xgt_goods_prd_cls);
		return PREFIX + "prd_cls_detail.html";
	}

	/**
	 * 获取产品分类列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String condition,@RequestParam(required = false) Integer prd_cls_id) {
		paramList = null;
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xgt_goods_prd_clsDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			if (null==prd_cls_id){
				prd_cls_id=0;
			}
			System.err.println(prd_cls_id);
			List<Map<String, Object>> list = this.xgt_goods_prd_clsDao.list1(condition,prd_cls_id);
			System.err.println(list);
			return super.warpObject(new Xgt_goods_prd_clsWarpper(list));
		}
		else{
			if (null==prd_cls_id){
				prd_cls_id=0;
			}
			List<Map<String, Object>> list = this.xgt_goods_prd_clsDao.list(condition,cpnId,prd_cls_id);
			return super.warpObject(new Xgt_goods_prd_clsWarpper(list));
		}
	}

	/**
	 * 获取产品分类列表
	 */
	@RequestMapping(value = "/list3")
	@ResponseBody
	public Object list3(@RequestParam(required = false) String condition,@RequestParam(required = false) Integer prd_cls_id) {
		paramList = null;
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xgt_goods_prd_clsDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			if (null==prd_cls_id){
				prd_cls_id=0;
			}
			System.err.println(prd_cls_id);
			List<Map<String, Object>> list = this.xgt_goods_prd_clsDao.list1(condition,prd_cls_id);
			System.err.println(list);
			return super.warpObject(new Xgt_goods_prd_clsWarpper(list));
		}
		else{
			if (null==prd_cls_id){
				prd_cls_id=0;
			}
			List<Map<String, Object>> list = this.xgt_goods_prd_clsDao.list(condition,cpnId,prd_cls_id);
			return super.warpObject(new Xgt_goods_prd_clsWarpper(list));
		}
	}

	/**
	 * 获取全部产品分类
	 */
	public List<Map<String, Object>> clsList() {
		List<Map<String, Object>> clsList = xgt_goods_prd_clsDao.clsList();
		return clsList;
	}

	/**
	 * 获取公司的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree() {
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xgt_goods_prd_clsDao.queryCpnId(userId);
		if (ShiroKit.isAdmin()){
			List<ZTreeNode> tree = this.xgt_goods_prd_clsDao.tree1();
			tree.add(ZTreeNode.createParent());
			return tree;
		}else{
			List<ZTreeNode> tree = this.xgt_goods_prd_clsDao.tree(cpnId);
			tree.add(ZTreeNode.createParent());
			return tree;
		}
	}

	/**
	 * 新增产品分类
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xgt_goods_prd_cls xgt_goods_prd_cls) {
		Integer userId = ShiroKit.getUser().getId();
		String userName = ShiroKit.getUser().getName();
		Integer cpnId = xgt_goods_prd_clsDao.queryCpnId(userId);
		Integer cpnBranchId = xgt_goods_prd_clsDao.queryCpnBrandId(userId);
		xgt_goods_prd_cls.setCpn_id(cpnId);
		xgt_goods_prd_cls.setCpn_branch_id(cpnBranchId);
		xgt_goods_prd_cls.setOper_user(userName);
		xgt_goods_prd_cls.setSt_id(1);
		xgt_goods_prd_cls.setCre_dt(new Date());
		return this.xgt_goods_prd_clsMapper.insert(xgt_goods_prd_cls);
	}

	/**
	 * 删除产品分类
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xgt_goods_prd_clsId) {
		this.xgt_goods_prd_clsDao.updateClsById(xgt_goods_prd_clsId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改产品分类
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xgt_goods_prd_cls xgt_goods_prd_cls) {
		this.xgt_goods_prd_clsMapper.updateById(xgt_goods_prd_cls);
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出产品分类
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xgt_goods_prd_cls.xls";
		String tarPath = "src/main/resources/excel/xgt_goods_prd_cls.xls";
		String condition = null;
		Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);

		//下载
		String fileName = "xgt_goods_prd_cls"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_goods_prd_cls.xls")));
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