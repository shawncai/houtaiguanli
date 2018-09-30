package wy.addons.zcgl.cpn_store.warpper;


import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.addons.zcgl.cpn_store.controller.Xyd_cpn_storeController;
import wy.xydframe.system.controller.DictController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;

import java.util.List;
import java.util.Map;

/**
 * 企业仓库warpper接口
 *
 * @author wyframe
 * @Date 2017-09-18 11:41:05
 */
 
 public class Xyd_cpn_storeWarpper extends BaseControllerWarpper{
 		public Xyd_cpn_storeWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
/**
 * 根据产品品牌状态显示其名称
 */
			List<Map<String, Object>> list = ConstantFactory.me().getDictByName("仓库状态");
			for (Map m : list) {
				if (m.get("num").equals(map.get("st_id"))) {
					map.put("st_id", m.get("name"));
				}
			}
 		}
 }