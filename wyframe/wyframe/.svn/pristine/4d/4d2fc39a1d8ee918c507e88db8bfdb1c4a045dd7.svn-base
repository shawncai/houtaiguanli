package wy.addons.zcgl.cpn_branch.controller;

import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchMapper;
import wy.addons.zcgl.cpn_branch.model.Xyd_cpn_branch;
import wy.addons.zcgl.cpn_branch.warpper.Xyd_cpn_branchWarpper;
import wy.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.addons.zcgl.cpn_room.warpper.Xgt_cpn_roomWarpper;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
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
import wy.xydframe.sysArea.dao.Sys_areaDao;
import wy.xydframe.sysArea.model.Sys_area;
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
 * 企业分支机构控制器
 *
 * @author wyframe
 * @Date 2017-09-18 11:22:46
 */
@Controller
@RequestMapping("/xyd_cpn_branch")
public class Xyd_cpn_branchController extends BaseController {
	private String PREFIX = "/addons/zcgl/cpn_branch/";

	@Resource
	Xyd_cpn_branchDao xyd_cpn_branchDao;

	@Resource
	DictDao dictDao;

	@Resource
	Xyd_cpn_branchMapper xyd_cpn_branchMapper;

	@Resource
	Xyd_cpn_deptDao xyd_cpn_deptDao;
	@Resource
	Sys_areaDao sys_areaDao;
	/**
	 * 跳转到企业分支机构首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_cpn_branch.html";
	}

	/**
	 * 跳转到添加企业分支机构
	 */
	@RequestMapping("/xyd_cpn_branch_add")
	public String xyd_cpn_branchAdd(Model model) {
		Integer userId = ShiroKit.getUser().getId();
		int cpnId = xyd_cpn_branchDao.queryCpnBrandId(userId);
		List<Map<String, Object>> cpnBranchStList = this.xyd_cpn_branchDao.userCpnBranchList(cpnId);
		List<Map<String, Object>> cpnList = null;
			cpnList=xyd_cpn_branchDao.userCpnList(cpnId);
		model.addAttribute("cpnList",cpnList);
		System.err.println(cpnList);
		System.err.println(cpnBranchStList);
		model.addAttribute("cpnBranchStList", cpnBranchStList);
		return PREFIX + "cpn_branch_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_cpn_branch_add_param")
	public String xyd_cpn_branch_add_param() {
		return PREFIX + "xyd_cpn_branch_add_param.html";
	}

	/**
	 * 跳转到修改企业分支机构
	 */
	@RequestMapping("/xyd_cpn_branch_update/{xyd_cpn_branchId}")
	public String xyd_cpn_branchUpdate(@PathVariable Integer xyd_cpn_branchId, Model model) {
		Xyd_cpn_branch xyd_cpn_branch = this.xyd_cpn_branchDao.queryById(xyd_cpn_branchId);
		Integer areaId = xyd_cpn_branch.getCpn_area_id();
		String areaNm = xyd_cpn_branchDao.selectByBranchAreaName(areaId);
		Integer cpnId = xyd_cpn_branch.getCpn_id();
		String cpnNm = xyd_cpn_branchDao.selectCpnNm(cpnId);
		List<Map<String, Object>> cpnBranchStList = this.xyd_cpn_branchDao.userCpnBranchList(cpnId);
		List<Map<String, Object>> cpnList = null;
			cpnList=xyd_cpn_branchDao.userCpnList(cpnId);
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnBranchStList", cpnBranchStList);
		model.addAttribute("cpnNm", cpnNm);
		model.addAttribute("areaNm", areaNm);
		model.addAttribute(xyd_cpn_branch);
		LogObjectHolder.me().set(xyd_cpn_branch);
		return PREFIX + "cpn_branch_edit.html";
	}

	/**
	 * 跳转到详情企业分支机构
	 */
	@RequestMapping("/xyd_cpn_branch_detail/{xyd_cpn_branchId}")
	public String xyd_cpn_branchDetail(@PathVariable Integer xyd_cpn_branchId, Model model) {
		Xyd_cpn_branch xyd_cpn_branch = this.xyd_cpn_branchDao.queryById(xyd_cpn_branchId);

		//获取地区名称
		Integer areaId = xyd_cpn_branch.getCpn_area_id();
		String areaNm = xyd_cpn_branchDao.selectByBranchAreaName(areaId);
		//获取状态名字
		Integer cpnId = xyd_cpn_branchDao.selectCpnId(xyd_cpn_branchId);
		List<Map<String, Object>> cpnBranchStList = this.xyd_cpn_branchDao.userCpnBranchList(cpnId);
		Integer cpnBranchStId = xyd_cpn_branch.getSt_id();
		List<Map<String, Object>> cpnList = null;
		List<Map<String, Object>> cpnStoreStList = this.dictDao.cpnStoreStList();
		model.addAttribute("cpnStoreStList", cpnStoreStList);
		//获取企业信息名字
		String cpnNm = xyd_cpn_branchDao.selectCpnNm(cpnId);
			cpnList=xyd_cpn_branchDao.userCpnList(cpnId);
		model.addAttribute("cpnList",cpnList);
		model.addAttribute("cpnBranchStList", cpnBranchStList);
		model.addAttribute("areaNm", areaNm);
		model.addAttribute("cpnNm", cpnNm);
		model.addAttribute(xyd_cpn_branch);
		LogObjectHolder.me().set(xyd_cpn_branch);
		return PREFIX + "cpn_branch_detail.html";
	}

