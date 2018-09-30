package wy.addons.zcgl.cpn_dept.controller;

import wy.core.base.controller.BaseController;
import wy.core.log.LogObjectHolder;
import wy.core.node.ZTreeNode;
import wy.core.shiro.ShiroKit;
import wy.core.util.DateUtil;
import wy.addons.zcgl.cpn_branch.dao.Xyd_cpn_branchDao;
import wy.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptDao;
import wy.addons.zcgl.cpn_dept.dao.Xyd_cpn_deptMapper;
import wy.addons.zcgl.cpn_dept.model.Xyd_cpn_dept;
import wy.addons.zcgl.cpn_dept.warpper.Xyd_cpn_deptWarpper;
import wy.xydframe.system.dao.DictDao;
import wy.xydframe.system.dao.UserMgrDao;
import wy.addons.zcgl.xydcpn.dao.Xyd_cpnDao;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
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
		Integer userId = ShiroKit.getUser().getId();
		Integer branchId = xyd_cpn_deptDao.queryCpnBrandId(userId);
		Integer cpnId = xyd_cpn_deptDao.queryCpnId(userId);
		List<Map<String, Object>> cpnList = null;
		List<Map<String, Object>> cpnBranchList=null;
		if (ShiroKit.isAdmin()){
			cpnList=xyd_cpn_deptDao.userCpnList(null);
			cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(null);
		}else{
			cpnList=xyd_cpn_deptDao.userCpnList(cpnId);
			cpnBranchList=xyd_cpn_deptDao.userCpnBranchList(cpnId);
		}
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
		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_deptDao.queryCpnId(userId);
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
		LogObjectHolder.me().set(xyd_cpn_dept);
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
		LogObjectHolder.me().set(xyd_cpn_dept);
		return PREFIX + "cpn_dept_detail.html";
	}

	/**
	 * 获取企业组织管理列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String condition, @RequestParam(required = false) Integer cpn_dept_id) {

		Integer userId = ShiroKit.getUser().getId();
		Integer cpnId = xyd_cpn_deptDao.queryCpnId(userId);

		if(ShiroKit.isAdmin()){
			if (null==cpn_dept_id){
				cpn_dept_id=0;
			}
			List<Map<String, Object>> list=this.xyd_cpn_deptDao.selectCpnDepts(cpn_dept_id,condition);
			return super.warpObject(new Xyd_cpn_deptWarpper(list));
		}
		else {
			List<Map<String, Object>> list=this.xyd_cpn_deptDao.list(condition, cpn_dept_id,cpnId);
			return super.warpObject(new Xyd_cpn_deptWarpper(list));
		}
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
		Integer cpnBranchId = ShiroKit.getUser().getCpn_branch_id();
		List<Map<String, Object>> list = this.xyd_cpn_deptDao.nowBranchDeptList(cpnBranchId);
		return super.warpObject(new Xyd_cpn_deptWarpper(list));
	}
	/**
	 * 获取公司的tree列表
	 */
	@RequestMapping(value = "/tree/{userDeptId}")
	@ResponseBody
	public List<ZTreeNode> tree(@PathVariable Integer userDeptId) {
		List<ZTreeNode> tree = null;
		Integer size = xyd_cpn_deptDao.isParent(userDeptId);
		Integer verySize = xyd_cpn_deptDao.isVeryParent(userDeptId);
		System.err.println("size:"+size);
		Integer parId = null;
		Integer deptId = null;
		if(size>0){
			parId = userDeptId;
		}else if(size==0){
			deptId =userDeptId;
		}else if(verySize>0){
			parId =userDeptId;
			deptId =userDeptId;
		}

		if(ShiroKit.isAdmin()){
			tree = this.xyd_cpn_deptDao.tree(null,parId,deptId);
			tree.add(ZTreeNode.createParent());
		}else{
			Integer userId = ShiroKit.getUser().getId();
			Integer cpnId = xyd_cpn_deptDao.queryCpnId(userId);
			tree = this.xyd_cpn_deptDao.tree(cpnId,parId,deptId);
			tree.add(ZTreeNode.createParent());
		}


		return tree;
	}

	/**
	 * 获取栏目分类网页的tree列表
	 */
	@RequestMapping(value = "/depttree")
	@ResponseBody
	public List<ZTreeNode> itemtree() {
		List<ZTreeNode> depttree = this.xyd_cpn_deptDao.depttree();
		depttree.add(ZTreeNode.createParent());
		return depttree;
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
	public Object add(@PathParam("cpnid") Integer cpnid,@PathParam("xyd_cpn_dept") Xyd_cpn_dept xyd_cpn_dept) {
		xyd_cpn_dept.setCre_dt(new Date());
		xyd_cpn_dept.setCpn_id(cpnid);
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

	/**
	 * 导出企业组织管理
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xyd_cpn_dept.xls";
		String tarPath = "src/main/resources/excel/xyd_cpn_dept.xls";
		Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);
		//下载
		String fileName = "xyd_cpn_dept"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_cpn_dept.xls")));
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