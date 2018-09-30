package wy.addons.fxb.xgt_sub_exam.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 试卷warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-04 11:49:20
 */
 
 public class Xgt_sub_examWarpper extends BaseControllerWarpper{
 		public Xgt_sub_examWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list13 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list13) {
                	if ((m.get("num")+"").equals(map.get("st_id")+"")) {
                			map.put("st_id", m.get("name"));
                	                    }
                	                }
 		}
 }