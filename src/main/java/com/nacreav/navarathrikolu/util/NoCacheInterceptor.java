package com.nacreav.navarathrikolu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class NoCacheInterceptor extends InterceptorSupport implements Interceptor {
	private static final long serialVersionUID = 5262496830034093717L;
	private static final Logger LOGGER = LoggerFactory.getLogger(NoCacheInterceptor.class);

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		onInit(actionInvocation);
		LOGGER.info("Enter");
		String result = actionInvocation.invoke();
		onResponse(actionInvocation);
		LOGGER.info("Exit");
		onDestroy(actionInvocation);
		return result;
	}

	@Override
	public void destroy() { }

	@Override
	public void init() { }
}

