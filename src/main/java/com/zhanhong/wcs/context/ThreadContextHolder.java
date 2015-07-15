package com.zhanhong.wcs.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhanhong.wcs.context.impl.WebSessionContextImpl;

/**
 * 上下文持有本地线程类
 * @author Arvin_Li
 *
 */
public class ThreadContextHolder {
	private ThreadContextHolder(){}
	
	private static ThreadLocal<WebSessionContext> sessionContextThreadHolder=new ThreadLocal<WebSessionContext>();
	private static ThreadLocal<HttpServletRequest> httpRequestThreadContextHolder=new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> httpResponseThreadContextHolder=new ThreadLocal<HttpServletResponse>();
	
	/**
	 * 将WebSessionContext设置到当前线程中
	 * @param context
	 */
	public static void setSessionContext(WebSessionContext context){
		sessionContextThreadHolder.set(context);
	}
	
	/**
	 * 从当前线程中获取WebSessionContext
	 * @return
	 */
	public static WebSessionContext getSessionContext(){
		if(null==sessionContextThreadHolder){
			sessionContextThreadHolder.set(new WebSessionContextImpl());
		}
		return sessionContextThreadHolder.get();
	}
	
	/**
	 * 从当前线程中销毁WebSessionContext
	 */
	public static void destorySessionContext(){
		WebSessionContext context=sessionContextThreadHolder.get();
		if(null!=context){
			context.destory();
		}
	}
	
	/**
	 * 将HttpServletRequest设置到本地线程
	 * @param httpRequest
	 */
	public static void setHttpRequest(HttpServletRequest httpRequest){
		httpRequestThreadContextHolder.set(httpRequest);
	}
	
	/**
	 * 从本地线程中获取HttpServletRequest
	 * @return
	 */
	public static HttpServletRequest getHttpRequest(){
		return httpRequestThreadContextHolder.get();
	}
	
	/**
	 * 将HttpServletResponse设置到本地线程
	 * @param httpResponse
	 */
	public static void setHttpResponse(HttpServletResponse httpResponse){
		httpResponseThreadContextHolder.set(httpResponse);
	}
	
	/**
	 * 从本地线程中获取HttpServletResponse
	 * @return
	 */
	public static HttpServletResponse getHttpReponse(){
		return httpResponseThreadContextHolder.get();
	}
}
