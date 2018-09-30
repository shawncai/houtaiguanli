package wy.addons.zcgl.xgt_goods_products.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 商品测试warpper接口
 *
 * @author wyFrame
 * @Date 2018-07-20 20:23:12
 */
 
 public class Xgt_goods_productsWarpper extends BaseControllerWarpper{
 		public Xgt_goods_productsWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list = ConstantFactory.me().getDictByName("删除状态");
                for (Map m : list) {
                	if ((m.get("num")+"").equals(map.get("xyd_st_id")+"")) {
                			map.put("xyd_st_id", m.get("name"));
                	                    }
                	                }
         		map.put("prd_nm_img",SpringContextHolder.getBean(XydProperties.class).getUrl()+map.get("prd_nm_img"));
 		}
 }