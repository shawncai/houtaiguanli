package wy.addons.zcgl.cpncata.warpper;

import wy.addons.zcgl.cpncata.controller.Xyd_cpn_cataController;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;

import java.util.List;
import java.util.Map;

/**
 * 入驻企业warpper接口
 *
 * @author wyframe
 * @Date 2017-09-06 18:41:54
 */

public class Xyd_cpn_cataWarpper extends BaseControllerWarpper {

	public Xyd_cpn_cataWarpper(Object obj) {

		super(obj);

	}

	protected void warpTheMap(Map<String, Object> map) {

		/**
		 * 根据上级入驻企业类型Id查询入驻企业类型名称
		 */
		Xyd_cpn_cataController cpnCataController = SpringContextHolder.getBean(Xyd_cpn_cataController.class);
		List<Map<String, Object>> cpnCataList = cpnCataController.cpnCataList();
		Integer cpnCataPid = (Integer) map.get("par_cpn_cata_id");
		for (Map cpnCata : cpnCataList) {
			if (cpnCata.get("cpn_cata_id").equals(cpnCataPid)) {
				map.put("par_cpn_cata_id", cpnCata.get("cpn_cata_nm"));
			}
		}
	}
}