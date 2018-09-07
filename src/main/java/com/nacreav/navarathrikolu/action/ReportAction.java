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

@Namespace("/reports")
@ParentPackage("appIntercept")
@InterceptorRef(value="sessionCheckStack")
@Results({
	@Result(name = ActionSupport.SUCCESS, type = "tiles", location = "reportsView")
})
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 8872901242983053337L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportAction.class);
	
	@Action(value="view")
	public String view() {
		LOGGER.info("Enter");
		LOGGER.info("Exit");
		return SUCCESS;
	}

}
