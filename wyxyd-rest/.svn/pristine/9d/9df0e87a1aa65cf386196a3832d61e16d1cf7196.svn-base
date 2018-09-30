package wy.rest.addons.zcgl.cpn_store.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.base.controller.BaseController;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.rest.addons.zcgl.cpn_store.dao.Xyd_cpn_storeDao;
import wy.rest.addons.zcgl.cpn_store.dao.Xyd_cpn_storeMapper;
import wy.rest.addons.zcgl.cpn_store.model.Xyd_cpn_store;
import wy.rest.common.persistence.dao.DictDao;

import javax.annotation.Resource;
import java.util.Date;
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
	Xyd_cpn_deptDao xyd_cpn_deptDao;

	@Resource
	DictDao dictDao;



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
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(null);
		List<Map<String, Object>> cpnBranchList=null;
		cpnBranchList = xyd_cpn_storeDao.userCpnBranchList(cpnId);
		System.err.println(cpnBranchList);
		model.addAttribute("cpnStoreStList", null);
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
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(null);
		List<Map<String, Object>> cpnBranchList=null;
		cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(cpnId);
		Integer cpnBranchId = xyd_cpn_store.getCpn_branch_id();
		String cpnBranchNm = xyd_cpn_storeDao.selectCpnBranchNm(cpnBranchId);
		List<Map<String, Object>> cpnList=xyd_cpn_deptDao.selectCpns();
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnStoreStList", null);
		model.addAttribute("cpnBranchList", cpnBranchList);
		model.addAttribute("pCpnBranchNm", pCpnBranchNm);
		model.addAttribute(xyd_cpn_store);
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
		Integer cpnId = xyd_cpn_storeDao.queryCpnId(null);
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
		return PREFIX + "cpn_store_detail.html";

	}

	/**
	 * 获取企业仓库列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		List<Xyd_cpn_store> list = xyd_cpn_storeMapper.selectList(new EntityWrapper<Xyd_cpn_store>());
		return list;
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
	public Object add(@RequestBody Xyd_cpn_store xyd_cpn_store) {

		xyd_cpn_store.setCre_dt(new Date());
		xyd_cpn_store.setCpn_id(1);
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

}
