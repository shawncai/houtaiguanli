package wy.addons.zcgl.xgt_vendor.warpper;

import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 产品warpper接口
 *
 * @author wyframe
 * @Date 2017-11-27 14:46:23
 */

public class Xgt_goods_prd_vendorWarpper extends BaseControllerWarpper {
	public Xgt_goods_prd_vendorWarpper(Object obj) {

		super(obj);

	}

	protected void warpTheMap(Map<String, Object> map) {

		List<Map<String, Object>> list = ConstantFactory.me().getDictByName("仓库状态");
		for (Map m : list) {
			if (m.get("num").equals(map.get("st_id"))) {
				map.put("st_id", m.get("name"));
			}
		}

		List<Map<String, Object>> list2 = ConstantFactory.me().getDictByName("合伙类别");
		for (Map m : list2) {
			if (m.get("num").equals(map.get("vendor_flg"))) {
				map.put("vendor_flg", m.get("name"));
			}
	}
}
}