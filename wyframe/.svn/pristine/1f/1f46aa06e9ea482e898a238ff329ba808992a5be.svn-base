package wy.addons.zcgl.xydcpn.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import wy.addons.zcgl.cpncata.dao.Xyd_cpn_cataDao;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnMapper;
import wy.addons.zcgl.xydcpn.model.Xyd_cpn;
import wy.common.exception.BizExceptionEnum;
import wy.common.exception.BussinessException;
import wy.config.properties.XydProperties;
import wy.core.base.controller.BaseController;
import wy.core.log.LogObjectHolder;
import wy.core.shiro.ShiroKit;
import wy.core.util.DateUtil;
import wy.xydframe.sysArea.dao.Sys_areaDao;
import wy.xydframe.sysArea.model.Sys_area;
import wy.xydframe.system.dao.DictDao;
import wy.xydframe.system.dao.UserMgrDao;
import wy.addons.zcgl.xydcpn.warpper.Xyd_cpnWarpper;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

/**
 * 企业控制器
 *
 * @author wyframe
 * @Date 2017-09-08 17:08:38
 */
@Controller
@RequestMapping("/xyd_cpn")
public class Xyd_cpnController extends BaseController {
	private String PREFIX = "/addons/zcgl/xydcpn/";


	@Resource
	private XydProperties xydProperties;

	@Resource
    Xyd_cpnDao xyd_cpnDao;
	
