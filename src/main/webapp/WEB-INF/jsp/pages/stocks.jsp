<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="card">
	<div class="card-content">
		<div class="row center">
			<h4 class="materialize-red-text">Stocks</h4>
		</div>
		<div class="row" align="right">
			<button class="btn waves-effect waves-light" type="button" onclick="editStock('')">Add New
				<i class="material-icons left">add</i>
			</button>
		</div>
		<div class="row">
			<table id="appDataTable" class="display dataTable cell-border nowrap" style="width:100%">
			    <thead>
			        <tr>
			        	<th class="dt-head-center"></th>
			        	<th class="dt-head-center">Product Name</th>
			        	<th class="dt-head-center">Available</th>
			        	<th class="dt-head-center">Sold</th>
			        	<th class="dt-head-center">Damaged</th>
			        	<th class="dt-head-center">Inv. Amount</th>
			        	<th class="dt-head-center"></th>
			        </tr>
			    </thead>
			    <tfoot>
			        <tr>
						<th></th>
						<th class="dt-head-center"> <input type="text" placeholder="Search Product Name" style="width: 90%"/> </th>
						<th class="dt-head-center"> <input type="text" size="4" style="width: 90%"/> </th>
						<th class="dt-head-center"> <input type="text" size="4" style="width: 90%"/> </th>
						<th class="dt-head-center"> <input type="text" size="4" style="width: 90%"/> </th>
						<th class="dt-head-center"> <input type="text" size="10" style="width: 90%"/> </th>
						<th></th>
			        </tr>
			    </tfoot>
			    <tbody>
			    	<s:iterator value="productsList" var="productsVar" status="stat">
				        <tr>
				        	<td>${stat.index+1}</td>
				            <td class="dt-body-center">
					            <button class="btn waves-effect waves-light" type="button" onclick="editStock('${productsVar.PRODUCT_ID}')"> <s:property value="#productsVar.PRODUCT_NAME"/>
					            	<i class="material-icons right">create</i>
					            </button>
							</td>
				            <td class="dt-body-center">
				            	<s:property value="%{#productsVar.QUANTITY-#productsVar.SOLD_CNT-#productsVar.DAMAGED_CNT}"/>
				            </td>
				            <td class="dt-body-center">
				             	<s:property value="#productsVar.SOLD_CNT"/>
				            </td>
				            <td class="dt-body-center">
				            	<s:property value="#productsVar.DAMAGED_CNT"/>
				            </td>
							<td class="dt-body-center">
				             	<s:property value="#productsVar.PRODUCT_AMOUNT"/>
				            </td>
				            <td class="dt-body-center">
				             	<a class="btn waves-effect waves-light red" onclick="loadLink('${pageContext.request.contextPath}/stocks/delete?productId=${productsVar.PRODUCT_ID}')">
									<i class="material-icons">delete_forever</i>
								</a>
							</td>
				        </tr>
					</s:iterator>
			    </tbody>
			</table>
		</div>
		
	</div>
</div>
<div id="modal1" class="modal modal-height-large">
	<div id="modal-nested-loader-wrapper" class="nested-loader-wrapper">
		<div id="modal-nested-loader" class="nested-loader"></div>
	</div>
	<div class="modal-content">
		<div id="modalContent"></div>
	</div>
</div>

<script type="text/javascript">

function closeModal() {
	$('#modalContent').html("");
	$('#modal1').modal('close');
}

function editStock(productId) {
	$('#modalContent').html('');
	ajaxCallModal('modal1', 'modalContent', '${pageContext.request.contextPath}/stocks/edit?productId=' + productId);
}

</script>
