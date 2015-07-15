package com.zhanhong.wcs.tools;
import java.util.List;
import com.alibaba.fastjson.JSONObject;

/**
 * Json消息工具类
 * @author Arvin_Li
 *
 */
public class JsonMessageUtil {
	private JsonMessageUtil(){}
	
	/**
	 * 成功消息
	 * @param message
	 * @return
	 */
	public static String successMessage(String message){
		return "{\"result\":1,\"message\":\""+message+"\"}";
	}
	
	/**
	 * 错误消息
	 * @param message 
	 * @return
	 */
	public static String errorMessaage(String message){
		return "{\"result\":0,\"message\":\""+message+"\"}";
	}
	
	/**
	 * 对象JSON消息
	 * @param obj
	 * @return
	 */
	public static String objectMessage(Object obj){
		if(null==obj){
			return errorMessaage("Object is not null!");
		}
		return successMessage(JSONObject.toJSONString(obj));
	}
	/**
	 * 集合JSON消息
	 * @param list
	 * @return
	 */
	public static String listMessage(List list){
		if(list.size()<=0){
			return errorMessaage("List is not null!");
		}
		return successMessage(JSONObject.toJSONString(list));
	}

}
