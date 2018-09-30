package wy.rest.addons.zcgl.cpn_dept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.base.controller.BaseController;
import wy.rest.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.rest.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptMapper;
import wy.rest.addons.zcgl.cpn_dept.model.Xyd_cpn_dept;
import wy.rest.addons.zcgl.cpn_dept.warpper.Xyd_cpn_deptWarpper;
import wy.rest.common.persistence.dao.DictDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 企业组织管理控制器
 *
 * @author wyframe
 * @Date 2017-09-18 11:38:46
 */
@Controller
@RequestMapping("/xyd_cpn_dept")
public class Xyd_cpn_deptController extends BaseController {
	private String PREFIX = "/addons/zcgl/cpn_dept/";

	@Resource
	Xyd_cpn_deptDao xyd_cpn_deptDao;

	@Resource
	DictDao dictDao;

	@Resource
	Xyd_cpn_deptMapper xyd_cpn_deptMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到企业组织管理首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_cpn_dept.html";
	}

	/**
	 * 跳转到添加企业组织管理
	 */
	@RequestMapping("/xyd_cpn_dept_add/{deptId}")
	public String xyd_cpn_deptAdd(@PathVariable("deptId") Integer deptId,Model model) {
		Integer branchId = xyd_cpn_deptDao.queryCpnBrandId(1);
		Integer cpnId = xyd_cpn_deptDao.queryCpnId(1);
		List<Map<String, Object>> cpnList = null;
		List<Map<String, Object>> cpnBranchList=null;
			cpnList=xyd_cpn_deptDao.userCpnList(null);
			cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(null);
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		String deptNm=xyd_cpn_deptDao.selectDeptNm(deptId);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		model.addAttribute("deptId", deptId);
		model.addAttribute("deptNm", deptNm);
		return PREFIX + "cpn_dept_add.html";
	}

	/**
	 * 查询公司
	 */
	@RequestMapping(value = "/cpnList")
	@ResponseBody
	public Object cpnList() {
		Integer cpnId = xyd_cpn_deptDao.queryCpnId(1);
		List<Map<String, Object>> list = this.xyd_cpn_deptDao.nowList(cpnId);
		return list;
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_cpn_dept_add_param")
	public String xyd_cpn_dept_add_param() {
		return PREFIX + "xyd_cpn_dept_add_param.html";
	}

	/**
	 * 跳转到修改企业组织管理
	 */
	@RequestMapping("/xyd_cpn_dept_update/{xyd_cpn_deptId}")
	public String xyd_cpn_deptUpdate(@PathVariable Integer xyd_cpn_deptId, Model model) {
		Xyd_cpn_dept xyd_cpn_dept = this.xyd_cpn_deptDao.queryById(xyd_cpn_deptId);
		String pCpnDeptNm = xyd_cpn_deptDao.selectPCpnDeptNm(xyd_cpn_deptId);
		List<Map<String, Object>> cpnList=xyd_cpn_deptDao.selectCpns();
		List<Map<String, Object>> cpnBranchList = xyd_cpn_deptDao.selectCpnBranchs();
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		Integer Parcpndeptid=xyd_cpn_dept.getPar_cpn_dept_id();
		String pdeptNm=xyd_cpn_deptDao.queryDeptNm(Parcpndeptid);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("pdeptNm",pdeptNm);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		model.addAttribute("pCpnDeptNm", pCpnDeptNm);
		model.addAttribute(xyd_cpn_dept);
		return PREFIX + "cpn_dept_edit.html";
	}

	/**
	 * 跳转到详情企业组织管理
	 */
	@RequestMapping("/xyd_cpn_dept_detail/{xyd_cpn_deptId}")
	public String xyd_cpn_deptDetail(@PathVariable Integer xyd_cpn_deptId, Model model) {
		Xyd_cpn_dept xyd_cpn_dept = this.xyd_cpn_deptDao.queryById(xyd_cpn_deptId);
		//获取上级部门名字
		String pCpnDeptNm = xyd_cpn_deptDao.selectPCpnDeptNm(xyd_cpn_deptId);
		//获取状态名字
		List<Map<String, Object>> cpnDeptStList = dictDao.selectCpnDeptSts();
		Integer cpnDeptStId = xyd_cpn_dept.getSt_id();
		for(Map cpnDeptStMap : cpnDeptStList) {
			if(cpnDeptStMap.get("num").equals(cpnDeptStId)) {
				model.addAttribute("st_id", cpnDeptStMap.get("name"));
			}
		}
		List<Map<String, Object>> cpnList=xyd_cpn_deptDao.selectCpns();
		List<Map<String, Object>> cpnBranchList = xyd_cpn_deptDao.selectCpnBranchs();
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		Integer Parcpndeptid=xyd_cpn_dept.getPar_cpn_dept_id();
		String pdeptNm=xyd_cpn_deptDao.queryDeptNm(Parcpndeptid);
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnBranchList", cpnBranchList);
		model.addAttribute("pCpnDeptNm", pCpnDeptNm);
		model.addAttribute("pdeptNm",pdeptNm);
		model.addAttribute(xyd_cpn_dept);
		return PREFIX + "cpn_dept_detail.html";
	}

	/**
	 * 获取企业组织管理列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list() {
			List<Map<String, Object>> list=this.xyd_cpn_deptDao.list();
			return list;
	}
	/**
	 * 获取企业组织管理列表
	 */
	@RequestMapping(value = "/nowBranchDeptList/{cpnBranchId}")
	@ResponseBody
	public Object nowBranchDeptList(@PathVariable Integer cpnBranchId) {
		List<Map<String, Object>> list = this.xyd_cpn_deptDao.nowBranchDeptList(cpnBranchId);
		return super.warpObject(new Xyd_cpn_deptWarpper(list));
	}

	/**
	 * 获取当前分支机构的组织列表
	 */
	@RequestMapping(value = "deptList")
	@ResponseBody
	public Object deptList(){
		List<Map<String, Object>> list = this.xyd_cpn_deptDao.nowBranchDeptList(1);
		return super.warpObject(new Xyd_cpn_deptWarpper(list));
	}



	/**
	 * 获取所有企业组织
	 */
	public List<Map<String, Object>> cpnDeptList(@RequestParam(required = false) Integer cpn_dept_id,@RequestParam(required = false) String cpn_dept_nm) {
		List<Map<String, Object>> cpnDeptList = this.xyd_cpn_deptDao.selectCpnDepts(cpn_dept_id,cpn_dept_nm);
		return cpnDeptList;
	}

	/**
	 * 新增企业组织管理
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(@RequestBody Xyd_cpn_dept xyd_cpn_dept) {
		xyd_cpn_dept.setCre_dt(new Date());
		xyd_cpn_dept.setSt_id(1);
		return this.xyd_cpn_deptMapper.insert(xyd_cpn_dept);
	}

	/**
	 * 删除企业组织管理
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_cpn_deptId) {
		this.xyd_cpn_deptMapper.deleteById(xyd_cpn_deptId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改企业组织管理
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_cpn_dept xyd_cpn_dept) {
		this.xyd_cpn_deptMapper.updateById(xyd_cpn_dept);
		paramList=null;
		return super.SUCCESS_TIP;
	}

}