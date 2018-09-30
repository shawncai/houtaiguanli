package wy.addons.fxb.xgt_sub_task_obj.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 作业对象warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-05 15:45:21
 */
 
 public class Xgt_sub_task_objWarpper extends BaseControllerWarpper{
 		public Xgt_sub_task_objWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("完成状态");
                for (Map m : list5) {
                	if ((m.get("num")+"").equals(map.get("over_st_id")+"")) {
                			map.put("over_st_id", m.get("name"));
                	                    }
                	                }
 			List<Map<String, Object>> list11 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list11) {
                	if ((m.get("num")+"").equals(map.get("st_id")+"")) {
                			map.put("st_id", m.get("name"));
                	                    }
                	                }
 		}
 }