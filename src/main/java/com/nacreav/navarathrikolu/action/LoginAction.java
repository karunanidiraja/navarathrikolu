package com.nacreav.navarathrikolu.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nacreav.navarathrikolu.bean.LoginBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@ParentPackage("appIntercept")
@InterceptorRef(value="noCacheStack")
@Results({
	@Result(name = ActionSupport.INPUT, type = "tiles", location = "login"),
	@Result(name = ActionSupport.SUCCESS, type = "redirect", location = "/dashboard"/*, params = {"username", "${username}"}*/),
	@Result(name = LoginAction.REDIRECT_LOGIN, type = "redirect", location = "/login")
})
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean> {
	private static final long serialVersionUID = -8996824298109017511L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	public static final String REDIRECT_LOGIN = "LOGIN";

	private final SessionMap<String, Object> session = (SessionMap<String, Object>) ActionContext.getContext().getSession();

	private final LoginBean bean = new LoginBean();

	@Action(value="login")
	public String login() {
		LOGGER.info("Enter");
		logout();
		LOGGER.info("Exit");
		return INPUT;
	}

	@Action(value="loginAttempt")
	public String loginAttempt() {
		String result = INPUT;
		LOGGER.info("Enter");
		validateUser();
		if(!hasFieldErrors() && !hasActionErrors()) {
			session.put("UserId", bean.getUsername());
			result = SUCCESS;
		}
		LOGGER.info("Exit");
		return result;
	}
	
	@Action(value="logout")
	public String logout() {
		LOGGER.info("Enter");
		if(session.get("UserId")!=null) {
			//invalidate
			session.invalidate();
	
			//renew servlet session
			session.put("renewServletSession", null);
			session.remove("renewServletSession");
	
			/*//populate the struts session
			session.entrySet();*/
		}
		LOGGER.info("Exit");
		return REDIRECT_LOGIN;
	}

	@Override
	public LoginBean getModel() {
		return bean;
	}
	
	private void validateUser() {
		if(StringUtils.isBlank(bean.getUsername())) {
			addFieldError("username", getText("login.userName.invalid"));
		}
		if(StringUtils.isBlank(bean.getUserPwd())) {
			addFieldError("userPwd", getText("login.password.invalid"));
		}
		if(!hasFieldErrors() &&
				(!"admin".equalsIgnoreCase(bean.getUsername()) || !"admin".equalsIgnoreCase(bean.getUserPwd()))
		) {
			addActionError(getText("login.invalid"));
		}
	}
}
