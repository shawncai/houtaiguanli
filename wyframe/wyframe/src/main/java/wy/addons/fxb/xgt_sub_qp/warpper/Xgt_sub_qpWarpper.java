package wy.addons.fxb.xgt_sub_qp.warpper;

import java.util.Map;
import wy.common.constant.factory.ConstantFactory;
import wy.core.base.warpper.BaseControllerWarpper;
import java.util.List;
import wy.config.properties.XydProperties;
import wy.core.util.SpringContextHolder;

/**
 * 题目warpper接口
 *
 * @author wyFrame
 * @Date 2018-09-12 16:19:48
 */
 
 public class Xgt_sub_qpWarpper extends BaseControllerWarpper{
 		public Xgt_sub_qpWarpper(Object obj){
 			super(obj);
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			List<Map<String, Object>> list4 = ConstantFactory.me().getDictByName("题目类型");
                for (Map m : list4) {
                	if ((m.get("num")+"").equals(map.get("sub_qp_tp_id")+"")) {
                			map.put("sub_qp_tp_id", m.get("name"));
                	                    }
                	                }
 			List<Map<String, Object>> list5 = ConstantFactory.me().getDictByName("题目难度");
                for (Map m : list5) {
                	if ((m.get("num")+"").equals(map.get("sub_qp_ea_id")+"")) {
                			map.put("sub_qp_ea_id", m.get("name"));
                	                    }
                	                }
 			List<Map<String, Object>> list14 = ConstantFactory.me().getDictByName("题目分类");
                for (Map m : list14) {
                	if ((m.get("num")+"").equals(map.get("spec_flg")+"")) {
                			map.put("spec_flg", m.get("name"));
                	                    }
                	                }
 			List<Map<String, Object>> list17 = ConstantFactory.me().getDictByName("状态");
                for (Map m : list17) {
                	if ((m.get("num")+"").equals(map.get("st_id")+"")) {
                			map.put("st_id", m.get("name"));
                	                    }
                	                }
 		}
 }