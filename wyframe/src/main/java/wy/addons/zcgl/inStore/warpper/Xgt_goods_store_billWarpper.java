package wy.addons.zcgl.inStore.warpper;


import wy.addons.zcgl.cpn_branch.controller.Xyd_cpn_branchController;
import wy.addons.zcgl.cpn_store.controller.Xyd_cpn_storeController;
import wy.core.base.warpper.BaseControllerWarpper;
import wy.core.util.SpringContextHolder;
import wy.xydframe.system.controller.DictController;
import wy.addons.zcgl.xydcpn.controller.Xyd_cpnController;

import java.util.List;
import java.util.Map;

/**
 * 入库单warpper接口
 *
 * @author wyframe
 * @Date 2017-11-21 16:29:33
 */
 
 public class Xgt_goods_store_billWarpper extends BaseControllerWarpper{
 		public Xgt_goods_store_billWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
			DictController dictController = SpringContextHolder.getBean(DictController.class);
			List<Map<String, Object>> inStoreStList=dictController.inStoreStList();
			Integer inStoreStId= (Integer) map.get("aud_st_id");
			for (Map inStoreStMap:inStoreStList){
				if (inStoreStMap.get("num")==inStoreStId){
					map.put("aud_st_id",inStoreStMap.get("name"));
				}
			}
			/**
			 * 根据企业信息ID显示其名称
			 */
			Xyd_cpnController xyd_cpnController = SpringContextHolder.getBean(Xyd_cpnController.class);
			List<Map<String, Object>> cpnList = xyd_cpnController.cpnList();
			Integer cpnPId = (Integer) map.get("cpn_id");
			for(Map cpnsMap : cpnList) {
				if(cpnsMap.get("cpn_id").equals(cpnPId)) {
					map.put("cpn_id", cpnsMap.get("cpn_nm"));
				}
			}
			/**
			 * 根据分支机构ID显示其名称
			 */
			Xyd_cpn_branchController xyd_cpn_branchController = SpringContextHolder.getBean(Xyd_cpn_branchController.class);
			List<Map<String, Object>> cpnBranchList = xyd_cpn_branchController.cpnBranchs();
			Integer cpnBranchId = (Integer) map.get("cpn_branch_id");
			for(Map cpnBranchMap : cpnBranchList) {
				if(cpnBranchMap.get("cpn_branch_id").equals(cpnBranchId)) {
					map.put("cpn_branch_id", cpnBranchMap.get("cpn_branch_nm"));
				}
			}
			/**
			 * 根据企业仓库ID显示其名称
			 */
			Xyd_cpn_storeController xyd_cpn_storeController=SpringContextHolder.getBean(Xyd_cpn_storeController.class);
			List<Map<String, Object>> cpnStoreList=xyd_cpn_storeController.cpnStoreList();
			Integer cpnStoreId=(Integer)map.get("cpn_store_id");
			for(Map cpnStoreMap:cpnStoreList){
				if (cpnStoreMap.get("cpn_store_id").equals(cpnStoreId)){
					map.put("cpn_store_id",cpnStoreMap.get("cpn_store_nm"));
				}
			}
			/**
			 * 根据操作类型ID显示其名称
			 */
			DictController dictController3 = SpringContextHolder.getBean(DictController.class);
			List<Map<String, Object>>inList =dictController3.inList();
			Integer inListId=(Integer) map.get("st_id");
			for (Map inListMap:inList){
				if (inListMap.get("num")==inListId){
					map.put("st_id",inListMap.get("name"));
				}
			}
			/**
			 * 根据入库单类型ID显示其名称
			 */
			DictController dictController2 = SpringContextHolder.getBean(DictController.class);
			List<Map<String, Object>>inTypeStList=dictController2.inTypeStList();
			Integer inTypeStId=(Integer)map.get("in_bill_type");
			for (Map inTypeStMap:inTypeStList){
				if (inTypeStMap.get("num")==inTypeStId){
					map.put("in_bill_type",inTypeStMap.get("name"));
				}
			}
 		}
 }