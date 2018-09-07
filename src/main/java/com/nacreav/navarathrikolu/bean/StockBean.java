package com.nacreav.navarathrikolu.bean;

import java.util.List;

public class StockBean {
	private String productId;
	private String productName;
	private String productDesc;
	private String productAddtDesc;
	private String invPrice;
	private String minSalePrice;
	private String retailPrice;
	private String quantity;
	private String damagedCnt;
	
	private String ajaxReqFrom;
	private String rowNum;
	
	private List<String> productDtlName;
	private List<String> productDtlDesc;
	private List<String> productDtlDim;
	private List<String> productDtlType;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductAddtDesc() {
		return productAddtDesc;
	}
	public void setProductAddtDesc(String productAddtDesc) {
		this.productAddtDesc = productAddtDesc;
	}
	public String getInvPrice() {
		return invPrice;
	}
	public void setInvPrice(String invPrice) {
		this.invPrice = invPrice;
	}
	public String getMinSalePrice() {
		return minSalePrice;
	}
	public void setMinSalePrice(String minSalePrice) {
		this.minSalePrice = minSalePrice;
	}
	public String getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}
	public List<String> getProductDtlName() {
		return productDtlName;
	}
	public void setProductDtlName(List<String> productDtlName) {
		this.productDtlName = productDtlName;
	}
	public List<String> getProductDtlDesc() {
		return productDtlDesc;
	}
	public void setProductDtlDesc(List<String> productDtlDesc) {
		this.productDtlDesc = productDtlDesc;
	}
	public List<String> getProductDtlDim() {
		return productDtlDim;
	}
	public void setProductDtlDim(List<String> productDtlDim) {
		this.productDtlDim = productDtlDim;
	}
	public List<String> getProductDtlType() {
		return productDtlType;
	}
	public void setProductDtlType(List<String> productDtlType) {
		this.productDtlType = productDtlType;
	}
	public String getAjaxReqFrom() {
		return ajaxReqFrom;
	}
	public void setAjaxReqFrom(String ajaxReqFrom) {
		this.ajaxReqFrom = ajaxReqFrom;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDamagedCnt() {
		return damagedCnt;
	}
	public void setDamagedCnt(String damagedCnt) {
		this.damagedCnt = damagedCnt;
	}
	
}
