<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="red-text">
	<s:if test="hasActionErrors()">
		<ul class="collection">
			<li class="collection-item avatar" style="min-height: 60px;">
				<i class="material-icons circle red">error_outline</i>
				<s:iterator var="actionErr" value="actionErrors">
					<div><s:property value="#actionErr"/></div>
				</s:iterator>
			</li>
		</ul>
	</s:if>
</div>