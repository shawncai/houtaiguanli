package wy.addons.zcgl.prdBrand.warpper;


import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 产品品牌warpper接口
 *
 * @author wyframe
 * @Date 2017-11-21 21:07:58
 */
 
 public class Xgt_goods_prd_brandWarpper extends BaseControllerWarpper{
 		public Xgt_goods_prd_brandWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){

			/**
			 * 根据产品品牌状态显示其名称
			 */
			List<Map<String, Object>> list = ConstantFactory.me().getDictByName("产品品牌状态");
			for (Map m : list) {
				if (m.get("num").equals(map.get("st_id"))) {
					map.put("st_id", m.get("name"));
				}
			}
 			

 		}
 }