package com.nacreav.navarathrikolu.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("appIntercept")
@InterceptorRef(value="sessionCheckStack")
@Results({
	@Result(name = ActionSupport.SUCCESS, type = "tiles", location = "dashboard")
})
public class HomeAction extends ActionSupport {
	
	private static final long serialVersionUID = 7552639685144493540L;
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeAction.class);
	
	@Action(value="dashboard")
	public String dashboard() {
		LOGGER.info("Enter");
		LOGGER.info("Exit");
		return SUCCESS;
	}
	
}
