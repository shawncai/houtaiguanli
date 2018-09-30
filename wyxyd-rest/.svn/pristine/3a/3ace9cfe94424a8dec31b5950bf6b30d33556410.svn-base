package wy.rest.addons.zcgl.cpncata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.core.base.controller.BaseController;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zcgl.cpncata.dao.Xyd_cpn_cataDao;
import wy.rest.addons.zcgl.cpncata.dao.Xyd_cpn_cataMapper;
import wy.rest.addons.zcgl.cpncata.model.Xyd_cpn_cata;
import wy.rest.addons.zcgl.cpncata.warpper.Xyd_cpn_cataWarpper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 入驻企业控制器
 *
 * @author wyframe
 * @Date 2017-09-06 18:41:53
 */
@Controller
@RequestMapping("/xyd_cpn_cata")
public class Xyd_cpn_cataController extends BaseController {
	private String PREFIX = "/addons/zcgl/cpncata/";

	@Resource
	Xyd_cpn_cataDao xyd_cpn_cataDao;

	@Resource
	Xyd_cpn_cataMapper xyd_cpn_cataMapper;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到入驻企业首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xyd_cpn_cata.html";
	}

	/**
	 * 跳转到添加入驻企业
	 */
	@RequestMapping("/xyd_cpn_cata_add")
	public String xyd_cpn_cataAdd() {
		// return PREFIX + "xyd_cpn_cata_add.html";
		return PREFIX + "cpn_cata_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xyd_cpn_cata_add_param")
	public String xyd_cpn_cata_add_param() {
		return PREFIX + "xyd_cpn_cata_add_param.html";
	}

	/**
	 * 跳转到修改入驻企业
	 */
	@RequestMapping("/xyd_cpn_cata_update/{xyd_cpn_cataId}")
	public String xyd_cpn_cataUpdate(@PathVariable Integer xyd_cpn_cataId, Model model) {
		Xyd_cpn_cata xyd_cpn_cata = this.xyd_cpn_cataDao.queryById(xyd_cpn_cataId);
		
		String pCpnCataNm = xyd_cpn_cataDao.selectPCpnCataNm(xyd_cpn_cataId);
		model.addAttribute("pCpnCataNm", pCpnCataNm);
		
		model.addAttribute(xyd_cpn_cata);
		// return PREFIX + "xyd_cpn_cata_edit.html";
		return PREFIX + "cpn_cata_edit.html";
	}

	/**
	 * 跳转到详情入驻企业
	 */
	@RequestMapping("/xyd_cpn_cata_detail/{xyd_cpn_cataId}")
	public String xyd_cpn_cataDetail(@PathVariable Integer xyd_cpn_cataId, Model model) {
		Xyd_cpn_cata xyd_cpn_cata = this.xyd_cpn_cataDao.queryById(xyd_cpn_cataId);
		String pCpnCataNm = xyd_cpn_cataDao.selectPCpnCataNm(xyd_cpn_cataId);
		model.addAttribute("pCpnCataNm", pCpnCataNm);
		model.addAttribute(xyd_cpn_cata);
		// return PREFIX + "xyd_cpn_cata_detail.html";
		return PREFIX + "cpn_cata_detail.html";
	}

	/**
	 * 获取入驻企业列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String cpn_cata_nm, @RequestParam(required = false) Integer cpn_cata_id) {
		paramList = null;
		List<Map<String, Object>> list = this.xyd_cpn_cataDao.list(cpn_cata_nm, cpn_cata_id);
		return super.warpObject(new Xyd_cpn_cataWarpper(list));
	}

	/**
	 * 获取所有入驻企业
	 */
	public List<Map<String, Object>> cpnCataList() {
		List<Map<String, Object>> cpnCataList = this.xyd_cpn_cataDao.selectCpnCatas();
		return cpnCataList;
	}

	/**
	 * 获取公司的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree() {
		List<ZTreeNode> tree = this.xyd_cpn_cataDao.tree();
		tree.add(ZTreeNode.createParent());
		return tree;
	}

	/**
	 * 新增入驻企业
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xyd_cpn_cata xyd_cpn_cata) {
		return this.xyd_cpn_cataMapper.insert(xyd_cpn_cata);
	}

	/**
	 * 删除入驻企业
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xyd_cpn_cataId) {
		this.xyd_cpn_cataMapper.deleteById(xyd_cpn_cataId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改入驻企业
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xyd_cpn_cata xyd_cpn_cata) {
		this.xyd_cpn_cataMapper.updateById(xyd_cpn_cata);
		paramList = null;
		return super.SUCCESS_TIP;
	}

}
