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

@Namespace("/invoice")
@ParentPackage("appIntercept")
@InterceptorRef(value="sessionCheckStack")
@Results({
	@Result(name = ActionSupport.SUCCESS, type = "tiles", location = "reportsView")
})
public class InvoiceAction extends ActionSupport {
	
	private static final long serialVersionUID = 1005070568077461481L;
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceAction.class);
	
	@Action(value="init")
	public String init() {
		LOGGER.info("Enter");
		LOGGER.info("Exit");
		return SUCCESS;
	}
}
