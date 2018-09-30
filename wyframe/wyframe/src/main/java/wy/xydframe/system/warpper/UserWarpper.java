package wy.xydframe.system.warpper;

import wy.core.base.warpper.BaseControllerWarpper;
import wy.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的包装类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:47:03
 */
public class UserWarpper extends BaseControllerWarpper {

    public UserWarpper(List<Map<String, Object>> list) {
        super(list);
        System.err.println(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	map.put("handle", "<button class='button button-highlight button-box button-giant button-longshadow-right button-longshadow-expand' onclick='MgrUser.roleAssign()' title='角色分配'><i class='fa fa-share-alt'></i></button>"
    			+ "<button class='button button-highlight button-box button-giant button-longshadow-right button-longshadow-expand' onclick='MgrUser.areaAssign()' title='区域选择'><i class='fa fa-gear'></i></button>");
    	
        map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
        map.put("roleName", ConstantFactory.me().getRoleName((String) map.get("roleid")));
        map.put("statusName", ConstantFactory.me().getStatusName((Integer) map.get("status")));

    }

}
