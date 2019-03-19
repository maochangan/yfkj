package cn.yfkj.wxapp.utils.project;

import java.util.HashMap;

public class ResultMap extends HashMap<String, Object>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ResultMap createMap(String msg , Integer code) {
		ResultMap result = new ResultMap();
		result.put("code", code);
		result.put("msg" , msg);
		return result;
	}
	
	public ResultMap addDate(Object value) {
		this.put("data", value);
		return this;
	}
	
}
