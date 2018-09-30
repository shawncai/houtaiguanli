package wy.addons.zcgl.xydcpn.controller;

import wy.addons.zcgl.xydcpn.dao.Xyd_cpnMapper;
import wy.core.base.controller.BaseController;
import wy.common.exception.BizExceptionEnum;
import wy.common.exception.BussinessException;
import wy.config.properties.XydProperties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.io.File;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import wy.core.log.LogObjectHolder;
import wy.addons.zcgl.xydcpn.model.Xyd_cpn;
import org.springframework.web.bind.annotation.PathVariable;

import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.addons.zcgl.cpncata.dao.Xyd_cpn_cataDao;
import wy.xydframe.sysArea.dao.Sys_areaDao;
import wy.xydframe.system.dao.DictDao;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
import wy.addons.zcgl.xydcpn.warpper.Xyd_cpnWarpper;

/**
 * 企业控制器
 *
 * @author wyframe
 * @Date 2017-09-08 17:08:38
 */
@Controller
@RequestMapping("/xyd_cpnReviewe")
public class Xyd_cpnRevieweController extends BaseController {
	private String PREFIX = "/addons/zcgl/xydcpn/";


	@Resource
	private XydProperties xydProperties;
	
	@Resource
	Xyd_cpn_branchDao xyd_cpn_branchDao;
	
	@Resource
	Xyd_cpn_deptDao xyd_cpn_deptDao;

	@Resource
	Xyd_cpnDao xyd_cpnDao;

	@Resource
	DictDao dictDao;

	@Resource
	Xyd_cpn_cataDao xyd_cpn_cataDao;

	@Resource
	Sys_areaDao sys_areaDao;

