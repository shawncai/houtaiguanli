package wy.addons.zcgl.xydcpn.warpper;

import wy.addons.zcgl.cpncata.controller.Xyd_cpn_cataController;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 企业warpper接口
 *
 * @author wyframe
 * @Date 2017-09-08 17:08:38
 */

public class Xyd_cpnWarpper extends BaseControllerWarpper {
	public Xyd_cpnWarpper(Object obj) {

		super(obj);

	}

	protected void warpTheMap(Map<String, Object> map) {

		/**
		 * 通过企业信息企业状态Id查询状态名称
		 */
		DictController dictController = SpringContextHolder.getBean(DictController.class);
		List<Map<String, Object>> cpnStList = dictController.cpnStList();
		List<Map<String, Object>> cpnSpStList = dictController.cpSpStList();
		Integer cpnStId = (Integer) map.get("cpn_st");
		Integer cpnSpStId = (Integer) map.get("cp_sp_st");
		for (Map cpnStMap : cpnStList) {
			if (cpnStMap.get("num").equals(cpnStId)) {
				map.put("cpn_st", cpnStMap.get("name"));
			}
		}
		for (Map cpnSpStMap : cpnSpStList) {
			if (cpnSpStMap.get("num").equals(cpnSpStId)) {
				map.put("cp_sp_st", cpnSpStMap.get("name"));
			}
		}

		/**
		 * 通过入驻企业类型Id查询入驻企业类型名称
		 */
		Xyd_cpn_cataController cpnCataController = SpringContextHolder.getBean(Xyd_cpn_cataController.class);
		List<Map<String, Object>> cpnCataList = cpnCataController.cpnCataList();
		Integer cpnCataPid = (Integer) map.get("cpn_cata_id");
		for (Map cpnCata : cpnCataList) {
			if (cpnCata.get("cpn_cata_id").equals(cpnCataPid)) {
				map.put("cpn_cata_id", cpnCata.get("cpn_cata_nm"));
			}
		}
	}
}