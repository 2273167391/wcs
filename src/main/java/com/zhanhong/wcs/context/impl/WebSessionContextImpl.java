package com.zhanhong.wcs.context.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.zhanhong.wcs.context.WebSessionContext;

/**
 * Web上下文会话实现类
 * @author Arvin_Li
 *
 */
public class WebSessionContextImpl<T> implements WebSessionContext<T> {
	
	private HttpSession httpSession;
	private Map<String, T> attribute;

	/**
	 * 设置HttpSession
	 */
	@Override
	public void setHttpSession(HttpSession httpSession) {
		this.httpSession=httpSession;
		//从会话中获取attribute
		this.attribute=(Map<String, T>) this.httpSession.getAttribute(sessionAttributeKey);
		if(null==this.attribute){
			this.attribute=new HashMap<String, T>();
			this.onSaveSessionAttribute();
		}
	}

	/**
	 * 获取HttpSession
	 * @return
	 */
	@Override
	public HttpSession getHttpSession() {
		return this.httpSession;
	}

	/**
	 * 使当前会话无效
	 */
	@Override
	public void invalidateSession() {
		this.httpSession.invalidate();
	}

	/**
	 * 设置属性
	 * @param name
	 * @param value
	 */
	@Override
	public void setAttribute(String name, T value) {
		if(null!=this.attribute){
			this.attribute.put(name, value);
			this.onSaveSessionAttribute();
		}
	}

	/**
	 * 获取属性值
	 * @param name 属性名称
	 * @return
	 */
	@Override
	public T getAttribute(String name) {
		if(null!=this.attribute){
			return this.attribute.get(name);
		}
		return null;
	}

	/**
	 * 获取所有属性名
	 * @return
	 */
	@Override
	public Set<String> getAttributes() {
		return this.attribute.keySet();
	}

	/**
	 * 删除属性
	 * @param name
	 */
	@Override
	public void removeAttribute(String name) {
		if(null!=this.attribute){
			this.attribute.remove(name);
		}
	}

	/**
	 * 销毁会话
	 */
	@Override
	public void destory() {
		this.attribute=null;
		this.httpSession=null;
	}
	
	/**
	 * 保存会话属性
	 */
	public void onSaveSessionAttribute(){
		//将属性保存到会话中
		this.httpSession.setAttribute(sessionAttributeKey, attribute);
	}

}
