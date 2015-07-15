package com.zhanhong.wcs.context;

import java.util.Set;

import javax.servlet.http.HttpSession;

/**
 * Web会话上下文接口
 * @author Arvin_Li
 *
 */
public interface WebSessionContext<T> {
	//会话属性KEY
	public static final String sessionAttributeKey="wcs_session_key";
	
	/**
	 * 设置HttpSession
	 * @param httpSession
	 */
	public void setHttpSession(HttpSession httpSession);
	
	/**
	 * 获取HttpSession
	 * @return
	 */
	public HttpSession getHttpSession();
	
	/**
	 * 使会话失效
	 */
	public void invalidateSession();
	
	/**
	 * 设置参数
	 * @param name 参数名
	 * @param value 值
	 */
	public void setAttribute(String name,T value);
	
	/**
	 * 根据参数名获取参数
	 * @param name 参数名
	 * @return 返回参数值
	 */
	public T getAttribute(String name);
	
	/**
	 * 获取所有参数名
	 * @return
	 */
	public Set<String> getAttributes();
	
	/**
	 * 根据参数名删除参数
	 * @param name
	 */
	public void removeAttribute(String name);
	
	/**
	 * 销毁会话
	 */
	public void destory();
}
