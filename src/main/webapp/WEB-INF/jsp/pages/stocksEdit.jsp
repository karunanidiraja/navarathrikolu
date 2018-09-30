<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form name="form1" id="form1">
	<div class="col s12">
		<div class="card">
			<div class="card-content">
				<div class="row center">
					<h4 class="materialize-red-text">Product</h4>
				</div>
				<div class="row">
					<div class="col s12">
						<div class="row">
							<div class="input-field col s6">
								<s:textfield  placeholder="Product Name" name="productName" id="productName"/>
								<label for="productName">Product Name</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Product Description" name="productDesc" id="productDesc"/>
								<label for="productDesc">Product Description</label>
							</div>
							<div class="input-field col s6">
								<s:select name="productType" id="productType" list="#{'CLAY':'CLAY', 'PAPERMACHE':'PAPERMACHE'}" />
								<label for="productType">Product Material</label>
							</div>
							<div class="input-field col s6">
								<s:select name="manufacturingType" id="manufacturingType" list="#{'OWN':'OWN', 'OTHERS':'OTHERS'}" />
								<label for="manufacturingType">Manufacturing Type</label>
							</div>
							<div class="input-field col s6">
								<s:select name="stockType" id="stockType" list="#{'NEW':'NEW', 'EXISTING':'EXISTING'}" />
								<label for="stockType">Stock Type</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Product Size" name="productDim" id="productDim"/>
								<label for="productDim">Product Size (Inch)</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Shipping Weight" name="shippingWeight" id="shippingWeight"/>
								<label for="shippingWeight">Shipping Weight</label>
							</div>
							<div class="input-field col s6">
								<s:select name="stockLoc" id="stockLoc" list="#{'SHOP':'SHOP', 'ROOM1':'GODOWN - ROOM1', 'ROOM2':'GODOWN - ROOM2'}" />
								<label for="stockLoc">Stock Location</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Maker Name" name="makerName" id="makerName"/>
								<label for="makerName">Maker Name</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Maker Location" name="makerLoc" id="makerLoc"/>
								<label for="makerLoc">Maker Location</label>
							</div>
							
							<div class="input-field col s6">
								<s:textfield  placeholder="Inv. Price" name="invPrice" id="invPrice" type="number"/>
								<label for="invPrice">Investment Price</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Minimum Sale Price" name="minSalePrice" id="minSalePrice" type="number"/>
								<label for="minSalePrice">Minimum Sale Price</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Retial Price" name="retailPrice" id="retailPrice" type="number"/>
								<label for="retailPrice">Retail Price</label>
							</div>
							
							<div class="input-field col s6">
								<s:select name="productYear" id="productYear" list="@com.nacreav.navarathrikolu.util.ConstantList@getYearList()" />
								<label for="productYear">Product Make Year</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Product Year Price" name="productYearPrice" id="productYearPrice" type="number"/>
								<label for="productYearPrice">Product Year Price</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Quantity" name="quantity" id="quantity" type="number"/>
								<label for="quantity">Quantity</label>
							</div>
							<div class="input-field col s6">
								<s:textfield  placeholder="Damaged" name="damagedCnt" id="damagedCnt" type="number"/>
								<label for="damagedCnt">Damaged</label>
							</div>
							
							<div class="input-field col s12">
								<s:textarea  placeholder="Product Story" name="productAddtDesc" id="productAddtDesc"
								class="materialize-textarea" data-length="500" maxLength="500"/>
								<label for="productAddtDesc">Product Story</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col s12">
		<div class="card">
			<div class="card-content">
				<div class="row" align="center">
					<h4 class="materialize-red-text">Product Detail</h4>
				</div>
				<div id="productDtls">
					<s:set var="tempRowNum" value="0"/>
					<s:iterator begin="1" end="%{(productDtlName==null||productDtlName.size()==0)?1:productDtlName.size()}" status="stat" >
						<%-- maintained in 2 places (this jsp and commonajax) --%>
						<div id="row${tempRowNum}">
							<div class="row">
								<div class="input-field col s1 center">${tempRowNum+1}</div>
								<div class="input-field col s3">
									<s:textfield  placeholder="Doll Name" name="productDtlName[%{#tempRowNum}]" id="productDtlName[%{#tempRowNum}]"/>
									<label for="productDtlName">Doll Name</label>
								</div>
								<div class="input-field col s3">
									<s:textfield  placeholder="Doll Description" name="productDtlDesc[%{#tempRowNum}]" id="productDtlDesc[%{#tempRowNum}]"/>
									<label for="productDtlDesc">Doll Description</label>
								</div>
								<div class="input-field col s2">
									<s:textfield  placeholder="Doll Dimentions" name="productDtlDim[%{#tempRowNum}]" id="productDtlDim[%{#tempRowNum}]"/>
									<label for="productDtlDim">Doll Dim (Inch)</label>
								</div>
								<div class="input-field col s2">
									<s:textfield  placeholder="Doll Weight" name="productDtlWeight[%{#tempRowNum}]" id="productDtlWeight[%{#tempRowNum}]"/>
									<label for="productDtlWeight">Doll Weight</label>
								</div>
								<div class="input-field col s1">
									<a class="btn waves-effect waves-light orange" onclick="removeRow('${tempRowNum}')">
										<i class="material-icons">delete_forever</i>
									</a>
								</div>
							</div>
						</div>
						<s:set var="tempRowNum" value="#tempRowNum+1"/>
					</s:iterator>
				</div>
				<div class="row" align="right">
					<a class="btn waves-effect waves-light blue" onclick="addRow();">Add More
						<i class="material-icons left">add</i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col s12">
		<div class="card">
			<div class="card-content" align="center">
				<button class="btn waves-effect waves-light red" type="button" onclick="fnlink('/stocks/view')">Back
					<i class="material-icons left">backspace</i>
				</button>
				<button class="btn waves-effect waves-light" type="button" onclick="submitStock()">Submit<!--  onclick="fnsubmit('form1', '/stocks/submit')" -->
					<i class="material-icons right">send</i>
				</button>
			</div>
		</div>
	</div>
	<s:hidden name="tempRowNum" id="tempRowNum" value="%{#tempRowNum}"/>
	
	<s:hidden name="productId" />
</s:form>
<script type="text/javascript">
var rowNum= <s:property value="#tempRowNum"/>;
function addRow() {
	$('#productDtls').append($('<div id="row'+ rowNum +'">loading...</div>'));
	ajaxCallInModal('row'+ rowNum, '${pageContext.request.contextPath}/stocks/commonAjax?ajaxReqFrom=addProductDtlRow&rowNum=' + rowNum)
	rowNum++;
}

function removeRow(rowId) {
	$('#row' + rowId).remove();
}

function submitStock() {
	ajaxFormSubmitInModal('form1', 'modalContent', '${pageContext.request.contextPath}/stocks/submit');
}
</script>