package com.nacreav.navarathrikolu.dao;

import java.util.List;
import java.util.Map;

import com.nacreav.navarathrikolu.bean.StockBean;

public interface StockDAO {
	List<Map<String, Object>> getProducts();
	void editProduct(StockBean bean);
	void editProductDtl(StockBean bean);
	void updateProduct(StockBean bean);
	void updateProductDtl(StockBean bean);
	void deleteProduct(StockBean bean);
}
