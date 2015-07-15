package com.zhanhong.wcs.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zhanhong.wcs.context.ThreadContextHolder;
import com.zhanhong.wcs.context.impl.WebSessionContextImpl;
import com.zhanhong.wcs.entity.sys.WcsSysEmployee;
import com.zhanhong.wcs.tools.CommonParam;

public class DispatcherFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取HttpServletRequest
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		//获取HttpServletResponse
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		//获取HttpSession
		HttpSession httpSession=httpRequest.getSession();
		//创建上下文对象
		WebSessionContextImpl sessionContext=new WebSessionContextImpl();
		sessionContext.setHttpSession(httpSession);
		//设置到本地线程中
		ThreadContextHolder.setHttpRequest(httpRequest);
		ThreadContextHolder.setHttpResponse(httpResponse);
		ThreadContextHolder.setSessionContext(sessionContext);
		//获取请求路径
		String path=httpRequest.getServletPath();
		if((!path.startsWith("/login"))&&(!path.startsWith("/resources"))&&(!path.startsWith("/index"))){
			//获取当前用户
			WcsSysEmployee employee=(WcsSysEmployee) ThreadContextHolder.getSessionContext().getAttribute(CommonParam.CURRENT_USER);
			if(null==employee){
				PrintWriter out=httpResponse.getWriter();
				out.println("<script>location.href='"+httpRequest.getContextPath()+"/index.html'</script>");
				out.flush();
				out.close();
				return;
			}
		}
		//交个下一个过滤器
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public static void main(String[] args) {
		System.out.println("index.html".startsWith("index"));
	}

}
