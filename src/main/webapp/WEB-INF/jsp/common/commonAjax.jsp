<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test='"addProductDtlRow".equalsIgnoreCase(ajaxReqFrom)'>
	<div class="row">
		<div class="input-field col s1 center">${rowNum+1}</div>
		<div class="input-field col s3">
			<s:textfield  placeholder="Doll Name" name="productDtlName[%{rowNum}]" id="productDtlName[%{rowNum}]"/>
			<label for="productDtlName">Doll Name</label>
		</div>
		<div class="input-field col s3">
			<s:textfield  placeholder="Doll Description" name="productDtlDesc[%{rowNum}]" id="productDtlDesc[%{rowNum}]"/>
			<label for="productDtlDesc">Doll Description</label>
		</div>
		<div class="input-field col s1">
			<s:textfield  placeholder="Doll Dimentions" name="productDtlDim[%{rowNum}]" id="productDtlDim[%{rowNum}]"/>
			<label for="productDtlDim">Doll Dimention</label>
		</div>
		<div class="input-field col s3">
			<s:select name="productDtlType[%{rowNum}]" id="productDtlType[%{rowNum}]" list="#{'1':'Clay', '2':'Papermache'}" />
			<label for="productDtlType">Doll Type</label>
		</div>
		<div class="input-field col s1">
			<a class="btn waves-effect waves-light orange" onclick="removeRow('${rowNum}')">
				<i class="material-icons">delete_forever</i>
			</a>
		</div>
	</div>
</s:if>