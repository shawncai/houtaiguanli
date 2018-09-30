package wy.addons.zcgl.prdCls.warpper;


import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.addons.zcgl.prdCls.controller.Xgt_goods_prd_clsController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;

import java.util.List;
import java.util.Map;

/**
 * 产品分类warpper接口
 *
 * @author wyframe
 * @Date 2017-11-21 21:10:33
 */
 
 public class Xgt_goods_prd_clsWarpper extends BaseControllerWarpper{
 		public Xgt_goods_prd_clsWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
			List<Map<String, Object>> list = ConstantFactory.me().getDictByName("产品分类状态");
			for (Map m : list) {
				if (m.get("num").equals(map.get("st_id"))) {
					map.put("st_id", m.get("name"));
				}
			}

			if (map.get("sn_flg").toString().equals("1")){
				map.put("sn_flg","√");
			}else{
				map.put("sn_flg","-");
			}
 		}
 }