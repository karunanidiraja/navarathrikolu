package com.nacreav.navarathrikolu.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
public class SessionInterceptor extends InterceptorSupport implements Interceptor {

	private static final long serialVersionUID = 4396445890205294360L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionInterceptor.class);
		
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		onInit(actionInvocation);
		LOGGER.info("Enter");
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		LOGGER.info(" User Id - {}", (String)session.get("UserId"));
		String result = session.get("UserId") == null ? "redirectLogout" : actionInvocation.invoke() ;
		onResponse(actionInvocation);
		LOGGER.info("Exit");
		onDestroy(actionInvocation);
		return result;
	}

	public void destroy() { }

	public void init() { }
} 
