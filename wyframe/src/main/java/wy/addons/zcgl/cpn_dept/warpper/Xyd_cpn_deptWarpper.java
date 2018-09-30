package wy.addons.zcgl.cpn_dept.warpper;

import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.addons.zcgl.cpn_dept.controller.Xyd_cpn_deptController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 企业员工warpper接口
 *
 * @author wyframe
 * @Date 2017-09-18 11:38:47
 */

public class Xyd_cpn_deptWarpper extends BaseControllerWarpper {
	public Xyd_cpn_deptWarpper(Object obj) {

		super(obj);

	}

	protected void warpTheMap(Map<String, Object> map) {
		List<Map<String, Object>> list = ConstantFactory.me().getDictByName("企业状态");
		for (Map m : list) {
			if (m.get("num").equals(map.get("st_id"))) {
				map.put("st_id", m.get("name"));
			}
		}
	}
}