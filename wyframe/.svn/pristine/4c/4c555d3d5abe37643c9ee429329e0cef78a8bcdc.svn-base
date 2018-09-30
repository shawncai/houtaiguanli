package wy.addons.zcgl.wyitem.warpper;

import wy.addons.zcgl.wyitem.controller.Xgt_wy_itemController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 栏目warpper接口
 *
 * @author wyframe
 * @Date 2017-11-08 10:21:13
 */

public class Xgt_wy_itemWarpper extends BaseControllerWarpper {
	public Xgt_wy_itemWarpper(Object obj) {

		super(obj);

	}

	protected void warpTheMap(Map<String, Object> map) {

		List<Map<String, Object>> list = ConstantFactory.me().getDictByName("栏目状态");
		for (Map m : list) {
			if (m.get("num").equals(map.get("st_id"))) {
				map.put("st_id", m.get("name"));
			}
		}

	}
}