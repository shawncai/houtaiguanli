package wy.addons.fxb.xgt_sub_task_dtl.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 任务详情warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-05 15:20:52
 */
 
 public class Xgt_sub_task_dtlWarpper extends BaseControllerWarpper{
 		public Xgt_sub_task_dtlWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list6 = ConstantFactory.me().getDictByName("正确与否");
                for (Map m : list6) {
                	if ((m.get("num")+"").equals(map.get("right_errof_flg")+"")) {
                			map.put("right_errof_flg", m.get("name"));
                	                    }
                	                }
 			List<Map<String, Object>> list10 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list10) {
                	if ((m.get("num")+"").equals(map.get("st_id")+"")) {
                			map.put("st_id", m.get("name"));
                	                    }
                	                }
 		}
 }