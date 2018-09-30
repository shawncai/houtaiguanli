package wy.addons.fxb.xgt_subject.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 科目warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-05 10:03:14
 */
 
 public class Xgt_subjectWarpper extends BaseControllerWarpper{
 		public Xgt_subjectWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list3 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list3) {
                	if ((m.get("num")+"").equals(map.get("xyd_st_id")+"")) {
                			map.put("xyd_st_id", m.get("name"));
                	                    }
                	                }
 		}
 }