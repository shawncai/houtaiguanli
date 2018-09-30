package wy.addons.zcgl.sendChannel.warpper;


import wy.core.base.warpper.BaseControllerWarpper;
import wy.common.constant.factory.ConstantFactory;

import java.util.Map;

/**
 * 配送商warpper接口
 *
 * @author wyframe
 * @Date 2017-07-17 16:44:18
 */
 
 public class Bs_send_channelWarpper extends BaseControllerWarpper{
 		public Bs_send_channelWarpper(Object obj){
 			
 			super(obj);
 		
 		}
 		
 		protected void warpTheMap(Map<String,Object> map){
 				map.put("send_chnl_flg",ConstantFactory.me().getDictName(Integer.parseInt(map.get("send_chnl_flg")+"")));
 		}
 }