	@Resource
    Xyd_cpnMapper xyd_cpnMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到企业首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_cpnReviewe.html";
	}

	/**
	 * 跳转到详情企业
	 */
	@RequestMapping("/xyd_cpn_detail/{xyd_cpnId}")
	public String xyd_cpnDetail(@PathVariable Integer xyd_cpnId, Model model) {
		Xyd_cpn xyd_cpn = this.xyd_cpnDao.queryById(xyd_cpnId);
		
		// 获取企业分类名称
		String cpnCataNmByCpnId = xyd_cpnDao.selectCpnCataNmByCpnId(xyd_cpnId);
		// 获取办公地区名称
		Integer workAreaId = xyd_cpn.getWork_area_id();
		String workAreaName = sys_areaDao.selectByWorkAreaName(workAreaId);
		// 获取注册地区名称
		Integer codeAreaId = xyd_cpn.getCode_area_id();
		String codeArteaName = sys_areaDao.selectByCodeAreaName(codeAreaId);
		// 获取企业状态名字
		List<Map<String, Object>> cpnStsList = dictDao.selectCpnSts();
		Integer cpnStId = xyd_cpn.getCpn_st();
		for (Map cpnStMap : cpnStsList) {
			if (cpnStMap.get("num").equals(cpnStId)) {
				model.addAttribute("cpn_st", cpnStMap.get("name"));
			}
		}
		// 获取企业审批状态名字
		List<Map<String, Object>> cpSpStList = dictDao.selectCpnSpSts();
		Integer cpnSpStId = xyd_cpn.getCp_sp_st();
		for (Map cpnSpStMap : cpSpStList) {
			if (cpnSpStMap.get("num").equals(cpnSpStId)) {
				model.addAttribute("cp_sp_st", cpnSpStMap.get("name"));
			}
		}
		String fileSavePath = xydProperties.getFileUploadPath();
		String cardUrl1Name = xyd_cpnDao.selectCardUrl1Name(xyd_cpnId);
		// String newCardUrl1 = "/file/" + cardUrl1Name;
		// String newCardUrl1 = "file:///" + fileSavePath + cardUrl1Name;
		String newCardUrl1 = fileSavePath + cardUrl1Name;
		model.addAttribute("cpnCataNmByCpnId", cpnCataNmByCpnId);
		model.addAttribute("workAreaName", workAreaName);
		model.addAttribute("codeArteaName", codeArteaName);
		// model.addAttribute("newCardUrl1", newCardUrl1);
		model.addAttribute(xyd_cpn);
		LogObjectHolder.me().set(xyd_cpn);
		// return PREFIX + "xyd_cpn_detail.html";
//		return PREFIX + "cpn_detail.html";
		return PREFIX + "cpn_Reviewedetail.html";
	}
	
	/**
	 * 修改企业
	 */
	@RequestMapping(value = "/update/{xyd_cpnId}")
	@ResponseBody
	public Object update(@PathVariable Integer xyd_cpnId) {
		
		System.err.println(xyd_cpnId);
		
		this.xyd_cpnDao.updateCpnById(xyd_cpnId);
		
		String cpn_branch_nm = xyd_cpnDao.selectCpnName(xyd_cpnId);
		System.err.println("机构名称：" + cpn_branch_nm);
		
		Integer cpn_area_id = xyd_cpnDao.selectCpnWad(xyd_cpnId);
		System.err.println("机构地区：" + cpn_area_id);
		
		String cpn_area_desc = xyd_cpnDao.selectCpnWas(xyd_cpnId);
		System.err.println("机构地址：" + cpn_area_desc);
		
		Integer st_id = xyd_cpnDao.selectCpnSt(xyd_cpnId);
		System.err.println("机构状态：" + st_id);
		
//		Date cre_dt = xyd_cpnDao.selectCpnCrd(xyd_cpnId);
//		System.err.println("机构创建时间：" + cre_dt);
		
		Date cre_dt = new Date();
		System.err.println("机构创建时间：" + cre_dt);
		
		this.xyd_cpn_branchDao.insertCbh(xyd_cpnId,cpn_branch_nm,cpn_area_id,cpn_area_desc,cre_dt,st_id);
		
		Integer cpn_branch_id = xyd_cpn_branchDao.selectCpnBranchId(xyd_cpnId);
		System.err.println("新增加机构ID：" + cpn_branch_id);
		Integer par_cpn_dept_id=0;
		System.err.println("新增加上级部门ID：" + par_cpn_dept_id);
		this.xyd_cpn_deptDao.insertCdt(xyd_cpnId,cpn_branch_id,cpn_branch_nm,par_cpn_dept_id,cre_dt,st_id);
		
		paramList = null;
		return super.SUCCESS_TIP;
	}
	
	/**
	 * 修改企业
	 */
	@RequestMapping(value = "/notgo/{xyd_cpnId}")
	@ResponseBody
	public Object notgo(@PathVariable Integer xyd_cpnId, @RequestParam String approval_opinion) {
		
		System.err.println(xyd_cpnId);
		System.err.println(approval_opinion);
		
		this.xyd_cpnDao.checkNotGoCpn(xyd_cpnId, approval_opinion);
	
		paramList = null;
		return super.SUCCESS_TIP;
	}

	/**
	 * 获取企业列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String cpn_nm, @RequestParam(required = false) Integer cpn_st) {
		paramList = null;				
		List<Map<String, Object>> cpnStlist = this.xyd_cpnDao.cpnStlist(cpn_nm,cpn_st);
		
		System.err.println(cpnStlist.toString());
		
		return super.warpObject(new Xyd_cpnWarpper(cpnStlist));
	}
	
	/**
	 * 查询全部入驻企业类型
	 */
	public List<Map<String, Object>> cpnsCataList() {
		List<Map<String, Object>> cpnsCataList = xyd_cpn_cataDao.selectCpnCatas();
		return cpnsCataList;
	}

	/**
	 * 查询所有企业信息
	 */
	public List<Map<String, Object>> cpnList() {
		List<Map<String, Object>> cpnList = this.xyd_cpnDao.selectCpnList();
		return cpnList;
	}

	/**
	 * 上传图片(上传到项目的webapp/static/img)
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile picture) {
		String pictureName = UUID.randomUUID().toString() + ".jpg";
		try {
			String fileSavePath = xydProperties.getFileUploadPath();
			System.out.println(fileSavePath + ":" + pictureName);
			picture.transferTo(new File(fileSavePath + pictureName));
		} catch (Exception e) {
			throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
		}
		return pictureName;
	}
}
