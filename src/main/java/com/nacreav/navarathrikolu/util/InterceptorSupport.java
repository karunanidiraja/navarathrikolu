package com.nacreav.navarathrikolu.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public abstract class InterceptorSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterceptorSupport.class);
	protected String sessionId;
	
	protected void onInit(ActionInvocation actionInvocation) {
		String tracingId = UUID.randomUUID().toString();
		MDC.put("tracingId", tracingId);

		ActionContext context = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
		HttpSession session = request.getSession();
		sessionId = session.getId();
		MDC.put("sessionId", sessionId);
	}
	
	protected void onResponse(ActionInvocation actionInvocation) {
		ActionContext context = actionInvocation.getInvocationContext();
		HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
		LOGGER.info("response status={}", response!=null);
		if(response!=null) {
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
			response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionId + "; HttpOnly");
			response.setHeader("X-Frame-Options", "deny");
		}
	}
	
	protected void onDestroy(ActionInvocation actionInvocation) {
		MDC.remove("tracingId");
		MDC.remove("sessionId");
	}
}
