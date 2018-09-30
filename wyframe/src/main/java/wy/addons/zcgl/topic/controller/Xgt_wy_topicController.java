package wy.addons.zcgl.topic.controller;

import wy.addons.zcgl.image.dao.Xyd_image_fileDao;
import wy.addons.zcgl.topic.dao.Xgt_wy_topicDao;
import wy.addons.zcgl.topic.dao.Xgt_wy_topicMapper;
import wy.addons.zcgl.topic.model.Xgt_wy_topic;
import wy.addons.zcgl.topic.warpper.Xgt_wy_topicWarpper;
import wy.addons.zcgl.wyitem.dao.Xgt_wy_itemDao;
import com.alibaba.fastjson.JSON;
import wy.core.base.controller.BaseController;
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
 * 站点栏目控制器
 *
 * @author wyframe
 * @Date 2017-11-09 10:39:19
 */
@Controller
@RequestMapping("/xgt_wy_topic")
public class Xgt_wy_topicController extends BaseController {
	private String PREFIX = "/addons/zcgl/topic/";
	@Resource
    Xgt_wy_topicDao xgt_wy_topicDao;

	@Resource
    Xgt_wy_itemDao xgt_wy_itemDao;

	@Resource
    Xgt_wy_topicMapper xgt_wy_topicMapper;

	@Resource
    Xyd_image_fileDao xyd_image_fileDao;

	public static List<Map<String, Object>> paramList = null;

	/**
	 * 跳转到站点栏目首页
	 */
	@RequestMapping("")
	public String index(Model model) {
		return PREFIX + "t_topic.html";
	}

	/**
	 * 跳转到添加站点栏目
	 */
	@RequestMapping("/xgt_wy_topic_add")
	public String xgt_wy_topicAdd(Model model) {

		List<Map<String, Object>> topicList = xgt_wy_itemDao.topicList();
		// for(Map topic : topicList) {
		// System.out.println(topic.toString());
		// }
		model.addAttribute("topicList", topicList);
		// return PREFIX + "xgt_wy_topic_add.html";
		return PREFIX + "wy_topic_add.html";
	}

	/**
	 * 跳转到添加参数
	 */
	@RequestMapping("/xgt_wy_topic_add_param")
	public String xgt_wy_topic_add_param() {
		return PREFIX + "xgt_wy_topic_add_param.html";
	}

	/**
	 * 跳转到修改站点栏目
	 */
	@RequestMapping("/xgt_wy_topic_update/{xgt_wy_topicId}")
	public String xgt_wy_topicUpdate(@PathVariable Integer xgt_wy_topicId, Model model) {
		Xgt_wy_topic xgt_wy_topic = this.xgt_wy_topicDao.queryById(xgt_wy_topicId);
		model.addAttribute(xgt_wy_topic);
		LogObjectHolder.me().set(xgt_wy_topic);
		return PREFIX + "xgt_wy_topic_edit.html";
	}

	/**
	 * 跳转到详情站点栏目
	 */
	@RequestMapping("/xgt_wy_topic_detail/{xgt_wy_topicId}")
	public String xgt_wy_topicDetail(@PathVariable Integer xgt_wy_topicId, Model model) {
		Xgt_wy_topic xgt_wy_topic = this.xgt_wy_topicDao.queryById(xgt_wy_topicId);
		model.addAttribute(xgt_wy_topic);
		LogObjectHolder.me().set(xgt_wy_topic);
		return PREFIX + "xgt_wy_topic_detail.html";
	}

