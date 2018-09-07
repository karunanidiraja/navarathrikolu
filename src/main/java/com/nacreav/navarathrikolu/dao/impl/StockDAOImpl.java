package com.nacreav.navarathrikolu.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nacreav.navarathrikolu.bean.StockBean;
import com.nacreav.navarathrikolu.dao.StockDAO;

public class StockDAOImpl implements StockDAO {
	public List<Map<String, Object>> getProducts() {
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		List<Map<String, Object>> results = template.queryForList("SELECT * FROM product_master pm WHERE status='Y' and AMEND_ID=(SELECT MAX(pm1.amend_id) FROM product_master pm1 WHERE pm.product_id=pm1.product_id)");
		
		return results;
	}
	
	public void editProduct(StockBean bean) {
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		Map<String, Object> result = template.queryForMap("SELECT * FROM product_master pm WHERE pm.product_id=? and pm.AMEND_ID=(SELECT MAX(pm1.amend_id) FROM product_master pm1 WHERE pm.product_id=pm1.product_id)", new Object[]{bean.getProductId()});
		
		bean.setProductName(result.get("PRODUCT_NAME")==null?"":result.get("PRODUCT_NAME").toString());
		bean.setProductDesc(result.get("PRODUCT_DESC")==null?"":result.get("PRODUCT_DESC").toString());
		bean.setProductAddtDesc(result.get("ADDITIONAL_DESC")==null?"":result.get("ADDITIONAL_DESC").toString());
		bean.setInvPrice(result.get("PRODUCT_AMOUNT")==null?"":result.get("PRODUCT_AMOUNT").toString());
		bean.setMinSalePrice(result.get("WHOLE_SALE_VALUE")==null?"":result.get("WHOLE_SALE_VALUE").toString());
		bean.setRetailPrice(result.get("RETAIL_VALUE")==null?"":result.get("RETAIL_VALUE").toString());
		
		bean.setQuantity(result.get("QUANTITY")==null?"":result.get("QUANTITY").toString());
		bean.setDamagedCnt(result.get("DAMAGED_CNT")==null?"":result.get("DAMAGED_CNT").toString());
	}
	
	public void editProductDtl(StockBean bean) {
		bean.setProductDtlName(new ArrayList<>());
		bean.setProductDtlDesc(new ArrayList<>());
		bean.setProductDtlDim(new ArrayList<>());
		bean.setProductDtlType(new ArrayList<>());
		
		
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		List<Map<String, Object>> results = template.queryForList("SELECT * FROM product_dtls_master pdm WHERE pdm.product_id=? AND pdm.amend_id=(SELECT MAX(pdm1.AMEND_ID) FROM product_dtls_master pdm1 WHERE pdm.product_id=pdm1.product_id)", new Object[]{bean.getProductId()});
		
		for(Map<String, Object> result : results) {
			bean.getProductDtlName().add(result.get("PRODUCT_DTL_NAME")==null?"":result.get("PRODUCT_DTL_NAME").toString());
			bean.getProductDtlDesc().add(result.get("PRODUCT_DTL_DESC")==null?"":result.get("PRODUCT_DTL_DESC").toString());
			bean.getProductDtlDim().add(result.get("PRODUCT_DTL_DIM")==null?"":result.get("PRODUCT_DTL_DIM").toString());
			bean.getProductDtlType().add(result.get("PRODUCT_DTL_TYPE")==null?"":result.get("PRODUCT_DTL_TYPE").toString());
		}
	}
	
	public void updateProduct(StockBean bean) {
		String sql = "insert into product_master "
				+ "(PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESC, ADDITIONAL_DESC, PRODUCT_AMOUNT, RETAIL_VALUE, WHOLE_SALE_VALUE, AMEND_ID, APP_ID, CREATED_DT, STATUS, QUANTITY, SOLD_CNT, DAMAGED_CNT) "
				+ "values (?,?,?,?,?,?,?,?,1, SYSDATE(),?,?,?,?)";
		String amendId = "0";
		String sold = "0";
		if(StringUtils.isBlank(bean.getProductId())) {
			bean.setProductId(getProductId());
		} else {
			JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
			Map<String, Object> result = template.queryForMap("SELECT pm.SOLD_CNT, pm.AMEND_ID+1 AMEND_ID FROM product_master pm WHERE pm.product_id=? AND AMEND_ID=(SELECT MAX(pm1.AMEND_ID) FROM product_master pm1 WHERE pm.PRODUCT_ID=pm1.product_id)", 
					new Object[]{bean.getProductId()});
			amendId = result.get("AMEND_ID").toString();
			sold = result.get("SOLD_CNT").toString();
		}
		
		Object[] args = new String[12];
		args[0] = bean.getProductId();
		args[1] = bean.getProductName();
		args[2] = bean.getProductDesc();
		args[3] = bean.getProductAddtDesc();
		args[4] = bean.getInvPrice();
		args[5] = bean.getRetailPrice();
		args[6] = bean.getMinSalePrice();
		args[7] = amendId;
		args[8] = "Y";
		args[9] = bean.getQuantity();
		args[10] = sold;
		args[11] = bean.getDamagedCnt();
		
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		template.update(sql, args);
	}
	
	public void updateProductDtl(StockBean bean) {
		String sql = "INSERT INTO product_dtls_master "
				+ "(PRODUCT_ID, PRODUCT_DTL_ID, PRODUCT_DTL_NAME, PRODUCT_DTL_DESC, PRODUCT_DTL_DIM, PRODUCT_DTL_TYPE, CREATED_DT, AMEND_ID) "
				+ "VALUES "
				+ "(?,?,?,?,?,?,SYSDATE(),?)";
		
		Object[] args = new String[7];
		args[0] = bean.getProductId();
		args[6] = getProductDtlAmendId(bean.getProductId());
		//
		
		for(int i=0, j=1 ; i<bean.getProductDtlName().size() ; i++) {
			if(StringUtils.isNotBlank(bean.getProductDtlName().get(i))) {
				args[1] = "PD" + j++;
				args[2] = bean.getProductDtlName().get(i);
				args[3] = bean.getProductDtlDesc().get(i);
				args[4] = bean.getProductDtlDim().get(i);
				args[5] = bean.getProductDtlType().get(i);
				
				JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
				template.update(sql, args);
				
			}
		}
	}
	
	public void deleteProduct(StockBean bean) {
		String sql1 = "SELECT MAX(pm1.amend_id) FROM product_master pm1 WHERE pm1.product_id=?";
		String sql2 = "UPDATE product_master SET STATUS='N' WHERE product_id=? and amend_id=?";
		
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		String amendId = template.queryForObject(sql1, new Object[]{bean.getProductId()}, String.class);
		
		template.update(sql2, new Object[]{bean.getProductId(), amendId});
	}
	
	private String getProductId() {
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		return template.queryForObject("select sequence(?)",new Object[]{"product_id"}, String.class);
	}
	
	private String getProductDtlAmendId(String productId) {
		JdbcTemplate template = DBConnectionUtil.getInstance().getJdbcTemplate();
		return template.queryForObject("SELECT IFNULL(MAX(pdm.AMEND_ID)+1,0) FROM product_dtls_master pdm WHERE pdm.product_id=?",new Object[]{productId}, String.class);
	}

}