	/**
	 * 获取企业分支机构列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		int userId=	ShiroKit.getUser().getId();
		int cpnId= xyd_cpn_branchDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			List<Map<String, Object>> list = this.xyd_cpn_branchDao.list(cpnId);
			return super.warpObject(new Xyd_cpn_branchWarpper(list));
		}else{
			List<Map<String, Object>> list = this.xyd_cpn_branchDao.nowCpnBranchList(cpnId);
			return super.warpObject(new Xyd_cpn_branchWarpper(list));
		}
	}

	/**
	 * 获取企业分支机构列表
	 */
	@RequestMapping(value = "/list2")
	@ResponseBody
	public Object list2(String condition) {
		int userId=	ShiroKit.getUser().getId();
		int cpnId= xyd_cpn_branchDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			List<Map<String, Object>> list = this.xyd_cpn_branchDao.list2(cpnId,condition);
			return super.warpObject(new  Xyd_cpn_branchWarpper(list));
		}else{
			List<Map<String, Object>> list = this.xyd_cpn_branchDao.nowCpnBranchList(cpnId);
			return super.warpObject(new  Xyd_cpn_branchWarpper(list));
		}
	}
	/**
	 * 获取全部企业分支机构
	 */
	@RequestMapping(value = "/cpnBranchList")
	@ResponseBody
	public Object cpnBranchList() {
		List<Map<String, Object>> cpnBranchList = this.xyd_cpn_branchDao.selectCpnBranch();
		return cpnBranchList;
	}

	/**
	 * 获取当前企业的分支机构
	 */
	@RequestMapping(value = "/nowCpnBranchList/{cpnId}")
	@ResponseBody
	public Object nowCpnBranchList(@PathVariable Integer cpnId) {
		List<Map<String, Object>> cpnBranchList = this.xyd_cpn_branchDao.nowCpnBranchList(cpnId);
		return cpnBranchList;
	}

	/**
	 * 获取全部企业分支机构
	 */
	public List<Map<String, Object>> cpnBranchs() {
		List<Map<String, Object>> cpnBranchs = this.xyd_cpn_branchDao.selectCpnBranch();
		return cpnBranchs;
	}

	/**
	 * 获取分支机构的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object tree() {
		List<Map<String, Object>> tree = this.xyd_cpn_branchDao.tree();
		return tree;
	}

	/**
	 * 新增企业分支机构
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xyd_cpn_branch xyd_cpn_branch) {
		xyd_cpn_branch.setCre_dt(new Date());
		xyd_cpn_branch.setSt_id(1);
		Integer areaId = xyd_cpn_branch.getCpn_area_id();
		Sys_area areas = sys_areaDao.selectByAreaId(areaId);
		String prov_nm = areas.getProv_nm();
		String city_nm = areas.getCity_nm();
		String region_nm = areas.getRegion_nm();
		String street_nm = areas.getStreet_nm();
		String areaDesc = xyd_cpn_branch.getCpn_area_desc();
		if(("").equals(street_nm) || street_nm==null ) {
			String newAreaDesc = prov_nm + city_nm + region_nm + areaDesc;
			xyd_cpn_branch.setCpn_area_desc(newAreaDesc);
		}else{
			String newAreaDesc = prov_nm + city_nm + region_nm + street_nm + areaDesc;
			xyd_cpn_branch.setCpn_area_desc(newAreaDesc);
		}
		this.xyd_cpn_branchMapper.insert(xyd_cpn_branch);
		System.err.println(xyd_cpn_branch);
		Integer xyd_cpnId=xyd_cpn_branch.getCpn_id();
		Integer cpn_branch_id=xyd_cpn_branch.getCpn_branch_id();
		String cpn_branch_nm=xyd_cpn_branch.getCpn_branch_nm();
		List<Integer>list=xyd_cpn_branchDao.queryCpndeptId(xyd_cpnId);
		Integer par_cpn_dept_id= (Integer) list.get(0);
		Date cre_dt = xyd_cpn_branch.getCre_dt();
		Integer st_id=xyd_cpn_branch.getSt_id();
		this.xyd_cpn_deptDao.insertCdt(xyd_cpnId,cpn_branch_id,cpn_branch_nm,par_cpn_dept_id,cre_dt,st_id);
		return SUCCESS_TIP;
	}

	/**
	 * 删除企业分支机构
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_cpn_branchId) {
		this.xyd_cpn_branchMapper.deleteById(xyd_cpn_branchId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改企业分支机构
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_cpn_branch xyd_cpn_branch) {
		this.xyd_cpn_branchMapper.updateById(xyd_cpn_branch);
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出企业分支机构
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xyd_cpn_branch.xls";
		String tarPath = "src/main/resources/excel/xyd_cpn_branch.xls";
		Integer cpn_id = ShiroKit.getUser().getCpn_id();
		List<Map<String, Object>> list = this.xyd_cpn_branchDao.list(cpn_id);
		Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
		beanParams.put("list", list);
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);
		//下载
		String fileName = "xyd_cpn_branch"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_cpn_branch.xls")));
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