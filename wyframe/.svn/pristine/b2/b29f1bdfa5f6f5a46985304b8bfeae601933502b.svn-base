package wy.addons.zcgl.products.warpper;


import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 商品管理warpper接口
 *
 * @author wyframe
 * @Date 2018-05-08 16:35:29
 */
 
 public class Xgt_goods_productWarpper extends BaseControllerWarpper {
 		public Xgt_goods_productWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
			List<Map<String, Object>> list = ConstantFactory.me().getDictByName("状态");
			for (Map m : list) {
				if (m.get("num").equals(map.get("st_id"))) {
					map.put("st_id", m.get("name"));
				}
			}
 		}

 }