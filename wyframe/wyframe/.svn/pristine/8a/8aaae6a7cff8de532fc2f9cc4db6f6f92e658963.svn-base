package wy.addons.zcgl.xydwx.util;

import java.util.Arrays;

import wy.addons.zcgl.gongzhonghao.controller.Wx_mainController;

/**
 * 检查token
 * @author wyframe
 *
 */
public class CheckUtil {
	private static final String token=Wx_mainController.TOKEN;
	public static Boolean checkSignature(String signature,String timeStamp,String nonce){
		String[] arr = new String[]{token,timeStamp,nonce};
		Arrays.sort(arr);
		
		StringBuffer content = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		//Sha1加密
		String temp = Sha1.getSha1(content.toString());
		
		return temp.equals(signature);
	}
}