	@Resource
    private UserMgrDao managerDao;

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
		return PREFIX + "xyd_cpn.html";
	}

	/**
	 * 跳转到添加企业
	 */
	@RequestMapping("/xyd_cpn_add")
	public String xyd_cpnAdd(Model model) {
		List<Map<String, Object>> cpnStList = dictDao.selectCpnSts();
		List<Map<String, Object>> cpSpStList = dictDao.selectCpnSpSts();
		model.addAttribute("cpnStList", cpnStList);
		model.addAttribute("cpSpStList", cpSpStList);
		// return PREFIX + "xyd_cpn_add.html";
		return PREFIX + "cpn_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_cpn_add_param")
	public String xyd_cpn_add_param() {
		return PREFIX + "xyd_cpn_add_param.html";
	}

	/**
	 * 跳转到修改企业
	 */
	@RequestMapping("/xyd_cpn_update/{xyd_cpnId}")
	public String xyd_cpnUpdate(@PathVariable Integer xyd_cpnId, Model model) {
		Xyd_cpn xyd_cpn = this.xyd_cpnDao.queryById(xyd_cpnId);
		String cpnCataNmByCpnId = xyd_cpnDao.selectCpnCataNmByCpnId(xyd_cpnId);
		Integer workAreaId = xyd_cpn.getWork_area_id();
		String workAreaName = sys_areaDao.selectByWorkAreaName(workAreaId);
		Integer codeAreaId = xyd_cpn.getCode_area_id();
		String codeArteaName = sys_areaDao.selectByCodeAreaName(codeAreaId);
		// 获取企业状态名字
		List<Map<String, Object>> cpnStsList = dictDao.selectCpnSts();
		// Integer cpnStId = xyd_cpn.getCpn_st();
		// for(Map cpnStMap : cpnStsList) {
		// if(cpnStMap.get("num").equals(cpnStId)) {
		// model.addAttribute("cpn_st", cpnStMap.get("name"));
		// }
		// }
		// 获取企业审批状态名字
		List<Map<String, Object>> cpSpStList = dictDao.selectCpnSpSts();
		// Integer cpnSpStId = xyd_cpn.getCp_sp_st();
		// for(Map cpnSpStMap : cpSpStList) {
		// if(cpnSpStMap.get("num").equals(cpnSpStId)) {
		// model.addAttribute("cp_sp_st", cpnSpStMap.get("name"));
		// }
		// }
		model.addAttribute("cpnStsList", cpnStsList);
		model.addAttribute("cpSpStList", cpSpStList);
		model.addAttribute("cpnCataNmByCpnId", cpnCataNmByCpnId);
		model.addAttribute("workAreaName", workAreaName);
		model.addAttribute("codeArteaName", codeArteaName);
		model.addAttribute(xyd_cpn);
		LogObjectHolder.me().set(xyd_cpn);
		// return PREFIX + "xyd_cpn_edit.html";
		return PREFIX + "cpn_edit.html";
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
		return PREFIX + "cpn_detail.html";
	}

	/**
	 * 获取企业列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String cpn_nm,
			@RequestParam(required = false) Integer cpn_cata_id) {
		paramList = null;
		// System.err.println("获取的信息是:" + cpn_cata_id);
		// Integer cpnCataId = xyd_cpn_cataDao.selectCpnCataId(cpn_cata_id);
		// System.err.println("获得的ID是:" + cpnCataId)

		List<Map<String, Object>> list = this.xyd_cpnDao.list(cpn_nm, cpn_cata_id);

		// List<Map<String, Object>> list = this.xyd_cpnDao.list(cpn_nm);
		return super.warpObject(new Xyd_cpnWarpper(list));
	}
	
	/**
	 * 获取已通过审核并正常的企业列表
	 */
	@RequestMapping(value = "/spList")
	@ResponseBody
	public Object spList() {
		int userId=	ShiroKit.getUser().getId();
		int cpnId= managerDao.queryCpnId(userId);
		if(ShiroKit.isAdmin()){
			List<Map<String, Object>> list = this.xyd_cpnDao.spList();

			return super.warpObject(new Xyd_cpnWarpper(list));
		}
		else {
			List<Map<String, Object>> list = this.xyd_cpnDao.nowList(cpnId);

			return super.warpObject(new Xyd_cpnWarpper(list));
		}
	}
	
	/**
	 * 当前用户的企业
	 */
	@RequestMapping(value = "/nowList")
	@ResponseBody
	public Object nowList() {
		Integer userId = ShiroKit.getUser().getId();   
	    Integer cpnId = managerDao.queryCpnId(userId);
		List<Map<String, Object>> list = this.xyd_cpnDao.nowList(cpnId);

		return super.warpObject(new Xyd_cpnWarpper(list));
	}

	
	/**
	 * 搜索企业
	 */
	@RequestMapping(value = "/checkCpn/{cpnNm}")
	@ResponseBody
	public Object checkCpn(@PathVariable String cpnNm) {

		List<Map<String, Object>> cpnList = this.xyd_cpnDao.selectByCpnNm(cpnNm);
		return cpnList;
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
	 * 新增企业
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xyd_cpn xyd_cpn) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		xyd_cpn.setCre_dt(new Date());
		xyd_cpn.setCpn_st(-2);
		xyd_cpn.setCp_sp_st(2);
		Integer workAreaId = xyd_cpn.getWork_area_id();
		Sys_area workSysArea = sys_areaDao.selectByWorkAreaId(workAreaId);
		String workprov_nm = workSysArea.getProv_nm();
		String workcity_nm = workSysArea.getCity_nm();
		String workregion_nm = workSysArea.getRegion_nm();
		String workstreet_nm = workSysArea.getStreet_nm();
		String workAddress = xyd_cpn.getWork_address();
		if (("").equals(workstreet_nm) || workstreet_nm == null) {
			String newWorkAddress = workprov_nm + workcity_nm + workregion_nm + workAddress;
			xyd_cpn.setWork_address(newWorkAddress);
		} else {
			String newWorkAddress = workprov_nm + workcity_nm + workregion_nm + workstreet_nm + workAddress;
			xyd_cpn.setWork_address(newWorkAddress);
		}
		Integer codeAreaId = xyd_cpn.getCode_area_id();
		Sys_area codeSysArea = sys_areaDao.selectByCodeAreaId(codeAreaId);
		String codeprov_nm = codeSysArea.getProv_nm();
		String codecity_nm = codeSysArea.getCity_nm();
		String coderegion_nm = codeSysArea.getRegion_nm();
		String codestreet_nm = codeSysArea.getStreet_nm();
		String codeAddress = xyd_cpn.getCode_address();
		if (("").equals(codestreet_nm) || codestreet_nm == null) {
			String newCodeAddress = codeprov_nm + codecity_nm + coderegion_nm + codeAddress;
			xyd_cpn.setCode_address(newCodeAddress);
		} else {
			String newCodeAddress = codeprov_nm + codecity_nm + coderegion_nm + codestreet_nm + codeAddress;
			xyd_cpn.setCode_address(newCodeAddress);
		}
		return this.xyd_cpnMapper.insert(xyd_cpn);
	}

	/**
	 * 删除企业
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_cpnId) {
		this.xyd_cpnMapper.deleteById(xyd_cpnId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改企业
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_cpn xyd_cpn) {
		Integer workAreaId = xyd_cpn.getWork_area_id();
		Sys_area workSysArea = sys_areaDao.selectByWorkAreaId(workAreaId);
		String workprov_nm = workSysArea.getProv_nm();
		String workcity_nm = workSysArea.getCity_nm();
		String workregion_nm = workSysArea.getRegion_nm();
		String workstreet_nm = workSysArea.getStreet_nm();
		String workAddress = xyd_cpn.getWork_address();
		if (("").equals(workstreet_nm) || workstreet_nm == null) {
			String newWorkAddress = workprov_nm + workcity_nm + workregion_nm + workAddress;
			xyd_cpn.setWork_address(newWorkAddress);
		} else {
			String newWorkAddress = workprov_nm + workcity_nm + workregion_nm + workstreet_nm + workAddress;
			xyd_cpn.setWork_address(newWorkAddress);
		}
		Integer codeAreaId = xyd_cpn.getCode_area_id();
		Sys_area codeSysArea = sys_areaDao.selectByCodeAreaId(codeAreaId);
		String codeprov_nm = codeSysArea.getProv_nm();
		String codecity_nm = codeSysArea.getCity_nm();
		String coderegion_nm = codeSysArea.getRegion_nm();
		String codestreet_nm = codeSysArea.getStreet_nm();
		String codeAddress = xyd_cpn.getCode_address();
		if (("").equals(codestreet_nm) || codestreet_nm == null) {
			String newCodeAddress = codeprov_nm + codecity_nm + coderegion_nm + codeAddress;
			xyd_cpn.setCode_address(newCodeAddress);
		} else {
			String newCodeAddress = codeprov_nm + codecity_nm + coderegion_nm + codestreet_nm + codeAddress;
			xyd_cpn.setCode_address(newCodeAddress);
		}
		this.xyd_cpnMapper.updateById(xyd_cpn);
		paramList = null;
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出企业
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res) throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xyd_cpn.xls";
		String tarPath = "src/main/resources/excel/xyd_cpn.xls";
		String condition = null;
		// List<Map<String, Object>> list = this.xyd_cpnDao.list(condition);
		Map<String, List<Map<String, Object>>> beanParams = new HashMap<String, List<Map<String, Object>>>();
		// beanParams.put("list", list);
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);
		// 下载
		String fileName = "xyd_cpn" + DateUtil.getAllTime() + ".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_cpn.xls")));
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
