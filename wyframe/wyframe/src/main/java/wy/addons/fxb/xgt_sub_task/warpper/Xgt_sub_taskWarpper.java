package wy.addons.fxb.xgt_sub_task.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 作业任务warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-05 11:51:57
 */
 
 public class Xgt_sub_taskWarpper extends BaseControllerWarpper{
 		public Xgt_sub_taskWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list9 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list9) {
                	if ((m.get("num")+"").equals(map.get("st_id")+"")) {
                			map.put("st_id", m.get("name"));
                	                    }
                	                }
 		}
 }