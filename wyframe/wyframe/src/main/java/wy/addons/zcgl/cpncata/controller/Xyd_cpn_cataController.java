package wy.addons.zcgl.cpncata.controller;

import wy.addons.zcgl.cpncata.dao.Xyd_cpn_cataDao;
import wy.addons.zcgl.cpncata.dao.Xyd_cpn_cataMapper;
import wy.addons.zcgl.cpncata.model.Xyd_cpn_cata;
import wy.addons.zcgl.cpncata.warpper.Xyd_cpn_cataWarpper;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
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
		LogObjectHolder.me().set(xyd_cpn_cata);
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
		LogObjectHolder.me().set(xyd_cpn_cata);
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

	/**
	 * 导出入驻企业
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res) throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xyd_cpn_cata.xls";
		String tarPath = "src/main/resources/excel/xyd_cpn_cata.xls";
		String condition = null;
//		List<Map<String, Object>> list = this.xyd_cpn_cataDao.list(condition);
		Map<String, List<Map<String, Object>>> beanParams = new HashMap<String, List<Map<String, Object>>>();
//		beanParams.put("list", list);
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);
		// 下载
		String fileName = "xyd_cpn_cata" + DateUtil.getAllTime() + ".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xyd_cpn_cata.xls")));
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
