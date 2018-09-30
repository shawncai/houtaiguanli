package wy.addons.zcgl.cpn_store.controller;

import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.addons.zcgl.cpn_store.dao.Xyd_cpn_storeDao;
import wy.addons.zcgl.cpn_store.warpper.Xyd_cpn_storeWarpper;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
import wy.core.base.controller.BaseController;
import wy.core.log.LogObjectHolder;
import wy.core.node.ZTreeNode;
import wy.core.shiro.ShiroKit;
import wy.core.util.DateUtil;
import wy.addons.zcgl.cpn_store.dao.Xyd_cpn_storeMapper;
import wy.addons.zcgl.cpn_store.model.Xyd_cpn_store;
import wy.xydframe.system.dao.DictDao;
import wy.xydframe.system.dao.UserMgrDao;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业仓库控制器
 *
 * @author wyframe
 * @Date 2017-09-18 11:41:05
 */
@Controller
@RequestMapping("/xyd_cpn_store")
public class Xyd_cpn_storeController extends BaseController {
	private String PREFIX = "/addons/zcgl/cpn_store/";
	@Resource
	Xyd_cpn_storeDao xyd_cpn_storeDao;


	@Resource
	DictDao dictDao;


	@Resource
	Xyd_cpn_deptDao xyd_cpn_deptDao;

	@Resource
	Xyd_cpn_storeMapper xyd_cpn_storeMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到企业仓库首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_cpn_store.html";
	}

	/**
	 * 跳转到添加企业仓库
	 */
	@RequestMapping("/xyd_cpn_store_add")
	public String xyd_cpn_storeAdd(Model model) {
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(userId);
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		List<Map<String, Object>> cpnBranchList=null;
		cpnBranchList = xyd_cpn_storeDao.userCpnBranchList(cpnId);
		System.err.println(cpnBranchList);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		return PREFIX + "cpn_store_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_cpn_store_add_param")
	public String xyd_cpn_store_add_param() {
		return PREFIX + "xyd_cpn_store_add_param.html";
	}

	/**
	 * 跳转到修改企业仓库
	 */
	@RequestMapping("/xyd_cpn_store_update/{xyd_cpn_storeId}")
	public String xyd_cpn_storeUpdate(@PathVariable Integer xyd_cpn_storeId, Model model) {
		Xyd_cpn_store xyd_cpn_store = this.xyd_cpn_storeDao.queryById(xyd_cpn_storeId);
		String pCpnBranchNm = xyd_cpn_storeDao.selectPCpnStoreNm(xyd_cpn_storeId);
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(userId);
		List<Map<String, Object>> cpnBranchList=null;
		cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(cpnId);
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		Integer cpnBranchId = xyd_cpn_store.getCpn_branch_id();
		String cpnBranchNm = xyd_cpn_storeDao.selectCpnBranchNm(cpnBranchId);
		List<Map<String, Object>> cpnList=xyd_cpn_deptDao.selectCpns();
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		model.addAttribute("pCpnBranchNm", pCpnBranchNm);
		model.addAttribute(xyd_cpn_store);
		LogObjectHolder.me().set(xyd_cpn_store);
		return PREFIX + "cpn_store_edit.html";
	}

	/**
	 * 跳转到详情企业仓库
	 */
	@RequestMapping("/xyd_cpn_store_detail/{xyd_cpn_storeId}")
	public String xyd_cpn_storeDetail(@PathVariable Integer xyd_cpn_storeId, Model model) {
		Xyd_cpn_store xyd_cpn_store = this.xyd_cpn_storeDao.queryById(xyd_cpn_storeId);
		// 获取上级仓库名字
		String pCpnStoreNm = xyd_cpn_storeDao.selectPCpnStoreNm(xyd_cpn_storeId);
		// 获取状态名字
		List<Map<String, Object>> cpnStoreStList = dictDao.selectCpnStoreSts();
		Integer cpnStoreStId = xyd_cpn_store.getSt_id();
		for (Map cpnStoreStMap : cpnStoreStList) {
			if (cpnStoreStMap.get("num").equals(cpnStoreStId)) {
				model.addAttribute("st_id", cpnStoreStMap.get("name"));
			}
		}
		List<Map<String, Object>> cpnList=xyd_cpn_deptDao.selectCpns();
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(userId);
		List<Map<String, Object>> cpnBranchList=null;
		cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(cpnId);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		String pCpnBranchNm = xyd_cpn_storeDao.selectPCpnStoreNm(xyd_cpn_storeId);
		model.addAttribute("pCpnBranchNm", pCpnBranchNm);
		// 获取企业名字
		String cpnNm = xyd_cpn_storeDao.selectCpnNm(cpnId);
		model.addAttribute("cpnNm", cpnNm);
		model.addAttribute("pCpnStoreNm", pCpnStoreNm);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute(xyd_cpn_store);
		LogObjectHolder.me().set(xyd_cpn_store);
		return PREFIX + "cpn_store_detail.html";

	}

	/**
	 * 获取企业仓库列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(userId);
		List<Map<String, Object>> list = this.xyd_cpn_storeDao.list(cpnId,condition);
		return super.warpObject(new Xyd_cpn_storeWarpper(list));
	}

	/**
	 * 获取所有企业仓库
	 */
	@RequestMapping(value = "/cpnStoreList")
	@ResponseBody
	public List<Map<String, Object>> cpnStoreList() {
		List<Map<String, Object>> cpnStoreList = this.xyd_cpn_storeDao.selectCpnStores();
		return cpnStoreList;
	}
	/**
	 * 模糊查询仓库列表
	 */
	@RequestMapping(value = "/findByNameOrNo")
	@ResponseBody
	public Object findByNameOrNo(@RequestParam String cpn_store_nm){
		List<Map<String,Object>> list =  this.xyd_cpn_storeDao.findByNameOrNo(cpn_store_nm);
		return list;
	}
	/**
	 * 获取仓库的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree() {
		List<ZTreeNode> tree = this.xyd_cpn_storeDao.tree();
		tree.add(ZTreeNode.createParent());
		return tree;
	}

	/**
	 * 新增企业仓库
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xyd_cpn_store xyd_cpn_store) {

		xyd_cpn_store.setCre_dt(new Date());
		int userId  = ShiroKit.getUser().getId();
		int cpnId =xyd_cpn_storeDao.queryCpnId(userId);
		int branchId = xyd_cpn_storeDao.queryCpnBrandId(userId);
		xyd_cpn_store.setCpn_branch_id(branchId);
		xyd_cpn_store.setCpn_id(cpnId);
		xyd_cpn_store.setSt_id(1);
		return this.xyd_cpn_storeMapper.insert(xyd_cpn_store);
	}

	/**
	 * 删除企业仓库
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_cpn_storeId) {
		this.xyd_cpn_storeMapper.deleteById(xyd_cpn_storeId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改企业仓库
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_cpn_store xyd_cpn_store) {
		System.err.println(xyd_cpn_store);
		this.xyd_cpn_storeMapper.updateById(xyd_cpn_store);
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出企业仓库
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res) throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xyd_cpn_store.xls";
		String tarPath = "src/main/resources/excel/xyd_cpn_store.xls";
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(userId);
		List<Map<String, Object>> list = this.xyd_cpn_storeDao.list(cpnId,null);
		Map<String, List<Map<String, Object>>> beanParams = new HashMap<String, List<Map<String, Object>>>();
		beanParams.put("list", list);
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);
		// 下载
		String fileName = "xyd_cpn_store" + DateUtil.getAllTime() + ".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_cpn_store.xls")));
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
