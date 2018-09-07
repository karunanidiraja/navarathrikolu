package com.nacreav.navarathrikolu.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nacreav.navarathrikolu.bean.StockBean;
import com.nacreav.navarathrikolu.service.StockService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/stocks")
@ParentPackage("appIntercept")
@InterceptorRef(value="sessionCheckStack")
@Results({
	@Result(name = ActionSupport.SUCCESS, type = "tiles", location = "stocksView"),
	@Result(name = ActionSupport.INPUT, type = "tiles", location = "stocksEdit"),
	@Result(name = stockAction.COMMON_AJAX, type = "tiles", location = stockAction.COMMON_AJAX),
	@Result(name = stockAction.REDIRECT_SUCCESS, type = "redirect", location = stockAction.REDIRECT_SUCCESS)
})
public class stockAction extends ActionSupport implements ModelDriven<StockBean> {

	private static final long serialVersionUID = -820756069770913805L;
	private static final Logger LOGGER = LoggerFactory.getLogger(stockAction.class);
	static final String COMMON_AJAX = "commonAjax";
	static final String REDIRECT_SUCCESS = "/stocks/view";
	
	private StockService service = new StockService();
	private StockBean bean = new StockBean();
	
	@Action(value="view")
	public String view() {
		LOGGER.info("Enter");
		LOGGER.info("Exit");
		return SUCCESS;
	}
	
	@Action(value="edit")
	public String edit() {
		LOGGER.info("Enter");
		if(StringUtils.isNotBlank(bean.getProductId())) {
			service.editProduct(bean);
			service.editProductDtl(bean);
		}
		LOGGER.info("Exit");
		return INPUT;
	}
		
	@Action(value="submit")
	public String submit() {
		LOGGER.info("Enter");
		service.updateProduct(bean);
		edit();
		LOGGER.info("Exit");
		return INPUT;
	}
	
	@Action(value="delete")
	public String delete() {
		LOGGER.info("Enter");
		service.deleteProduct(bean);
		LOGGER.info("Exit");
		return REDIRECT_SUCCESS;
	}
	
	@Action(value="commonAjax")
	public String commonAjax() {
		LOGGER.info("Enter");
		LOGGER.info("Exit");
		return COMMON_AJAX;
	}

	@Override
	public StockBean getModel() {
		return bean;
	}
	
	@JSON(serialize=false)
	public List<Map<String, Object>> getProductsList() {
		return service.getProducts();
	}
	

}
