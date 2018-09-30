package wy.addons.zcgl.wyitem.controller;

import wy.addons.zcgl.wyitem.dao.Xgt_wy_itemDao;
import wy.addons.zcgl.wyitem.dao.Xgt_wy_itemMapper;
import wy.addons.zcgl.wyitem.model.Xgt_wy_item;
import wy.addons.zcgl.wyitem.warpper.Xgt_wy_itemWarpper;
import wy.core.base.controller.BaseController;
import wy.core.node.ZTreeNode;
import wy.core.shiro.ShiroKit;
import wy.core.util.DateUtil;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wy.core.log.LogObjectHolder;
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
 * 栏目控制器
 *
 * @author wyframe
 * @Date 2017-11-08 10:21:13
 */
@Controller
@RequestMapping("/xgt_wy_item")
public class Xgt_wy_itemController extends BaseController {
	private String PREFIX = "/addons/zcgl/wyitem/";

	@Resource
	Xgt_wy_itemDao xgt_wy_itemDao;

	@Resource
	Xgt_wy_itemMapper xgt_wy_itemMapper;

	@Resource
	DictDao dictDao;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到栏目首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "xgt_wy_item2.html";
	}

	/**
	 * 跳转到添加栏目
	 */
	@RequestMapping("/xgt_wy_item_add/{ItemId}")
	public String xgt_wy_itemAdd(@PathVariable("ItemId") Integer ItemId,Model model) {
		List<Map<String, Object>> wyItemSts = dictDao.selectItemStList();
		List<Map<String, Object>> wyItemCls = dictDao.selectItemCls();
		String wyItemNm=xgt_wy_itemDao.selectWyItemNm(ItemId);
		model.addAttribute("wyItemSts", wyItemSts);
		model.addAttribute("wyItemCls", wyItemCls);
		model.addAttribute("wyItemId", ItemId);
		model.addAttribute("wyItemNm", wyItemNm);
		return PREFIX + "wy_item_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_wy_item_add_param")
	public String xgt_wy_item_add_param() {
		return PREFIX + "xgt_wy_item_add_param.html";
	}

	/**
	 * 跳转到修改栏目
	 */
	@RequestMapping("/xgt_wy_item_update/{xgt_wy_itemId}")
	public String xgt_wy_itemUpdate(@PathVariable Integer xgt_wy_itemId, Model model) {
		Xgt_wy_item xgt_wy_item = this.xgt_wy_itemDao.queryById(xgt_wy_itemId);

		//获取上级栏目名字
		String pWyItemNm = xgt_wy_itemDao.selectPItemNm(xgt_wy_itemId);
		//获取状态名字
		List<Map<String, Object>> wyItemSts = dictDao.selectItemStList();
		//获取栏目分类名字
		List<Map<String, Object>> wyItemCls = dictDao.selectItemCls();
		model.addAttribute("wyItemCls", wyItemCls);
		model.addAttribute("wyItemSts", wyItemSts);
		model.addAttribute("pWyItemNm", pWyItemNm);
		model.addAttribute(xgt_wy_item);
		LogObjectHolder.me().set(xgt_wy_item);
		return PREFIX + "wy_item_edit.html";
	}

	/**
	 * 跳转到详情栏目
	 */
	@RequestMapping("/xgt_wy_item_detail/{xgt_wy_itemId}")
	public String xgt_wy_itemDetail(@PathVariable Integer xgt_wy_itemId, Model model) {
		Xgt_wy_item xgt_wy_item = this.xgt_wy_itemDao.queryById(xgt_wy_itemId);

		//获取上级栏目名字
		String pWyItemNm = xgt_wy_itemDao.selectPItemNm(xgt_wy_itemId);
		//获取状态名字
		List<Map<String, Object>> wyItemStList = dictDao.selectItemSts();
		Integer wyItemStId = xgt_wy_item.getSt_id();
		for(Map wyItemStMap : wyItemStList) {
			if(wyItemStMap.get("num").equals(wyItemStId)) {
				model.addAttribute("st_id", wyItemStMap.get("name"));
			}
		}
		//获取栏目分类名字
		List<Map<String, Object>> wyItemCls = dictDao.selectItemCls();
		Integer wyItemClsId = xgt_wy_item.getItem_cls();
		for(Map wyItemClsMap : wyItemCls) {
			if(wyItemClsMap.get("num").equals(wyItemClsId)) {
				model.addAttribute("item_cls", wyItemClsMap.get("name"));
			}
		}
		List<Map<String, Object>> wyItemSts = dictDao.selectItemStList();
		model.addAttribute(xgt_wy_item);
		model.addAttribute("pWyItemNm", pWyItemNm);
		model.addAttribute("wyItemCls", wyItemCls);
		model.addAttribute("wyItemSts", wyItemSts);
		LogObjectHolder.me().set(xgt_wy_item);
		return PREFIX + "wy_item_detail.html";
	}

	/**
	 * 获取栏目列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(required = false) String item_nm, @RequestParam(required = false) Integer itemId) {
		paramList = null;
		List<Map<String, Object>> list = this.xgt_wy_itemDao.list(item_nm, itemId);
		return super.warpObject(new Xgt_wy_itemWarpper(list));
	}

	/**
	 * 获取栏目列表
	 */
	@RequestMapping(value = "/list2")
	@ResponseBody
	public Object list2(@RequestParam(required = false) String condition,@RequestParam(required = false) Integer itemId) {
		System.err.println(condition);
		if (null==itemId){
			itemId=0;
		}
		List<Map<String, Object>> list = this.xgt_wy_itemDao.list2(condition,itemId);
		return super.warpObject(new Xgt_wy_itemWarpper(list));
	}

	/**
	 * 获取所有栏目
	 */
	public List<Map<String, Object>> itemList() {
		List<Map<String, Object>> itemList = xgt_wy_itemDao.selectItems();
		return itemList;
	}

	/**
	 * 获取栏目的tree列表
	 */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public List<ZTreeNode> tree() {
		List<ZTreeNode> tree = this.xgt_wy_itemDao.tree();
		tree.add(ZTreeNode.createParent());
		return tree;
	}


	@RequestMapping(value = "/orderItem")
	@ResponseBody
	public List<Map<String, Object>> orderItem() {
		List<Map<String, Object>> itemList = xgt_wy_itemDao.topicList();
		return itemList;
	}

	/**
	 * 获取栏目分类网页的tree列表
	 */
	@RequestMapping(value = "/itemTree")
	@ResponseBody
	public List<ZTreeNode> itemTree() {
		List<ZTreeNode> itemTree = this.xgt_wy_itemDao.itemTree();
		itemTree.add(ZTreeNode.createParent());
		return itemTree;
	}

	/**
	 * 新增栏目
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(Xgt_wy_item xgt_wy_item) {
		String userName = ShiroKit.getUser().getName();
		xgt_wy_item.setSt_id(1);
		xgt_wy_item.setOper_user(userName);
		xgt_wy_item.setCre_dt(new Date());
		return this.xgt_wy_itemMapper.insert(xgt_wy_item);
	}

	/**
	 * 删除栏目
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xgt_wy_itemId) {
		this.xgt_wy_itemMapper.deleteById(xgt_wy_itemId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改栏目
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xgt_wy_item xgt_wy_item) {
		this.xgt_wy_itemMapper.updateById(xgt_wy_item);
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出栏目
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res)  throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xgt_wy_item.xls";
		String tarPath = "src/main/resources/excel/xgt_wy_item.xls";
		Map<String, List<Map<String,Object>>> beanParams = new HashMap<String, List<Map<String,Object>>>();
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);

		//下载
		String fileName = "xgt_wy_item"+DateUtil.getAllTime()+".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_wy_item.xls")));
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
