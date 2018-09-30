package wy.xydframe.system.warpper;

import wy.core.base.warpper.BaseControllerWarpper;

import java.util.Map;


public class CodeWarpper extends BaseControllerWarpper{

	public CodeWarpper(Object obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void warpTheMap(Map<String, Object> map) {
			map.put("formType", "<select id='"+map.get("columnName")+"'>"
					+ "<option value='1'>input</option>"
					+ "<option value='2'>select</option>"
					+ "<option value='3'>tree</option>"
					+ "</select>");
			
			map.put("dictId","<input id='"+map.get("columnName")+"dictId' style='width:60px'/>");
	}

}