	/**
	 * 获取站点栏目列表
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		paramList = null;
		List<Map<String, Object>> list = this.xgt_wy_topicDao.list(condition);
		return super.warpObject(new Xgt_wy_topicWarpper(list));
	}

	@RequestMapping(value = "/init")
	@ResponseBody
	public Object init() {
		List<Map<String, Object>> topicList = this.xgt_wy_topicDao.list(null);
		for (Map<String, Object> m : topicList) {
			if (m.get("image_file_id") != null) {
				Map<String, String> imageMap = xyd_image_fileDao
						.iQueryById(Integer.parseInt(m.get("image_file_id") + ""));
				m.put("img_url", imageMap.get("image_file_nm") + "");
				m.put("item_cls", 2);
			} else {
				m.put(m.get("top_pro_nm_alias") + "", m.get("top_pro_nr") + "");
				m.put("item_cls", 1);
			}
		}
		return topicList;
	}

	/**
	 * 新增站点栏目
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public Object add(String dataStr) {
		// return this.xgt_wy_topicMapper.insert(xgt_wy_topic);
		List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(dataStr);
		for (Map<String, Object> map : list) {
			this.xgt_wy_topicDao.deletePar(Integer.parseInt(map.get("par_item_id") + ""));
		}
		for (Map<String, Object> map : list) {
			// this.xgt_wy_topicDao.deletePar(Integer.parseInt(map.get("par_item_id")+""));
			if (map.get("item_cls").equals(2)) {
				Xgt_wy_topic xgt_wy_topic = new Xgt_wy_topic();
				xgt_wy_topic.setItem_id(Integer.parseInt(map.get("item_id") + ""));
				xgt_wy_topic.setCpn_id(null);
				xgt_wy_topic.setItem_id(Integer.parseInt(map.get("item_id") + ""));
				xgt_wy_topic.setOper_user(null);
				xgt_wy_topic.setPar_item_id(Integer.parseInt(map.get("par_item_id") + ""));
				xgt_wy_topic.setSt_id(Integer.parseInt(map.get("st_id") + ""));
				xgt_wy_topic.setTop_pro_nm(map.get("item_nm") + "");
				xgt_wy_topic.setTop_pro_nm_alias(map.get("item_nm_alias") + "");
				// xgt_wy_topic.setTop_pro_nr(map.get("top_pro_nr")+"");
				xgt_wy_topic.setImage_file_id(Integer.parseInt(map.get("image_file_id") + ""));
				this.xgt_wy_topicMapper.insert(xgt_wy_topic);
			} else if (map.get("item_cls").equals(1)) {
				Xgt_wy_topic xgt_wy_topic = new Xgt_wy_topic();
				xgt_wy_topic.setCpn_id(null);
				xgt_wy_topic.setItem_id(Integer.parseInt(map.get("item_id") + ""));
				xgt_wy_topic.setOper_user(null);
				xgt_wy_topic.setPar_item_id(Integer.parseInt(map.get("par_item_id") + ""));
				xgt_wy_topic.setSt_id(Integer.parseInt(map.get("st_id") + ""));
				xgt_wy_topic.setTop_pro_nm(map.get("item_nm") + "");
				xgt_wy_topic.setTop_pro_nm_alias(map.get("item_nm_alias") + "");
				xgt_wy_topic.setTop_pro_nr(map.get("top_pro_nr") + "");
				this.xgt_wy_topicMapper.insert(xgt_wy_topic);
			}
		}
		return SUCCESS_TIP;
	}

	/**
	 * 删除站点栏目
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@RequestParam Integer xgt_wy_topicId) {
		this.xgt_wy_topicMapper.deleteById(xgt_wy_topicId);
		return SUCCESS_TIP;
	}

	/**
	 * 修改站点栏目
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Object update(Xgt_wy_topic xgt_wy_topic) {
		this.xgt_wy_topicMapper.updateById(xgt_wy_topic);
		paramList = null;
		return super.SUCCESS_TIP;
	}

	/**
	 * 导出站点栏目
	 */
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse res) throws ParsePropertyException, InvalidFormatException, IOException {
		String resourcePath = "src/main/resources/excelTemplate/xgt_wy_topic.xls";
		String tarPath = "src/main/resources/excel/xgt_wy_topic.xls";
		String condition = null;
		List<Map<String, Object>> list = this.xgt_wy_topicDao.list(condition);
		Map<String, List<Map<String, Object>>> beanParams = new HashMap<String, List<Map<String, Object>>>();
		beanParams.put("list", list);
		XLSTransformer former = new XLSTransformer();
		former.transformXLS(resourcePath, beanParams, tarPath);

		// 下载
		String fileName = "xgt_wy_topic" + DateUtil.getAllTime() + ".xls";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("src/main/resources/excel/xgt_wy_topic.xls")));
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
