package com.nacreav.navarathrikolu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nacreav.navarathrikolu.bean.StockBean;
import com.nacreav.navarathrikolu.dao.StockDAO;

public class StockDAOImpl extends DBConnectionSupport implements StockDAO {
	public List<Map<String, Object>> getProducts() {
		JdbcTemplate template = getJdbcTemplate();
		List<Map<String, Object>> results = template.queryForList(getQuery("GET_PRODUCT_MASTER_LIST"));
		
		return results;
	}
	
	public void editProduct(StockBean bean) {
		NamedParameterJdbcTemplate template = getNamedParameterJdbcTemplate();
		Map<String, Object> result = template.queryForMap(getQuery("GET_PRODUCT_MASTER"), new BeanPropertySqlParameterSource(bean));
		
		bean.setProductName(result.get("PRODUCT_NAME")==null?"":result.get("PRODUCT_NAME").toString());
		bean.setProductDesc(result.get("PRODUCT_DESC")==null?"":result.get("PRODUCT_DESC").toString());
		bean.setProductAddtDesc(result.get("ADDITIONAL_DESC")==null?"":result.get("ADDITIONAL_DESC").toString());
		bean.setInvPrice(result.get("PRODUCT_AMOUNT")==null?"":result.get("PRODUCT_AMOUNT").toString());
		bean.setMinSalePrice(result.get("WHOLE_SALE_VALUE")==null?"":result.get("WHOLE_SALE_VALUE").toString());
		bean.setRetailPrice(result.get("RETAIL_VALUE")==null?"":result.get("RETAIL_VALUE").toString());
		
		bean.setManufacturingType(result.get("MANUFACTURING_TYPE")==null?"":result.get("MANUFACTURING_TYPE").toString());
		bean.setStockType(result.get("STOCK_TYPE")==null?"":result.get("STOCK_TYPE").toString());
		bean.setStockLoc(result.get("STOCK_LOC")==null?"":result.get("STOCK_LOC").toString());
		bean.setMakerName(result.get("MAKER_NAME")==null?"":result.get("MAKER_NAME").toString());
		bean.setMakerLoc(result.get("MAKER_LOC")==null?"":result.get("MAKER_LOC").toString());
		bean.setProductYear(result.get("PRODUCT_YEAR")==null?"":result.get("PRODUCT_YEAR").toString());
		bean.setProductYearPrice(result.get("PRODUCT_YEAR_PRICE")==null?"":result.get("PRODUCT_YEAR_PRICE").toString());
		
		bean.setProductType(result.get("PRODUCT_TYPE")==null?"":result.get("PRODUCT_TYPE").toString());
		bean.setProductDim(result.get("PRODUCT_DIM")==null?"":result.get("PRODUCT_DIM").toString());
		bean.setShippingWeight(result.get("SHIPPING_WEIGHT")==null?"":result.get("SHIPPING_WEIGHT").toString());
		
		
		bean.setQuantity(result.get("QUANTITY")==null?"":result.get("QUANTITY").toString());
		bean.setDamagedCnt(result.get("DAMAGED_CNT")==null?"":result.get("DAMAGED_CNT").toString());
	}
	
	public void editProductDtl(StockBean bean) {
		bean.setProductDtlName(new ArrayList<>());
		bean.setProductDtlDesc(new ArrayList<>());
		bean.setProductDtlDim(new ArrayList<>());
		bean.setProductDtlWeight(new ArrayList<>());
		

		NamedParameterJdbcTemplate template = getNamedParameterJdbcTemplate();
		List<Map<String, Object>> results = template.queryForList(getQuery("GET_PRODUCT_MASTER_DTL"), new BeanPropertySqlParameterSource(bean));
		
		for(Map<String, Object> result : results) {
			bean.getProductDtlName().add(result.get("PRODUCT_DTL_NAME")==null?"":result.get("PRODUCT_DTL_NAME").toString());
			bean.getProductDtlDesc().add(result.get("PRODUCT_DTL_DESC")==null?"":result.get("PRODUCT_DTL_DESC").toString());
			bean.getProductDtlDim().add(result.get("PRODUCT_DTL_DIM")==null?"":result.get("PRODUCT_DTL_DIM").toString());
			bean.getProductDtlWeight().add(result.get("PRODUCT_DTL_WEIGHT")==null?"":result.get("PRODUCT_DTL_WEIGHT").toString());
			
		}
	}
	
	public void updateProduct(StockBean bean, int productDtlCnt) {
		String sql = getQuery("INS_PRODUCT_MASTER");
		String amendId = "0";
		String sold = "0";
		if(StringUtils.isBlank(bean.getProductId())) {
			//bean.setProductId(getProductId());
		} else {
			Map<String, Object> result = getNamedParameterJdbcTemplate().queryForMap(getQuery("GET_PRODUCT_NEW_AMEND_ID"), 
					new BeanPropertySqlParameterSource(bean));
			amendId = result.get("AMEND_ID").toString();
			sold = result.get("SOLD_CNT").toString();
		}
		
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) new ObjectMapper().convertValue(bean, new TypeReference<Map<String, Object>>(){});
		params.put("status", "Y");
		params.put("amendId", amendId);
		params.put("sold", sold);
		params.put("productDtlCnt", productDtlCnt);
		
		getNamedParameterJdbcTemplate().update(sql, params);
	}
	
	public int updateProductDtl(StockBean bean) {
		if(StringUtils.isBlank(bean.getProductId())) {
			bean.setProductId(getProductId());
		}
		String sql = getQuery("INS_PRODUCT_DTL_MASTER");
		int result = 0;
		Object[] args = new String[7];
		args[0] = bean.getProductId();
		args[6] = getProductDtlAmendId(bean.getProductId());
		
		for(int i=0, j=1 ; i<bean.getProductDtlName().size() ; i++) {
			if(StringUtils.isNotBlank(bean.getProductDtlName().get(i))) {
				args[1] = "PD" + j++;
				args[2] = bean.getProductDtlName().get(i);
				args[3] = bean.getProductDtlDesc().get(i);
				args[4] = bean.getProductDtlDim().get(i);
				args[5] = bean.getProductDtlWeight().get(i);

				result = getJdbcTemplate().update(sql, args);
				
			}
		}
		return result;
	}
	
	public void deleteProduct(StockBean bean) {
		String sql1 = getQuery("GET_PRODUCT_MAX_AMEND_ID");
		String sql2 = getQuery("UPD_PRODUCT_MASTER_STATUS");
		
		JdbcTemplate template = getJdbcTemplate();
		String amendId = template.queryForObject(sql1, new Object[]{bean.getProductId()}, String.class);
		
		template.update(sql2, new Object[]{bean.getProductId(), amendId});
	}
	
	private String getProductId() {
		return  getJdbcTemplate().queryForObject("select sequence(?)",new Object[]{"product_id"}, String.class);
	}
	
	private String getProductDtlAmendId(String productId) {
		return  getJdbcTemplate().queryForObject("SELECT IFNULL(MAX(pdm.AMEND_ID)+1,0) FROM product_dtls_master pdm WHERE pdm.product_id=?",new Object[]{productId}, String.class);
	}

}
