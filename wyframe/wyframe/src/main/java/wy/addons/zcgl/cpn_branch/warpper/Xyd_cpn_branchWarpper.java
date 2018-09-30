package wy.addons.zcgl.cpn_branch.warpper;


import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;

import java.util.List;
import java.util.Map;

/**
 * 企业分支机构warpper接口
 *
 * @author wyframe
 * @Date 2017-09-18 11:22:47
 */
 public class Xyd_cpn_branchWarpper extends BaseControllerWarpper{
 		public Xyd_cpn_branchWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 			
 			/**
 		     * 根据企业分支机构状态显示其名称
 		     */
 			DictController dictController = SpringContextHolder.getBean(DictController.class);	
 			List<Map<String, Object>> cpnBranchStList = dictController.cpnBranchStList();
 			Integer cpnBranchStId = (Integer) map.get("st_id");
 			for(Map cpnBranchStMap : cpnBranchStList) {
 				if(cpnBranchStMap.get("num").equals(cpnBranchStId)) {
 					map.put("st_id", cpnBranchStMap.get("name"));
 				}
 			}
 		}
 }