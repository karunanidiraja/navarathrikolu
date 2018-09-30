package com.nacreav.navarathrikolu.service;

import java.util.List;
import java.util.Map;

import com.nacreav.navarathrikolu.bean.StockBean;
import com.nacreav.navarathrikolu.dao.StockDAO;
import com.nacreav.navarathrikolu.dao.impl.StockDAOImpl;

public class StockService {
	
	private StockDAO dao = new StockDAOImpl();
	
	public List<Map<String, Object>> getProducts() {
		return dao.getProducts();
	}
	
	public void editProduct(StockBean bean) {
		dao.editProduct(bean);
	}
	
	public void editProductDtl(StockBean bean) {
		dao.editProductDtl(bean);
	}
	
	public void updateProduct(StockBean bean) {
		dao.updateProduct(bean);
	}
	
	public void deleteProduct(StockBean bean) {
		dao.deleteProduct(bean);
	}
	
}
